package practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import practice.domain.AuthVO;
import practice.domain.MemberVO;

@Mapper
public interface MemberMapper {

	public MemberVO read(String userid);
	
	public int insertMember(MemberVO member);
	
	public int insertAuth(AuthVO auth);
	
	public int getEmail(@Param("id")String id,@Param("email")String email);

	public int updatePassword(MemberVO member);
}
