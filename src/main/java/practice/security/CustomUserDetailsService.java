package practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import practice.domain.MemberVO;
import practice.mapper.MemberMapper;
import practice.security.domain.CustomUser;

@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Setter(onMethod_= {@Autowired})
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		log.warn("Load user by username : "+username);
		MemberVO vo=memberMapper.read(username);
		log.warn("Queried by member mapper : "+vo);
		return vo==null?null:new CustomUser(vo);
	}

}
