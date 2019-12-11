package practice.service;

import practice.domain.MemberDto;

public interface MemberService {

	public int insertUser(MemberDto vo);

	public int updatePassword(MemberDto member);
	
}
