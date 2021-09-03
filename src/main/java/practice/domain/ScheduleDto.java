package practice.domain;

import lombok.Data;

@Data
public class ScheduleDto {

	private int rno;
	private int sno;
	private int bno;
	private String writer;
	private String title;
	private String sDate;
	private String startTime;
	private String endTime;
	
	private String start;
	private String end;
	
}
