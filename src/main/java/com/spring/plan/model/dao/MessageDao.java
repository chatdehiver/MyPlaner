package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.vo.Message;

public interface MessageDao {
	
	// ���� �޼��� list (paging)
	List<Message> getSendMessageList(MessageListVO listVO) throws Exception;
	
	// ���� �޼��� list (paging)
	List<Message> getMessageList(MessageListVO listVO) throws Exception;
	
	// �޼��� ����
	int deleteMessage(int messageNo) throws Exception;
	
	// messageNo�� ���� �޼��� ���� return 
	Message getMessage(int messageNo) throws Exception;
	
	// �޼��� ������ :: db�� ���
	int sendMessage(Message message) throws Exception;
	
	int totalSendMessageNumber(int memberNo) throws Exception;
	
	int totalRecvMessageNumber(int memberNo) throws Exception;
} 
