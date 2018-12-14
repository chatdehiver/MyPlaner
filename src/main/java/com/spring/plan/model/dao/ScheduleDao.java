package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Schedule;

public interface ScheduleDao {

	// ���� Schedule return index 1-2
	List<Schedule> getScheduleByDay(Daily daily) throws Exception;
	
	// ��� Schedule return index 1-1
	List<Schedule> getScheduleByMonth(Daily daily) throws Exception;
	
	// index 1-1 �� detail ����
	Schedule getScheduleDetail(int scheduleNo) throws Exception;
	
	// schedule �߰�
	int addSchedule(Schedule schedule) throws Exception;
	
	// schedule ����
	int deleteSchedule(int scheduleNo) throws Exception;
	
	// schedule ����
	int updateSchedule(Schedule schedule) throws Exception;
	
	// check schedule
	int checkSchedule(Schedule schedule) throws Exception;
}
