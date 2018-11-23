package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Message;

public interface MessageDao {
	
	// ���� �޼��� list (paging)
	List<Message> getSendMessageList(String nickname) throws Exception;
	
	// ���� �޼��� list (paging)
	List<Message> getMessageList(String nickname) throws Exception;
	
	// �޼��� ����
	int deleteMessage(int messageNo) throws Exception;
	
	// messageNo�� ���� �޼��� ���� return 
	Message getMessage(int messageNo) throws Exception;
	
	// �޼��� ������ :: db�� ���
	int sendMessage(Message message) throws Exception;		
} 
