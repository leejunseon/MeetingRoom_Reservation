package practice.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;
import practice.domain.MemberVO;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MemberServiceTests {

	@Autowired
	private MemberService service;
	
	@Autowired
	private PasswordEncoder pwencoder;
	
	/*@Test
	public void testExist() {
		log.info(service.toString());
		assertNotNull(service);
	}*/
	
	/*@Test
	public void testInsertUser() {
		MemberVO vo=new MemberVO();
		vo.setUserid("sme0414");
		vo.setUserpw(pwencoder.encode("dkxltmxm135"));
		vo.setUserName("신미은");
		vo.setEmail("sme0414@naver.com");
		service.insertUser(vo);
	}*/
}
