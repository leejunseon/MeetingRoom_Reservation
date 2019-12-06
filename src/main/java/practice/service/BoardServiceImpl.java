package practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import practice.domain.BoardPagingDto;
import practice.domain.BoardVO;
import practice.mapper.BoardMapper;

@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) throws Exception{
		// TODO Auto-generated method stub
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) throws Exception{
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) throws Exception{
		// TODO Auto-generated method stub
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) throws Exception{
		// TODO Auto-generated method stub
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList(BoardPagingDto paging) throws Exception{
		// TODO Auto-generated method stub
		return mapper.getList(paging);
	}

	@Override
	public int getTotal() throws Exception{
		// TODO Auto-generated method stub
		return mapper.getTotal();
	}

}
