package com.spring.plan.model.vo;

public class Schedule {
	private String scheduleTitle;
	private String scheduleStartDate;
	private String scheduleEndDate;
	private String scheduleContent;
	private String scheduleTag;
	private String scheduleCheck;
	private String scheduleColor;
	
	public Schedule() {}
	
	//////���⿡ ������ �߰�(�����������  *��*��*)

	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(String scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public String getScheduleEndDate() {
		return scheduleEndDate;
	}

	public void setScheduleEndDate(String scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public String getScheduleTag() {
		return scheduleTag;
	}

	public void setScheduleTag(String scheduleTag) {
		this.scheduleTag = scheduleTag;
	}

	public String getScheduleCheck() {
		return scheduleCheck;
	}

	public void setScheduleCheck(String scheduleCheck) {
		this.scheduleCheck = scheduleCheck;
	}

	public String getScheduleColor() {
		return scheduleColor;
	}

	public void setScheduleColor(String scheduleColor) {
		this.scheduleColor = scheduleColor;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleTitle=" + scheduleTitle + ", scheduleStartDate=" + scheduleStartDate
				+ ", scheduleEndDate=" + scheduleEndDate + ", scheduleContent=" + scheduleContent + ", scheduleTag="
				+ scheduleTag + ", scheduleCheck=" + scheduleCheck + ", scheduleColor=" + scheduleColor + "]";
	}
	
}
