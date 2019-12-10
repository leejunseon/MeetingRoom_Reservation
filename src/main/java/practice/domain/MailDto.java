package practice.domain;

import lombok.Data;

@Data
public class MailDto {

	private String from;
	private String to;
	private String title;
	private String content;
}