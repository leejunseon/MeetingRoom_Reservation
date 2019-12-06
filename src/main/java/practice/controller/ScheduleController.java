package practice.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import practice.domain.ScheduleVO;
import practice.service.ScheduleService;

@Controller
@RequestMapping("/schedule/*")
@AllArgsConstructor
public class ScheduleController {

	private ScheduleService service;
	
	@PostMapping("/add")
	@PreAuthorize("isAuthenticated()")
	public String add(ScheduleVO schedule,RedirectAttributes rttr) throws Exception{
		service.add(schedule);
		rttr.addFlashAttribute("result",schedule.getTitle());
		return "redirect:/board/get?bno="+schedule.getBno();
	}
	
	@GetMapping(value="/get", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	public List<ScheduleVO> get(String start,String end) throws Exception{
		return service.get(start,end);
	}
	
	@PutMapping(value="/update",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	public int update(ScheduleVO schedule) throws Exception{
		return service.update(schedule);
	}
	
	@DeleteMapping(value="/remove",produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PreAuthorize("isAuthenticated()")
	@ResponseBody
	public int remove(ScheduleVO schedule) throws Exception{
		return service.delete(schedule.getSno());
	}
}
