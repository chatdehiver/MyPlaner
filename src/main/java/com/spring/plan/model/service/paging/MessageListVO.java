package com.spring.plan.model.service.paging;

import java.util.List;

import com.spring.plan.model.vo.Message;


public class MessageListVO {					///	����¡ ó���Ҷ� ��� ���� �ϳ��� �����ؼ� ���� ����� �ʿ��Ҷ����� �̸��� *****ListVO 
	private List<Message> list;
	private PagingBean pb;
	private int memberNo;
	private int pageNo;
	
	
	public MessageListVO(List<Message> list, PagingBean pb, int memberNo) {
		super();
		this.list = list;
		this.pb = pb;
		this.memberNo = memberNo;
	}
	
	public MessageListVO() {}
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public List<Message> getList() {
		return list;
	}
	public void setList(List<Message> list) {
		this.list = list;
	}
	public PagingBean getPb() {
		return pb;
	}
	public void setPb(PagingBean pb) {
		this.pb = pb;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "MessageListVO [list=" + list + ", pb=" + pb + "]";
	}

}
