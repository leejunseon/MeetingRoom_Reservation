package practice.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import practice.domain.AuthVO;
import practice.domain.MemberVO;
import practice.mapper.MemberMapper;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{
	
	private MemberMapper mapper;
	private PasswordEncoder pwencoder;

	@Override
	public int insertUser(MemberVO vo) {
		// TODO Auto-generated method stub
		if(mapper.read(vo.getUserid())==null) {
			AuthVO auth=new AuthVO();
			vo.setUserpw(pwencoder.encode(vo.getUserpw()));
			int memberNum=mapper.insertMember(vo);
			auth.setUserid(vo.getUserid());
			auth.setAuth("ROLE_USER");
			int authNum=mapper.insertAuth(auth);
			return memberNum==1&&authNum==1?1:0;
		}else {
			return -1;
		}
	}

	@Override
	public int updatePassword(MemberVO member) {
		// TODO Auto-generated method stub
		return mapper.updatePassword(member);
	}

}
