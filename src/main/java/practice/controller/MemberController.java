package practice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import practice.domain.MemberDto;
import practice.service.MemberService;


@Controller
@RequestMapping("/member")
@AllArgsConstructor
@Slf4j
public class MemberController {
	
	private MemberService service;
	private BCryptPasswordEncoder pwencoder;
	
	@GetMapping("/register")
	public void register(MemberDto member) {
		
	}
	
	@PostMapping("/register")
	public String register(@Valid MemberDto member,BindingResult result,String repeatpw,RedirectAttributes rttr,Model model) {
		String resultPage="";
		
		if(result.hasErrors()) {
			//validation error
			log.info("Validation Error");
			List<ObjectError> list=result.getAllErrors();
			for(ObjectError error:list) {
				log.info(error.getDefaultMessage());
			}
			resultPage= "/member/register";
		}else if(!member.getUserpw().equals(repeatpw)) {
			//비밀번호 확인 error
			log.info("Repeat error");
			model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
			resultPage= "/member/register";
		}else {
			int insert=service.insertUser(member);
			if(insert==1) {
				//정상 입력
				log.info("Register success");
				rttr.addFlashAttribute("result","회원가입이 완료되었습니다.");
				resultPage= "redirect:/customLogin";
			}else if(insert==-1) {
				//중복 아이디
				log.info("ID reduplicate error");
				model.addAttribute("error",member.getUserid()+"는 중복되는 아이디입니다. 다른 아이디를 사용해주세요.");
				resultPage= "/member/register";
			}
		}
		
		return resultPage;
	}
	
	@GetMapping("/findPassword")
	public void findPassword() {
		
	}
	
	@GetMapping("/resetPassword")
	public void resetPassword(String id,Model model) {
		log.info("아이디 : "+id);
		model.addAttribute("userid",id);
	}
	
	@PostMapping("/resetPassword")
	public String resetPassword(MemberDto member,RedirectAttributes rttr) {
		String resultPage="";
		member.setUserpw(pwencoder.encode(member.getUserpw()));
		if(service.updatePassword(member)==1) {
			rttr.addFlashAttribute("result","비밀번호가 업데이트되었습니다.");
			resultPage="redirect:/customLogin";
		}
		
		return resultPage;
	}
}
