package com.spring.plan.model.vo;

public class ChallengeContent {
	private int challengeNo;
	private String challengeContent;
	private String challengeContentCheck;
	
	public ChallengeContent() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)
	public ChallengeContent(int challengeNo, String challengeContent) {
		super();
		this.challengeNo = challengeNo;
		this.challengeContent = challengeContent;
	}//���� /addChallengeContent

	public ChallengeContent(int challengeNo, String challengeContent) {
		this.challengeNo = challengeNo;
		this.challengeContent = challengeContent;
	}

	public int getChallengeNo() {
		return challengeNo;
	}
	
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	public String getChallengeContent() {
		return challengeContent;
	}
	public void setChallengeContent(String challengeContent) {
		this.challengeContent = challengeContent;
	}
	public String getChallengeContentCheck() {
		return challengeContentCheck;
	}
	public void setChallengeContentCheck(String challengeContentCheck) {
		this.challengeContentCheck = challengeContentCheck;
	}
	
	
}
