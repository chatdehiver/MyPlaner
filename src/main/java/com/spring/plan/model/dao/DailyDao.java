package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;

public interface DailyDao {
	
	//���� üũ
	int insertEmotion(Daily daily) throws Exception;
	
	//�ٸ��� üũ
	int updateEmotion(Daily daily) throws Exception;
	
	//���� ���� ���� ����
	List<Daily> selectEmotionByYear(int year) throws Exception;
	
	// memo �ޱ�
	String getMemo(int memberNo) throws Exception;
		
	// memo update
	int updateMemo(Member member) throws Exception;
	
	// insert memo ȸ�������Ҷ� �߰�
	int insertMemo(Member member) throws Exception;
	
	// ���� emotion return
	String getTodayEmotion(Daily daily) throws Exception;
	
	//////////��    ��~~~~~~~~~~~~~~~~~~~~~
}
