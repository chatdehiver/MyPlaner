package com.spring.plan.model.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class Board {
	private String boardTitle;							
	private String boardWriteDate;
	private String boardContent;
	private String memberNo;
	private int boardLikes;
	private int boardHits;
	private int boardNo;
	private List<String> boardPictures;
	private List<BoardComment> boardCommentList;
	
	// ���̺� ����
	private Member member;
	
	// �߰��Ǵ� �÷�
	private String orgfilename;
	private String newfilename;

	// upload ������ ������ ��� �ʵ带 ����
	private MultipartFile uploadFile;
			
	public Board(){}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)
	
	public Board(String boardTitle, String boardWriteDate, String boardContent, int boardLikes, int boardHits,
			int boardNo, List<String> boardPictures, List<BoardComment> boardCommentList) {
		super();
		this.boardTitle = boardTitle;
		this.boardWriteDate = boardWriteDate;
		this.boardContent = boardContent;
		this.boardLikes = boardLikes;
		this.boardHits = boardHits;
		this.boardNo = boardNo;
		this.boardPictures = boardPictures;
		this.boardCommentList = boardCommentList;
	}
	//member
	public Board(String boardTitle, String boardWriteDate, String boardContent, int boardLikes, int boardHits,
			int boardNo, List<String> boardPictures, List<BoardComment> boardCommentList, Member member) {
		super();
		this.boardTitle = boardTitle;
		this.boardWriteDate = boardWriteDate;
		this.boardContent = boardContent;
		this.boardLikes = boardLikes;
		this.boardHits = boardHits;
		this.boardNo = boardNo;
		this.boardPictures = boardPictures;
		this.boardCommentList = boardCommentList;
		this.member = member;
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriteDate() {
		return boardWriteDate;
	}

	public void setBoardWriteDate(String boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardLikes() {
		return boardLikes;
	}

	public void setBoardLikes(int boardLikes) {
		this.boardLikes = boardLikes;
	}

	public int getBoardHits() {
		return boardHits;
	}

	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public List<String> getBoardPictures() {
		return boardPictures;
	}

	public void setBoardPictures(List<String> boardPictures) {
		this.boardPictures = boardPictures;
	}

	public List<BoardComment> getBoardCommentList() {
		return boardCommentList;
	}

	public void setBoardCommentList(List<BoardComment> boardCommentList) {
		this.boardCommentList = boardCommentList;
	}
	

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	@Override
	public String toString() {
		return "Board [boardTitle=" + boardTitle + ", boardWriteDate=" + boardWriteDate + ", boardContent="
				+ boardContent + ", boardLikes=" + boardLikes + ", boardHits=" + boardHits + ", boardNo=" + boardNo
				+ ", boardPictures=" + boardPictures + ", boardCommentList=" + boardCommentList + "]";
	}
	
	
}
