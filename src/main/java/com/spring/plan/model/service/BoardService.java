package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;

public interface BoardService {

	// board return
	Board getBoardByNo(int boardNo) throws Exception;

	// �Խ��� ��ü �� return (paging)
	List<Board> getAllBoard() throws Exception;

	// �Խ��� ���� �˻� (paging)
	List<Board> getBoardByTitle(String title) throws Exception;

	// �� �ø���
	int writeBoard(Board board) throws Exception;

	// �� ����
	int updateBoard(Board board) throws Exception;

	// �� ����
	int deleteBoard(int boardNo) throws Exception;

	// ��۴ޱ�
	int addBoardComment(int boardNo, BoardComment boardComment) throws Exception;

	// ��ۻ���
	int deleteBoardComment(BoardComment boardComment) throws Exception;
}
