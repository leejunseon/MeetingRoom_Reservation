package practice.service;

import java.util.List;

import practice.domain.ScheduleDto;

public interface ScheduleService {

	int add(ScheduleDto schedule) throws Exception;

	List<ScheduleDto> get(String start, String end) throws Exception;

	int update(ScheduleDto schedule) throws Exception;

	int delete(int sno) throws Exception;

}
