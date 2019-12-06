package practice.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import practice.domain.Replies;
import practice.domain.ReplyPagingDto;
import practice.domain.ReplyVO;
import practice.mapper.BoardMapper;
import practice.mapper.ReplyMapper;

@Service
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService{
	
	private ReplyMapper mapper;
	private BoardMapper boardMapper;

	@Override
	public int register(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		boardMapper.updateReplyCnt(vo.getBno(), 1);
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) throws Exception {
		// TODO Auto-generated method stub
		ReplyVO vo=mapper.read(rno);
		boardMapper.updateReplyCnt(vo.getBno(), -1);
		return mapper.delete(rno);
	}

	@Override
	public Replies getReplies(Long bno, ReplyPagingDto paging) throws Exception {
		// TODO Auto-generated method stub
		return new Replies(mapper.getCountByBno(bno),mapper.getReplies(bno,paging));
	}

}
