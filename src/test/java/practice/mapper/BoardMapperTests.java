package practice.mapper;

import java.util.List;

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
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper.toString());
	}
	
	/*@Test
	public void testGetList() throws Exception{
		List<BoardVO> list=mapper.getList();
		for(BoardVO vo:list) {
			log.info(vo.toString());
		}
	}*/
	
	/*@Test
	public void testInsert() throws Exception{
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성하는 글");
		board.setContent("새로 작성하는 내용");
		board.setWriter("newbie");
		
		mapper.insert(board);
		
		log.info(board.toString());
	}*/
	
	/*@Test
	public void testRead() throws Exception{
		BoardVO board=mapper.read(2L);
		log.info(board.toString());
	}*/
	
	/*@Test
	public void testDelete() throws Exception{
		log.info("delete count: "+mapper.delete(4L));
	}*/
	
	/*@Test
	public void testUpdate() throws Exception {
		BoardVO board=new BoardVO();
		
		board.setBno(1L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int count=mapper.update(board);
		log.info("update count: "+count);
	}*/
}
