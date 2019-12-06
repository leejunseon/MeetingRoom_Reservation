package practice.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import practice.domain.AuthVO;
import practice.domain.MemberVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberMapperTests {

	@Autowired
	private MemberMapper mapper;
	
	@Autowired
	private PasswordEncoder pwencoder;
	
	/*@Test
	public void testMapper() {
		log.info(mapper.toString());
	}*/
	
	@Test
	public void testRead() {
		MemberVO vo=mapper.read("asdf");
		if(vo!=null) {
			log.info(vo.toString());
			for(AuthVO auth:vo.getAuthList()) {
				log.info(auth.toString());
			}
		}else {
			log.info(null);
		}
	}
	
	/*@Test
	public void testInsertMember() {
		MemberVO vo=new MemberVO();
		vo.setUserid("sme0414");
		vo.setUserpw(pwencoder.encode("tlsaldms"));
		vo.setUserName("신미은");
		vo.setEmail("sme0414@naver.com");
		mapper.insertMember(vo);
	}*/
	
	/*@Test
	public void testInsertAuth() {
		AuthVO auth=new AuthVO();
		auth.setUserid("sme0414");
		auth.setAuth("user");
		mapper.insertAuth(auth);
	}*/
}
