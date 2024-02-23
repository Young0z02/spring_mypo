package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class InsertBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("InsertBoardProcController --> ");
		
		
		//1. �߰��� ������ �������� (request)
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//2. ��� ����
		BoardDo bdo = new BoardDo();
		bdo.setTitle(title);
		bdo.setWriter(writer);
		bdo.setContent(content);
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		
		//3. ��� �̿��Ͽ� �߰��� ������ Ȯ�� !!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:getBoardList.do");
		
	
		
		
		
		return mav;
	}

}














