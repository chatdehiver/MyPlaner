package com.spring.plan.model.vo;

import java.util.List;

public class Daily {
	private String nickname;
	private String date; // YYYY.MM.DD
	private String memo;
	private String emotion;
	
	private List<Challenge> challengeList;
	private List<Schedule> scheduleList;
	
	public Daily() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public List<Challenge> getChallengeList() {
		return challengeList;
	}
	public void setChallengeList(List<Challenge> challengeList) {
		this.challengeList = challengeList;
	}
	public List<Schedule> getScheduleList() {
		return scheduleList;
	}
	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	
	
}
