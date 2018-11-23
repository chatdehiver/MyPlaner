package com.spring.plan.model.service;

import com.spring.plan.model.vo.Member;

public interface MemberService {
	
	// log in
	Member login(Member mvo) throws Exception;
	
	// log out
	void logout(Member mvo) throws Exception;
	
	// ȸ�� ����
	int regist(Member mvo) throws Exception;
	
	// id �ߺ�üũ
	int idCheck(String id) throws Exception;
	
	// nickname �ߺ�üũ
	int nicknameCheck(String nickname) throws Exception;
	
	// ���� ����
	int blockMember(String nickname, String blockNickname) throws Exception;
}
