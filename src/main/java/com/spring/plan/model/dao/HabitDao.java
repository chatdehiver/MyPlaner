package com.spring.plan.model.dao;

import com.spring.plan.model.vo.Habit;

public interface HabitDao {
	
	// habit �߰� :: index.jsp ����
	int addHabit(Habit habit) throws Exception;
	
	// habit ����
	int deleteHabit(Habit habit) throws Exception;
	
	// üũ and üũ ���� (tracker����)
	int checkHabit(Habit habit,String day) throws Exception;
	
	// �ش� ���� habit üũ�� ��� return
	String getHabitCheckByMonth(Habit habit,String month) throws Exception;  //getHabitCheckByWeek�� �� method�� 
	

}
