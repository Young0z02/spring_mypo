package com.spring.springmvc2.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class GetBoardController {
	//<prop key="/getBoard.do"> getBoard </prop>
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("GetBoardController(Ano) -->");
		
		BoardDo board = bdao.getOneBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("getBoardView");
		
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
//
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("GetBoardController -->");
//		
//		//1.seq ���� �̸��� ���޵Ǵ� �����͸� �ޱ�
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		
//		//2. ���κ��� ������ �������� (BoardDo, BoardDao)
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		
//		BoardDao bdao = new BoardDao();
//		BoardDo board = bdao.getOneBoard(bdo);
//		
//		
//		//3. ��� ȣ���ϸ鼭, board ������ ����
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("getBoardView");
//		
//		
//		
//		
//		return mav;
//	}

}