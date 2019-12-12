package practice.domain;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RoomDto {
	
	private Long rno;
	private String name;
	
	@DateTimeFormat(pattern = "h:mm a")
	private LocalDateTime minTime;
	@DateTimeFormat(pattern = "h:mm a")
	private LocalDateTime maxTime;
	
	private String weekend;
}
