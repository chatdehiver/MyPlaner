package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Habit;

public interface HabitDao {
	
	// habit �߰� :: index.jsp ����
	int addHabit(Habit habit) throws Exception;
	
	// habit ����
	int deleteHabit(Habit habit) throws Exception;
	
	// üũ and üũ ���� (tracker����)
	int checkHabit(CheckHabit checkHabit) throws Exception;
	
	// ����� habit ������
	List<Habit> getHabitList(int memberNo) throws Exception;
	
	// �ش� ���� habit üũ�� ��� return
	public CheckHabit getCheckHabitByMonth(CheckHabit checkHabit) throws Exception;  //getHabitCheckByWeek�� �� method�� 
	
	// check habit ���
	int addCheckHabit(CheckHabit checkHabit) throws Exception;
	

}
