package practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import practice.domain.ReplyPagingDto;
import practice.domain.ReplyVO;

@Mapper
public interface ReplyMapper {
	
	public int insert(ReplyVO vo) throws Exception;
	
	public ReplyVO read(Long rno) throws Exception;
	
	public int delete(Long rno) throws Exception;
	
	public int update(ReplyVO reply) throws Exception;
	
	public List<ReplyVO> getReplies(@Param("bno")Long bno, @Param("paging")ReplyPagingDto paging) throws Exception;
	
	public int getCountByBno(Long bno) throws Exception;
}
