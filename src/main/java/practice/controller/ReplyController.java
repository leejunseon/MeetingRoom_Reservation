package practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import practice.domain.Replies;
import practice.domain.ReplyPagingDto;
import practice.domain.ReplyVO;
import practice.service.ReplyService;

@RestController
@RequestMapping("/replies/")
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping(value="/new",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> register(@RequestBody ReplyVO vo) throws Exception{
		int insertCount=service.register(vo);
		return insertCount==1?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/pages/{bno}/{page}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Replies> getReplies(@PathVariable("page")int page,@PathVariable("bno")Long bno) throws Exception{
		ReplyPagingDto paging=new ReplyPagingDto(page,10);
		return new ResponseEntity<>(service.getReplies(bno, paging),HttpStatus.OK);
	}
	
	@GetMapping(value="/{rno}",produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno")Long rno) throws Exception{
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	@PreAuthorize("principal.username==#vo.replyer")
	@DeleteMapping(value="/{rno}",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@RequestBody ReplyVO vo,@PathVariable("rno")Long rno) throws Exception{
		return service.remove(rno)==1?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PreAuthorize("principal.username==#vo.replyer")
	@RequestMapping(method= {RequestMethod.PUT,RequestMethod.PATCH},value="/{rno}",consumes="application/json",produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>modify(@RequestBody ReplyVO vo,@PathVariable("rno")Long rno) throws Exception{
		return service.modify(vo)==1?new ResponseEntity<>("success",HttpStatus.OK):new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
