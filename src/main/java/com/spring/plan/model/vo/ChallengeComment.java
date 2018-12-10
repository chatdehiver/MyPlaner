package com.spring.plan.model.vo;

public class ChallengeComment {

	private int challengeCommentNo;
	private int challengeReplyComment;
	private int challengeNo;
	private int challengeCommentMemberNo;
	private String challengeComment;
	private String challengeCommentWriteDate;
	
	public ChallengeComment() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)
	public ChallengeComment(int challengeCommentNo, int challengeReplyComment, int challengeNo,
			int challengeCommentMemberNo, String challengeComment, String challengeCommentWriteDate) {
		super();
		this.challengeCommentNo = challengeCommentNo;
		this.challengeReplyComment = challengeReplyComment;
		this.challengeNo = challengeNo;
		this.challengeCommentMemberNo = challengeCommentMemberNo;
		this.challengeComment = challengeComment;
		this.challengeCommentWriteDate = challengeCommentWriteDate;
	}//���� addChallengeComment
	
	public int getChallengeCommentNo() {
		return challengeCommentNo;
	}
	public void setChallengeCommentNo(int challengeCommentNo) {
		this.challengeCommentNo = challengeCommentNo;
	}
	
	public int getChallengeNo() {
		return challengeNo;
	}
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}

	public int getChallengeReplyComment() {
		return challengeReplyComment;
	}

	public void setChallengeReplyComment(int challengeReplyComment) {
		this.challengeReplyComment = challengeReplyComment;
	}
	
	public int getChallengeCommentMemberNo() {
		return challengeCommentMemberNo;
	}

	public void setChallengeCommentMemberNo(int challengeCommentMemberNo) {
		this.challengeCommentMemberNo = challengeCommentMemberNo;
	}

	public String getChallengeComment() {
		return challengeComment;
	}

	public void setChallengeComment(String challengeComment) {
		this.challengeComment = challengeComment;
	}

	public String getChallengeCommentWriteDate() {
		return challengeCommentWriteDate;
	}

	public void setChallengeCommentWriteDate(String challengeCommentWriteDate) {
		this.challengeCommentWriteDate = challengeCommentWriteDate;
	}
	@Override
	public String toString() {
		return "ChallengeComment [challengeCommentNo=" + challengeCommentNo + ", challengeReplyComment="
				+ challengeReplyComment + ", challengeNo=" + challengeNo + ", challengeCommentMemberNo="
				+ challengeCommentMemberNo + ", challengeComment=" + challengeComment + ", challengeCommentWriteDate="
				+ challengeCommentWriteDate + "]";
	}
}
