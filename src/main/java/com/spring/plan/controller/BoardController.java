package com.spring.plan.controller;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.dao.BoardDao;
import com.spring.plan.model.service.BoardService;
import com.spring.plan.model.service.paging.ListVO;
import com.spring.plan.model.vo.Board;
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
		/*if(member==null) { 
			return new ModelAndView("redirect:/index.jsp");
			
		}	*/
		/*board.setMember(member);*/	
		/*// FileUpload �κ��� �߰���...
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
*/				boardService.writeBoard(board);

				return new ModelAndView("board/show_content", "board", board);

			}
	
	@RequestMapping("boardlist.do")
	public ModelAndView AllBoard()throws Exception {
		List<Board> lvo = boardService.getAllBoard();
		return new ModelAndView("board/boardlist","lvo",lvo);
	}
	
	@RequestMapping("boardinfo.do")
	public ModelAndView boardinfo(HttpSession session,int no)throws Exception {
	
		Member member = (Member)session.getAttribute("member");
		
		if(member==null) { 
			return new ModelAndView("redirect:/index.jsp");
		}
		
		Board board = boardService.getBoardByNo(no);
		return new ModelAndView("board/boardinfo", "board",board);
	}
	
	@RequestMapping("delete.do")
	public ModelAndView delete(int boardNo)throws Exception {
		boardDao.deleteBoard(boardNo); 
		
		/*List<BoardVO> list = boardService.getBoardList("1");
		return new ModelAndView("board/list","list",list);*/
		return new ModelAndView("redirect:/list.do");
	}
	
	@RequestMapping("updateView.do")
	public ModelAndView update(Board board, int boardNo) throws Exception {
		Board board1 = boardService.getBoardByNo(boardNo);
		return new ModelAndView("board/boardupdate.jsp", "board", board1);
	}
	
	@RequestMapping("updateBoard.do")
	public ModelAndView updateResult(HttpSession session, Board board, String no) throws Exception {
		Member memeber = (Member)session.getAttribute("member");
		if(memeber == null) {
			return new ModelAndView("redirect:/index.jsp");
		}
		
		boardService.updateBoard(board);
		return new ModelAndView("board/boardinfo", "board", board);
	}
	

	
}






