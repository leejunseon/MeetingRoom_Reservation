package practice.mapper;

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
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper;
	
	/*@Test
	public void testMapper() {
		log.info(mapper.toString());
	}*/
	
	/*@Test
	public void testCreate() throws Exception{
		for(Long i=20L;i<=22L;i++) {
			ReplyVO vo=new ReplyVO();
			vo.setBno(i);
			vo.setReply("댓글 테스트~~"+i);
			vo.setReplyer("replyer"+i);
			mapper.insert(vo);
		}
	}*/
	
	/*@Test
	public void testRead() throws Exception {
		Long targetRno=1L;
		ReplyVO vo=mapper.read(targetRno);
		log.info(vo.toString());
	}*/
	
	/*@Test
	public void testDelete() throws Exception {
		Long targetRno=1L;
		mapper.delete(targetRno);
	}*/
	
	/*@Test
	public void testUpdate() throws Exception {
		Long targetRno=2L;
		ReplyVO vo=mapper.read(targetRno);
		vo.setReply("Update Reply");
		int count=mapper.update(vo);
		log.info("Update count: "+count);
	}*/
	
	/*@Test
	public void testGetReplies() throws Exception{
		Long bno=20L;
		ReplyPagingDto paging=new ReplyPagingDto(1,10);
		List<ReplyVO> list=mapper.getReplies(bno, paging);
		for(ReplyVO vo:list) {
			log.info(vo.toString());
		}
	}*/
}
