package practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import practice.domain.BoardPagingDto;
import practice.domain.RoomDto;
import practice.mapper.RoomMapper;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

	private RoomMapper mapper;
	
	@Override
	public void register(RoomDto board) throws Exception{
		// TODO Auto-generated method stub
		mapper.insert(board);
	}

	@Override
	public RoomDto get(Long bno) throws Exception{
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(RoomDto board) throws Exception{
		// TODO Auto-generated method stub
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) throws Exception{
		// TODO Auto-generated method stub
		return mapper.delete(bno)==1;
	}

	@Override
	public List<RoomDto> getList(BoardPagingDto paging) throws Exception{
		// TODO Auto-generated method stub
		return mapper.getList(paging);
	}

	@Override
	public int getTotal() throws Exception{
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}

}
