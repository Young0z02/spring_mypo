package com.spring.springmvc2.ano.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class InsertBoardProcController {
	//<prop key="/insertProcBoard.do"> insertBoardProc </prop> 
	@RequestMapping(value="/insertProcBoard.do")
	public String insertBoardProc(BoardDo bdo) {
		System.out.println("InsertBOardProcController(Ano) -->");
		
		System.out.println("title :" + bdo.getTitle());
		System.out.println("Witer :" + bdo.getWriter());
		System.out.println("Content :" + bdo.getContent());
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		return "redirect:getBoardList.do";
	}
}
		
		
		
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("InsertBoardProcController --> ");
//		
//		
//		//1. �߰��� ������ �������� (request)
//		String writer = request.getParameter("writer");
//		String title = request.getParameter("title");
//		String content = request.getParameter("content");
//		
//		//2. ��� ����
//		BoardDo bdo = new BoardDo();
//		bdo.setTitle(title);
//		bdo.setWriter(writer);
//		bdo.setContent(content);
//		
//		BoardDao bdao = new BoardDao();
//		bdao.insertBoard(bdo);
//		
//		
//		//3. ��� �̿��Ͽ� �߰��� ������ Ȯ�� !!
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("redirect:getBoardList.do");
//		
//	
//		
//		
//		
//		return mav;
	
















