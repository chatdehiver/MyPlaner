package com.spring.plan.model.dao;

import com.spring.plan.model.vo.BlockMember;
import com.spring.plan.model.vo.Member;

public interface MemberDao {
	
	// log in
	Member login(Member mvo) throws Exception;
	
	// kakao login
	Member kakaoLogin(Member mvo) throws Exception;
	
	// ȸ�� ����
	int regist(Member mvo) throws Exception;
	
	// īī�� ȸ�� ��� üũ�ϰ�
	int registKakao(Member mvo) throws Exception;
	
	// id �ߺ�üũ
	int idCheck(String id) throws Exception;
	
/*	// nickname �ߺ�üũ
	int nicknameCheck(String nickname) throws Exception;
	*/
	// ���� ����
	int blockMember(BlockMember blockMember) throws Exception;
	
	// īī�� ȸ�� üũ
	int checkKakao(Member member) throws Exception;
}
