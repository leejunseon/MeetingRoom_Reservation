package practice.domain;

import lombok.Data;

@Data
public class RoomDto {
	
	private Long rno;
	private String name;
	private String minTime;
	private String maxTime;
	private int transformedMinTime;
	private int transformedMaxTime;
	private String weekend;
}
