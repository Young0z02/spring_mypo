package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class loginProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("loginProcController -->");
		
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
		
		
		//3. 뷰어 호출하면서, board 데이터 전달
		ModelAndView mav = new ModelAndView();
		
		if (board != null && id.equals(board.getId()) && password.equals(board.getPassword())) {
		    // 로그인 성공
		    mav.setViewName("loginConfirm");
		} else {
		    // 로그인 실패
		    mav.setViewName("memberJoin"); // 실패 시 이동할 페이지 설정
		}

	        return mav;
	    }
		
	
}