package practice.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class MemberDto {
	
	@NotBlank(message = "Id is mandatory")
	private String userid;
	
	@NotBlank(message = "Password is mandatory")
	private String userpw;
	
	@NotBlank(message = "Name is mandatory")
	private String userName;
	
	@NotBlank(message = "Email is mandatory")
	private String email;
	
	private boolean enabled;
	private Date regDate;
	private Date updateDate;
	private List<AuthDto> authList;
	
}
