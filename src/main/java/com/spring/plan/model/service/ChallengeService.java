package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeContent;
import com.spring.plan.model.vo.ChallengeLog;

public interface ChallengeService {

	//challenge �˻�
	List<Challenge> searchChallengeList(Challenge challenge) throws Exception;
	
	// challenge ��ü ���
	List<Challenge> getAllChallengeList() throws Exception;

	// challenge ���� return (challenge detail ����������)
	Challenge getChallengeByNo(int challengeNo) throws Exception;

	// �ش� ���̵�, ���� challenge return (index page. paging)
	List<Challenge> getChallengeByMonth(String month,  int memberNo) throws Exception;

	// �ش� ���̵�, ��¥�� challenge return (index page. )
	List<Challenge> getChallengeByDay(String day,  int memberNo) throws Exception;

	// challenge�� �߰� (index page)
	int addChallenge(Challenge challenge) throws Exception;

	// challenge ����
	int deleteChallenge(int challengeNo) throws Exception;

	// challenge�� �׸� �߰�
	int addChallengeContent(Challenge challenge, List<ChallengeContent> challengeContent) throws Exception;

	// challenge�� �׸� ����
	int deleteChallengeContent(String challengeContent) throws Exception;

	// challenge ���� ������Ʈ :: �ۼ��̱⵵ ��
	int updateChallengeLog(ChallengeLog challengeLog) throws Exception;

	// challenge�� ��� �ޱ�
	int writeChallengeComment(ChallengeComment challengeComment) throws Exception;

	// challenge ��� ����
	int deleteChallengeComment(ChallengeComment challengeComment) throws Exception;
	
	// check ChallengeContent
	int checkChallengeContent(ChallengeContent challengeContent,String day) throws Exception;
	
	//return challengeContentCheck
	String getChallengeContentCheck(ChallengeContent challengeContent) throws Exception;
}
