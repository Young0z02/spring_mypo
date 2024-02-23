package com.spring.springmvc2.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class ModifyBoardController {
	//<prop key="/modifyBoard.do"> modifyBoard </prop>
	@RequestMapping(value="/modifyBoard.do")
	public ModelAndView modifyBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyController(Ano) --> ");
		
		BoardDo board = bdao.getOneBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("modifyBoardView");
		
		return mav;
	}
	
	
	
	

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("ModifyController --> ");
//		
//		//1. seq �� ��������
//		int seq = Integer.parseInt(request.getParameter("seq"));
//				
//		//2. ���κ��� seq�� �ش�Ǵ� ������ ��������
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		BoardDao bdao = new BoardDao();
//		BoardDo board = bdao.getOneBoard(bdo);
//		
//		//3. mav�� �̿��Ͽ� �� ������ ����
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("board", board);
//		mav.setViewName("modifyBoardView");
//		
//		
//		return mav;
//	}
	

}
