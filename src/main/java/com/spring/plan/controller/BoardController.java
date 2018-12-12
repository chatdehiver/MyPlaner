package com.spring.plan.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.dao.BoardDao;
import com.spring.plan.model.service.BoardService;
import com.spring.plan.model.vo.Board;
import com.spring.plan.model.vo.BoardComment;
import com.spring.plan.model.vo.Member;



@Controller
public class BoardController {
	
	@Resource
	private BoardService boardService;
	
	@Resource
	private BoardDao boardDao;
	
	@RequestMapping("boardwrite.do")
	public ModelAndView write(HttpSession session, Board board) throws Exception{
		System.out.println("��?");
	
		Member member=(Member)session.getAttribute("member");
		System.out.println("�ӳ�");
		System.out.println(board); 
		board.setMemberNo(4);
		/*if(member==null) { 
			return new ModelAndView("redirect:/index.jsp");
			
		}	*/
		/*board.setMember(member);*/	
		// FileUpload �κ��� �߰���...
				MultipartFile mFile = board.getUploadFile();
				System.out.println("MultipartFile : " + mFile);
				System.out.println(mFile.getSize() + "=====" + mFile.isEmpty());// false

				if (mFile.isEmpty() != true) {// ���ε�� ������ �ִٸ�
					String fileName = mFile.getOriginalFilename();
					board.setOrgfilename(fileName);

					String newFileName = System.currentTimeMillis() + fileName;
					board.setNewfilename(newFileName); // bvo�� ��� ���� ������ ������.
				}
				// upload ������ transferTo ��Ų��.
				String root = session.getServletContext().getRealPath("/");
				String path = root + "\\upload\\";
				System.out.println("path : " + path);

				File copyFile = new File(path + mFile.getOriginalFilename());
				mFile.transferTo(copyFile);
				// ���� ���ε��� ������ �ش� path�� �̵�
				  
				boardService.writeBoard(board);

				return new ModelAndView("../board/show_content", "board", board);

			}
	
	@RequestMapping("boardlist.do")
	public ModelAndView getAllBoard()throws Exception {
		List<Board> lb = boardService.getAllBoard();
		System.out.println("lb+"+lb);
		return new ModelAndView("../board/boardlist","lb",lb);
	}
	
	@RequestMapping("show_content.do")
	public ModelAndView boardinfo(HttpServletRequest request,HttpSession session,int no)throws Exception {
	
		/*Member member = (Member)session.getAttribute("member");*/
		/*
		if(member==null) { 
			return new ModelAndView("redirect:/index.jsp");
		}*/
		
		Board board = boardService.getBoardByNo(no);
		return new ModelAndView("../board/show_content", "board",board);
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(HttpServletRequest request,int boardNo,Board board)throws Exception {
		 System.out.println("ddddd");
		 
		 boardService.deleteBoard(board.getBoardNo());
		
		/*List<BoardVO> list = boardService.getBoardList("1");
		return new ModelAndView("board/list","list",list);*/
		return new ModelAndView("redirect:./boardlist.do");
	}
	
	@RequestMapping("update.do")
	public ModelAndView update(HttpSession session, int boardNo) throws Exception {
		/*Member member = (Member) session.getAttribute("member");
		if (member == null) {
			return new ModelAndView("redirect:/index.jsp");
		}*/
		Board board = boardService.getBoardByNo(boardNo);
		return new ModelAndView("../board/update", "boardNo", boardNo);
	}

	@RequestMapping("updatego.do")
	public ModelAndView updatego(HttpSession session, Board board) throws Exception {
		System.out.println(board);
		MultipartFile mFile = board.getUploadFile();

		if (mFile.isEmpty() != true) {
			String root = session.getServletContext().getRealPath("/");
			String path = root + "\\upload\\";
			System.out.println(path);
			File file = new File(path + board.getOrgfilename());

			if (file.exists()) {
				file.delete();
			} else {
				System.out.println("������ �������� �ʽ��ϴ�.");
			}
			String fileName = mFile.getOriginalFilename();
			board.setOrgfilename(fileName);

			String newFileName = System.currentTimeMillis() + fileName;
			board.setNewfilename(newFileName); // bvo�� ��� ���� ������ ������.
			File copyFile = new File(path + mFile.getOriginalFilename());
			mFile.transferTo(copyFile);
		}

		boardService.updateBoard(board);
		return new ModelAndView("redirect:/boardlist.do");
	}
	@RequestMapping("comment.do")
	public ModelAndView insert(HttpServletRequest request, HttpSession session, int boardNo, BoardComment boardComment)throws Exception {
		int lbc =boardService.addBoardComment(boardComment.getBoardCommentNo(),boardComment);
		return new ModelAndView("../board/boardcomment","lbc",lbc);
		
	}
	@RequestMapping("deletecomment.do")
	public ModelAndView deletecomment(HttpServletRequest request,BoardComment boardComment)throws Exception {
		boardService.deleteBoardComment(boardComment);
		return new ModelAndView("redirect:./show_content.do");
	}

}