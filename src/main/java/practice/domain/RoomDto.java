package practice.domain;

import java.util.Date;

import lombok.Data;

@Data
public class RoomDto {
	
	private Long rno;
	private String name;
	private Date minTime;
	private Date maxTime;
	private String weekend;
}
