package practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import practice.domain.AuthDto;
import practice.domain.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto read(String userid);
	
	public int insertMember(MemberDto member);
	
	public int insertAuth(AuthDto auth);
	
	public int getEmail(@Param("id")String id,@Param("email")String email);

	public int updatePassword(MemberDto member);
}
