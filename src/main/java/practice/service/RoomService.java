package practice.service;

import java.util.List;

import practice.domain.BoardPagingDto;
import practice.domain.RoomDto;

public interface RoomService {
	
	public void register(RoomDto room) throws Exception;
	
	public RoomDto get(Long bno) throws Exception;
	
	public boolean modify(RoomDto board) throws Exception;
	
	public boolean remove(Long bno) throws Exception;
	
	public List<RoomDto> getList(BoardPagingDto paging) throws Exception;

	public int getTotal() throws Exception;
}
