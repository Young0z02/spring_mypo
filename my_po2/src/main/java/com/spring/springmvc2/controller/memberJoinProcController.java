package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class memberJoinProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("memberJoinController --> ");
		
		
		//1. �߰��� ������ �������� (request)
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		String title = request.getParameter("title");

		
		//2. ��� ����
		BoardDo bdo = new BoardDo();
		bdo.setId(id);
		bdo.setPassword(password);
		bdo.setContent(content);
		bdo.setTitle(title);
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		
		//3. ��� �̿��Ͽ� �߰��� ������ Ȯ�� !!
		ModelAndView mav = new ModelAndView();
		mav.setViewName("memberJoin");

		return mav;
	}

}














