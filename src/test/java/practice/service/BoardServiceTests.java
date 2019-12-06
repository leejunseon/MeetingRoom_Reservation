package practice.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import practice.domain.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	/*@Test
	public void testExist() {
		log.info(service.toString());
		assertNotNull(service);
	}*/
	
	/*@Test
	public void testRegister() {
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		service.register(board);
		log.info("생성된 게시물 번호: "+board.getBno());
	}*/
	
	/*@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board.toString()));
	}*/
	
	/*@Test
	public void testGet() {
		log.info(service.get(1L).toString());
	}*/
	
	/*@Test
	public void testDelete() {
		log.info("REMOVE RESULT: "+service.remove(2L));
	}*/
	
	/*@Test
	public void testUpdate() {
		BoardVO board=service.get(1L);
		
		if(board==null)
			return;
		
		board.setTitle("제목 수정!!");
		log.info("MODIFY RESULT: "+service.modify(board));
	}*/
	
}
