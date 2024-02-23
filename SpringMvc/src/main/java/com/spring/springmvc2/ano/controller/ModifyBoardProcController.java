package com.spring.springmvc2.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class ModifyBoardProcController {
	//<prop key="/modifyProcBoard.do"> modifyProcBoard </prop>
	@RequestMapping(value="/modifyProcBoard.do")
	public ModelAndView modifyProcBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyBoardProcController(Ano) --> ");
		
		bdao.updateBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	

	
	
	
	
	
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, 
//									HttpServletResponse response) throws Exception {
//		System.out.println("ModifyBoardProcController --> ");
//		
//		//1. ������ �����͸� ������ ����
//		int seq = Integer.parseInt(request.getParameter("seq"));
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		System.out.println("seq: " + seq +
//							"title" + title +
//							"content" + content );
//		
//		
//		//2. ������ ������ ��� ����
//		BoardDo bdo = new BoardDo();
//		bdo.setSeq(seq);
//		bdo.setTitle(title);
//		bdo.setContent(content);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.updateBoard(bdo);
//		
//		//3. ��� ȣ��
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//		
//
//		
//		return mav;
//	}

}
