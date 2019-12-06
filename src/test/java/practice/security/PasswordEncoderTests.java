package practice.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PasswordEncoderTests {
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	/*@Test
	public void testEncode() {
		String str="member";
		String enStr=pwEncoder.encode(str);
		log.info(enStr);
	}*/
}
