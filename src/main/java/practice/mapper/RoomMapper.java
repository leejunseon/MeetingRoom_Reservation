package practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import practice.domain.BoardPagingDto;
import practice.domain.RoomDto;

@Mapper
public interface RoomMapper {

	public List<RoomDto> getList(BoardPagingDto paging) throws Exception;
	
	public void insert(RoomDto board) throws Exception;
	
	public RoomDto read(Long bno) throws Exception;
	
	public int delete(Long bno) throws Exception;
	
	public int update(RoomDto board) throws Exception;

	public int getTotal() throws Exception;
	
	public void updateReplyCnt(@Param("bno")Long bno,@Param("amount")int amount) throws Exception;
}
