package com.spring.plan.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeLog;

public interface ChallengeDao {

	
	// challenge ��ü ���
	List<Challenge> getAllChallengeList() throws Exception;
	
	// challenge ���� return 		(challenge detail ����������)
	Challenge getChallengeByNo(int challengeNo) throws Exception;
	
	// �ش� ���̵�, ���� challenge return		(index page.  paging)
	List<Challenge> getChallengeByMonth(String month, int memberNo) throws Exception;
	
	// �ش� ���̵�, ��¥�� challenge return		(index page. )
	List<Challenge> getChallengeByDay(String day, int memberNo) throws Exception;
	
	// challenge üũ, üũ Ǫ�� method
	int checkChallenge(int challengeNo, String challengeContent) throws Exception;
	
	// challenge�� �߰� (index page)
	int addChallenge(Challenge challenge) throws Exception;
	
	// challenge ����
	int deleteChallenge(int challengeNo) throws Exception;
	
	// challenge�� �׸� �߰�
	int addChallengeContent(int challengeNo, List<String> challengeContent) throws Exception;
	
	// challenge�� �׸� ����
	int deleteChallengeContent(String challengeContent) throws Exception;
	
	// challenge ���� ������Ʈ :: �ۼ��̱⵵ ��
	int updateChallengeLog(ChallengeLog challengeLog) throws Exception;
	
	// challenge�� ��� �ޱ�
	int writeChallengeComment(ChallengeComment challengeComment) throws Exception;
	
	// challenge ��� ���� 
	int deleteChallengeComment(ChallengeComment challengeComment) throws Exception;
	
}
