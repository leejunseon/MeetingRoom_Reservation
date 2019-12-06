package practice.service;

import practice.domain.Replies;
import practice.domain.ReplyPagingDto;
import practice.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO vo) throws Exception;
	
	public ReplyVO get(Long rno) throws Exception;
	
	public int modify(ReplyVO vo) throws Exception;
	
	public int remove(Long rno) throws Exception;
	
	public Replies getReplies(Long bno, ReplyPagingDto paging) throws Exception;

}
