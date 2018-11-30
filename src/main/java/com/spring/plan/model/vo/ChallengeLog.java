package com.spring.plan.model.vo;

public class ChallengeLog {
	private int challengeNo;
	private String challengeLogContent;
	private int dayCount;
	
	public ChallengeLog() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)
	public ChallengeLog(int challengeNo, String challengeLogContent, int dayCount) {
		super();
		this.challengeNo = challengeNo;
		this.challengeLogContent = challengeLogContent;
		this.dayCount = dayCount;
	}//����..updateChallengeLog

	public int getChallengeNo() {
		return challengeNo;
	}
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	
	public String getChallengeLogContent() {
		return challengeLogContent;
	}

	public void setChallengeLogContent(String challengeLogContent) {
		this.challengeLogContent = challengeLogContent;
	}

	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}

	@Override
	public String toString() {
		return "ChallengeLog [challengeNo=" + challengeNo + ", challengeLogContent=" + challengeLogContent
				+ ", dayCount=" + dayCount + "]";
	}
}
