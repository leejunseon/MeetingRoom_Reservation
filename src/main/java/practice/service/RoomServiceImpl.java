package practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import practice.domain.BoardPagingDto;
import practice.domain.RoomDto;
import practice.mapper.RoomMapper;
import practice.util.TimeTransformUtil;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService{

	private RoomMapper mapper;
	private TimeTransformUtil timeTransformer;
	
	@Override
	public void register(RoomDto room) throws Exception{
		// TODO Auto-generated method stub
		room.setTransformedMinTime(timeTransformer.toInteger(room.getMinTime()));
		room.setTransformedMaxTime(timeTransformer.toInteger(room.getMaxTime()));
		mapper.insert(room);
	}

	@Override
	public RoomDto get(Long rno) throws Exception{
		// TODO Auto-generated method stub
		RoomDto room=mapper.read(rno);
		room.setMinTime(timeTransformer.toTime(room.getTransformedMinTime()));
		room.setMaxTime(timeTransformer.toTime(room.getTransformedMaxTime()));
		return room;
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
		List<RoomDto> result=mapper.getList(paging);
		for(RoomDto room:result) {
			room.setMinTime(timeTransformer.toTime(room.getTransformedMinTime()));
			room.setMaxTime(timeTransformer.toTime(room.getTransformedMaxTime()));
		}
		return result;
	}

	@Override
	public int getTotal() throws Exception{
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}

}
