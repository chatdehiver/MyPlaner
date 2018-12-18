package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Member;

public interface MemberService {
	
	// log in
	Member login(Member mvo) throws Exception;
	
	// īī�� ȸ�� ��� üũ�ϰ�
	int registKakao(Member mvo) throws Exception;
	
	// ȸ�� ����
	int regist(Member mvo) throws Exception;
	
	// id �ߺ�üũ
	boolean idCheck(String id) throws Exception;
	
/*	// nickname �ߺ�üũ
	int nicknameCheck(String nickname) throws Exception;
*/	
	// ���� ����
	public int blockMember(int memberNo, int blockMemberNo) throws Exception;
	
	// kakao ���� ��ϵǾ��ִ��� Ȯ��
	boolean checkKakao(Member member) throws Exception;
	
	// kakao login
	Member kakaoLogin(Member mvo) throws Exception;
	
	// ���� list return 
	List<Integer> getBlockList(int memberNo) throws Exception;


}