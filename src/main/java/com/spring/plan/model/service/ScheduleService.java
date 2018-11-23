package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Schedule;

public interface ScheduleService {

	// ���ǿ� ���� Schedule return 
	List<Schedule> getScheduleBy() throws Exception;
	
	// schedule �߰�
	int addSchedule(Schedule schedule) throws Exception;
	
	// schedule ����
	int deleteSchedule(int scheduleNo) throws Exception;
	
	// schedule ����
	int updateSchedule(Schedule schedule) throws Exception;
}
