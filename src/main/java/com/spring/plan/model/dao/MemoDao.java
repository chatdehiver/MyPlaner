package com.spring.plan.model.dao;

public interface MemoDao {

	// memo �ޱ�
	String getMemo(String nickname, String memo) throws Exception;
	
	// memo update
	int updateMemo(String nickname, String memo) throws Exception;
}
