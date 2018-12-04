package com.spring.plan.model.vo;

import java.util.List;

public class Habit {
   private int memberNo;
   private String habit;
   private String habitStartDate;
   private String habitEndDate;
   private List<CheckHabit> checkHabitList; //YYYY.MM �� Habit üũ���� �ִ� Field
   
   public Habit() {}
   
   //////���⿡ ������ �߰�(�����������  *��*��*)

   

   public int getMemberNo() {
      return memberNo;
   }

   public void setMemberNo(int memberNo) {
      this.memberNo = memberNo;
   }


   public String getHabitStartDate() {
      return habitStartDate;
   }
   public String getStartMonth() {
      return habitStartDate.substring(0,6);
   }

   public void setHabitStartDate(String habitStartDate) {
      this.habitStartDate = habitStartDate;
   }

   public String getHabitEndDate() {
      return habitEndDate;
   }

   public void setHabitEndDate(String habitEndDate) {
      this.habitEndDate = habitEndDate;
   }

   public List<CheckHabit> getCheckHabitList() {
      return checkHabitList;
   }

   public void setCheckHabitList(List<CheckHabit> checkHabitList) {
      this.checkHabitList = checkHabitList;
   }
   

   public String getHabit() {
      return habit;
   }

   public void setHabit(String habit) {
      this.habit = habit;
   }

   @Override
   public String toString() {
      return "Habit [memberNo=" + memberNo + ", habit=" + habit + ", habitStartDate=" + habitStartDate
            + ", habitEndDate=" + habitEndDate + ", checkHabitList=" + checkHabitList + "]";
   }

   

}