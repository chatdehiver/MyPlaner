package com.spring.plan.model.vo;

public class BoardComment {
	private String nickname;
	private String comment;
	private String replyComment;
	private String writeDate;
	
	public BoardComment() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getReplyComment() {
		return replyComment;
	}
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
}
