package com.spring.plan.model.vo;

import java.util.Map;

public class Habit {
	private String nickname;
	private String habit;
	private String habitStartDate;
	private String habitEndDate;
	private Map<String, String> habitCheckByMonth; //YYYY.MM �� Habit üũ���� �ִ� Field
	
	public Habit() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	
	public String getHabitStartDate() {
		return habitStartDate;
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

	public Map<String, String> getHabitCheckByMonth() {
		return habitCheckByMonth;
	}
	public void setHabitCheckByMonth(Map<String, String> habitCheckByMonth) {
		this.habitCheckByMonth = habitCheckByMonth;
	}

	@Override
	public String toString() {
		return "Habit [nickname=" + nickname + ", habit=" + habit + ", habitStartDate=" + habitStartDate
				+ ", habitEndDate=" + habitEndDate + ", habitCheckByMonth=" + habitCheckByMonth + "]";
	}
	
	
	
}
