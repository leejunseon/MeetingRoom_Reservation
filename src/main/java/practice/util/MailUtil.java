package practice.util;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import practice.domain.MailDto;

@Component
@Slf4j
public class MailUtil {

	private JavaMailSender mailSender;
	
	public boolean send(MailDto mail) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
	    	MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
	 
	    	messageHelper.setFrom(mail.getFrom());  // 보내는사람 생략하거나 하면 정상작동을 안함
	    	messageHelper.setTo(mail.getTo());     // 받는사람 이메일
	    	messageHelper.setSubject(mail.getTitle()); // 메일제목은 생략이 가능하다
	    	messageHelper.setText(mail.getContent(),true);  // 메일 내용
	     
	    	log.info("메일 전송 : "+mail.toString());
	    	mailSender.send(message);
	    } catch(Exception e){
	    	log.info(e.toString());
	    	return false;
	    }
		return true;
	}
}
