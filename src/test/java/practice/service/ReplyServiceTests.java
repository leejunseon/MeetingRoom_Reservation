package practice.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import practice.domain.ReplyPagingDto;
import practice.domain.ReplyVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ReplyServiceTests {

	@Autowired
	private ReplyService service;
	
	/*@Test
	public void testExist() {
		log.info(service.toString());
	}*/
	
	/*@Test
	public void testRegister() throws Exception{
		for(Long i=20L;i<=22L;i++) {
			ReplyVO vo=new ReplyVO();
			vo.setBno(i);
			vo.setReply("서비스테스트~~"+i);
			vo.setReplyer("replyer"+i);
			service.register(vo);
		}
	}*/
	
	/*@Test
	public void testGet() throws Exception{
		Long rno=10L;
		ReplyVO vo=service.get(rno);
		log.info(vo.toString());
	}*/
	
	/*@Test
	public void testModify() throws Exception{
		ReplyVO vo=service.get(10L);
		vo.setReply("수정테스트!");
		service.modify(vo);
	}*/
	
	/*@Test
	public void testRemove() throws Exception{
		Long rno=16L;
		int count=service.remove(rno);
		log.info("remove count: "+count);
	}*/
	
	/*@Test
	public void testGetReplies() throws Exception{
		Long bno=20L;
		ReplyPagingDto paging=new ReplyPagingDto(1,10);
		List<ReplyVO> list=service.getReplies(bno, paging);
		for(ReplyVO vo:list) {
			log.info(vo.toString());
		}
	}*/

}
