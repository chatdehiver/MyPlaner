package com.spring.plan.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.service.paging.BoardListVO;
import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;

public interface BoardDao {

	//board return
	Board getBoardByNo(int boardNo) throws Exception;			//
	
	// �Խ��� ��ü �� return (paging)
	List<Board> getAllBoard(BoardListVO listVO) throws Exception;					//				
	
	// �Խ��� ���� �˻� (paging)
	List<Board> getBoardByTitle(String title) throws Exception;	
	
	// �Խ��� �ۼ��� �˻� (paging)
	List<Board> getBoardByMemberNo(int memberNo) throws Exception;//
	
	// �� �ø���
	int writeBoard(Board board) throws Exception;				//
	
	// �� ����
	int updateBoard(Board board) throws Exception;				//
	
	// �� ����
	int deleteBoard(int boardNo) throws Exception;				//
	
	// ��۴ޱ�
	int addBoardComment(int boardNo, BoardComment boardComment) throws Exception;
	
	// ��ۻ���
	int deleteBoardComment(BoardComment boardComment) throws Exception;
	
	//paging
	int totalBoardNumber(int memberNo) throws Exception;
}
