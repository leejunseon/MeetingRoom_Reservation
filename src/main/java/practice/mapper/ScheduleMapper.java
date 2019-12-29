package practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import practice.domain.ScheduleDto;

@Mapper
public interface ScheduleMapper {

	int add(ScheduleDto schedule) throws Exception;

	List<ScheduleDto> get(@Param("start") int startDate, @Param("end")int endDate)throws Exception;

	int update(ScheduleDto schedule) throws Exception;

	int remove(int sno) throws Exception;

}
