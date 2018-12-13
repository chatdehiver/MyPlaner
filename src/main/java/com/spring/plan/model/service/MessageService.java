package com.spring.plan.model.service;

import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.vo.Message;

public interface MessageService {
	
	// ���� �޼��� list (paging)
	MessageListVO getSendMessageList(int memberNo, int spageNo) throws Exception;
	
	// ���� �޼��� list (paging)
	MessageListVO getMessageList(int memberNo, int rpageNo) throws Exception;
	
	// �޼��� ����
	int deleteMessage(int messageNo) throws Exception;
	
	// messageNo�� ���� �޼��� ���� return 
	Message getMessage(int messageNo) throws Exception;
	
	// �޼��� ������ :: db�� ���
	int sendMessage(Message message) throws Exception;		
	
	
} 
