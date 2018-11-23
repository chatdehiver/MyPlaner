package com.spring.plan.model.service;

import com.spring.plan.model.vo.Habit;

public interface HabitService {
	// habit �߰� :: index.jsp ����
	int addHabit(Habit habit) throws Exception;

	// habit ����
	int deleteHabit(Habit habit) throws Exception;

	// üũ and üũ ���� (tracker����)
	int checkHabit(Habit habit, String day) throws Exception;

	// �ش� ���� habit üũ�� ��� return
	String getHabitCheckByMonth(Habit habit, String month) throws Exception; // getHabitCheckByWeek�� �� method��
}
