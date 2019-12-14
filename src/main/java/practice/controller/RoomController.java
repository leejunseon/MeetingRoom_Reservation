package practice.controller;

import java.util.List;

import org.springframework.http.MediaType;
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
import practice.domain.RoomDto;
import practice.domain.DataTableDto;
import practice.service.RoomService;

@Controller
@RequestMapping("/room/*")
@AllArgsConstructor
public class RoomController {
	
	private RoomService service;
	
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
	    //0 : rno
	    //1 : name
	    //2 : min_time
	    //3 : max_time
	    //4 : weekend
	    
	    int total = service.getTotal(); 
	    List<RoomDto> data = service.getList(paging); 

	    dto.setDraw(draw); 
	    dto.setRecordsFiltered(total); 
	    dto.setRecordsTotal(total); 
	    dto.setData(data); 

	    return dto;
	}
	
	@GetMapping("/list")
	public void list() throws Exception{

	}
	
	@GetMapping("/register")
	public void register() throws Exception{

	}
	
	@PostMapping("/register")
	public String register(RoomDto room,RedirectAttributes rttr) throws Exception{
		service.register(room);
		rttr.addFlashAttribute("result",room.getRno());
		return "redirect:/room/list";
	}

	@GetMapping({"/get","/modify"})
	public void get(Long rno,Model model) throws Exception{
		model.addAttribute("room",service.get(rno));
	}
}
