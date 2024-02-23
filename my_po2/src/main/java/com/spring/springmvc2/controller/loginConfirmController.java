package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class loginConfirmController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("loginConfirmController --> ");
		
		
		//1.seq ���� �̸��� ���޵Ǵ� �����͸� �ޱ�
		  String id = request.getParameter("id");
          String password = request.getParameter("password");

          System.out.println("ID: " + id);
          System.out.println("Password: " + password);
		
		//2. ���κ��� ������ �������� (BoardDo, BoardDao)
		BoardDo bdo = new BoardDo();
		bdo.setId(id);
		bdo.setPassword(password);
		
		
		BoardDao bdao = new BoardDao();
		BoardDo board = bdao.getOneBoard(bdo);
		
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginConfirm");
		
		
		return mav;
	}

}
