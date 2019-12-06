package practice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import practice.domain.BoardPagingDto;
import practice.domain.BoardVO;
import practice.domain.DataTableDto;
import practice.service.BoardService;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@PostMapping(value="/tableSetting",produces=MediaType.APPLICATION_JSON_UTF8_VALUE) 
	@ResponseBody 
	public DataTableDto tableSetting(DataTableDto dto, @RequestBody MultiValueMap<String, String> formData) throws Exception{ 
	    int draw = Integer.parseInt(formData.get("draw").get(0)); 
	    String start = formData.get("start").get(0); 
	    String length = formData.get("length").get(0); 
	    String orderNum=null;
	    String orderDir=null;
	    if(formData.containsKey("order[0][column]")) {
	    	orderNum=formData.get("order[0][column]").get(0);
	    	orderDir=formData.get("order[0][dir]").get(0);
	    }
	    String search=formData.get("search[value]").get(0);
	    
	    BoardPagingDto paging=new BoardPagingDto(start,length,orderNum,orderDir,search);
	    //orderNum
	    //0 : bno
	    //1 : title
	    //2 : writer
	    //3 : regdate
	    //4 : updatedate
	    
	    int total = service.getTotal(); 
	    List<BoardVO> data = service.getList(paging); 

	    dto.setDraw(draw); 
	    dto.setRecordsFiltered(total); 
	    dto.setRecordsTotal(total); 
	    dto.setData(data); 

	    return dto;
	}

	
	@GetMapping("/list")
	public void list() throws Exception{

	}
	
	@GetMapping("/schedule")
	@PreAuthorize("isAuthenticated()")
	public void schedule(BoardVO board,Model model) throws Exception{
		model.addAttribute("board",service.get(board.getBno()));
	}
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void register()throws Exception{
		
	}
	
	@PostMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public String register(BoardVO board,RedirectAttributes rttr) throws Exception{
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(Long bno,Model model) throws Exception{
		model.addAttribute("board",service.get(bno));
	}
	
	@PreAuthorize("principal.username==#board.writer")
	@PostMapping("/modify")
	public String modify(BoardVO board,RedirectAttributes rttr) throws Exception{
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
	
	@PreAuthorize("principal.username==#writer")
	@PostMapping("/remove")
	public String remove(Long bno,RedirectAttributes rttr,String writer) throws Exception{
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}
}
