package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class DeleteBoardController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DeleteBoardController --> ");
		
		
		//1. seq ��������
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		//2. seq �̿��Ͽ� ��񿡼� ������ ����
		BoardDo bdo = new BoardDo();
		bdo.setSeq(seq);
		
		BoardDao bdao = new BoardDao();
		bdao.deleteBoard(bdo);
		
		//3. getBoardList.do ��û�Ͽ� ���� Ȯ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.do");
		
		
		return mav;
	}

}






















