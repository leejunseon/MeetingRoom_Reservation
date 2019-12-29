package practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import practice.domain.ScheduleDto;
import practice.mapper.ScheduleMapper;

@Service
@AllArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

	ScheduleMapper mapper;
	
	@Override
	public int add(ScheduleDto schedule) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(schedule);
	}

	@Override
	public List<ScheduleDto> get(String start, String end) throws Exception {
		// TODO Auto-generated method stub
	    int startDate=
	    		Integer.parseInt(start.substring(0,4))*10000+
	    		Integer.parseInt(start.substring(5,7))*100+
	    		Integer.parseInt(start.substring(8,10));
	    int endDate=
	    		Integer.parseInt(end.substring(0,4))*10000+
	    		Integer.parseInt(end.substring(5,7))*100+
	    		Integer.parseInt(end.substring(8,10));
	    
	    List<ScheduleDto> result=mapper.get(startDate,endDate);
	    for(ScheduleDto schedule:result) {
	    	//sDate, startTime, endTime 으로 양식 바꾸기
	    }
	    /*
	    "start": "2019-05-07T09:30",
	    "end": "2019-05-07T15:00",
	    */
		return result;
	}

	@Override
	public int update(ScheduleDto schedule) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(schedule);
	}

	@Override
	public int delete(int sno) throws Exception {
		// TODO Auto-generated method stub
		return mapper.remove(sno);
	}

}
