package practice.domain;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;

@Data
public class ScheduleVO {

	private int bno;
	private int sno;
	private String writer;
	private String title;
	private Date startTime;
	private Date endTime;
	private LocalDateTime start;
	private LocalDateTime end;
	
}
