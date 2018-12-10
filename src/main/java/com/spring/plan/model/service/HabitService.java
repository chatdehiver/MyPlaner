package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Habit;

public interface HabitService {
   // habit �߰� :: index.jsp ����
   int addHabit(Habit habit) throws Exception;

   // habit ����
   int deleteHabit(Habit habit) throws Exception;

   // üũ and üũ ���� (tracker����)
   int checkHabit(Habit habit, String day) throws Exception;

   // �ش� ���� habit üũ�� ��� return
   CheckHabit getCheckHabitByMonth(CheckHabit checkHabit) throws Exception; // getHabitCheckByWeek�� �� method��
   
   // ����� habit ������
   List<Habit> getHabitList(int memberNo) throws Exception;

}
