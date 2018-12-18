package com.spring.plan.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeContent;
import com.spring.plan.model.vo.ChallengeLog;

public interface ChallengeDao {
	
	//searchChallenge
	List<Challenge> searchChallengeList(Challenge challenge) throws Exception;
	
	// challenge ��ü ���
	List<Challenge> getAllChallengeList() throws Exception;
	
	// challenge ���� return 		(challenge detail ����������)
	Challenge getChallengeByNo(int challengeNo) throws Exception;
	
	// �ش� ���̵�, ���� challenge return		(index page.  paging)
	List<Challenge> getChallengeByMonth(String month, int memberNo) throws Exception;
	
	// �ش� ���̵�, ��¥�� challenge return		(index page. )
	List<Challenge> getChallengeByDay(String day, int memberNo) throws Exception;
	
	// challenge�� �߰� (index page)
	int addChallenge(Challenge challenge) throws Exception;
	
	// challenge ����
	int deleteChallenge(int challengeNo) throws Exception;
	
	// challenge�� �׸� �߰�
	int addChallengeContent(List<ChallengeContent> challengeContentList) throws Exception;
	
	// challenge�� �׸� ����
	int deleteChallengeContent(String challengeContent) throws Exception;
	
	// challenge ���� ������Ʈ :: �ۼ��̱⵵ ��
	int updateChallengeLog(ChallengeLog challengeLog) throws Exception;
	
	// challenge�� ��� �ޱ�
	int writeChallengeComment(ChallengeComment challengeComment) throws Exception;
	
	// challenge ��� ���� 
	int deleteChallengeComment(ChallengeComment challengeComment) throws Exception;
	
	// check challenge content
	int checkChallengeContent(ChallengeContent challengeContent) throws Exception;
	
	// challenge_content_check return
	String getChallengeContentCheck(ChallengeContent challengeContent) throws Exception;
	
	// challenge_start_date return
	String getChallengeStartDate(int challengeNo) throws Exception;
	
}
