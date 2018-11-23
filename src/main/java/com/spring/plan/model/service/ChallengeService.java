package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeLog;

public interface ChallengeService {

	// challenge ��ü ���
	List<Challenge> getAllChallengeList() throws Exception;

	// challenge ���� return (challenge detail ����������)
	Challenge getChallengeByNo(int challengeNo) throws Exception;

	Challenge getChallengeByNickname(String nickname) throws Exception;

	Challenge getChallengeByCategory(String category) throws Exception;

	// �ش� ���̵�, ���� challenge return (index page. paging)
	Challenge getChallengeByMonth(String month, String nickname) throws Exception;

	// �ش� ���̵�, ��¥�� challenge return (index page. )
	Challenge getChallengeByDay(String day, String nickname) throws Exception;

	// challenge üũ, üũ Ǫ�� method
	int checkChallenge(int challengeNo) throws Exception;

	// challenge�� �߰� (index page)
	int addChallenge(Challenge challenge) throws Exception;

	// challenge ����
	int deleteChallenge(int challengeNo) throws Exception;

	// challenge�� �׸� �߰�
	int addChallengeContent(String challengeContent) throws Exception;

	// challenge�� �׸� ����
	int deleteChallengeContent(String challengeContent) throws Exception;

	// challenge ���� ������Ʈ :: �ۼ��̱⵵ ��
	int updateChallengeLog(ChallengeLog challengeLog) throws Exception;

	// challenge�� ��� �ޱ�
	int writeChallengeComment(ChallengeComment challengeComment) throws Exception;

	// challenge ��� ����
	int deleteChallengeComment(ChallengeComment challengeComment) throws Exception;
}
