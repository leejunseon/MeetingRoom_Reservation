package practice.service;

import practice.domain.MemberVO;

public interface MemberService {

	public int insertUser(MemberVO vo);

	public int updatePassword(MemberVO member);
	
}
