package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Schedule;

public interface ScheduleDao {

	// ���� Schedule return 
	List<Schedule> getScheduleByDay(String day) throws Exception;
	
	// ��� Schedule return
	List<Schedule> getScheduleByMonth(String month) throws Exception;
	
	// schedule �߰�
	int addSchedule(Schedule schedule) throws Exception;
	
	// schedule ����
	int deleteSchedule(int scheduleNo) throws Exception;
	
	// schedule ����
	int updateSchedule(Schedule schedule) throws Exception;
}
