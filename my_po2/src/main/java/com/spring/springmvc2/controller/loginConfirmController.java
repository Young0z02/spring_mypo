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
		
		
		//1.seq 변수 이름을 전달되는 데이터를 받기
		  String id = request.getParameter("id");
          String password = request.getParameter("password");

          System.out.println("ID: " + id);
          System.out.println("Password: " + password);
		
		//2. 디비로부터 데이터 가져오기 (BoardDo, BoardDao)
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
