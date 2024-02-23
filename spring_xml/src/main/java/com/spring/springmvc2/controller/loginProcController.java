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
		
		
		//3. ��� ȣ���ϸ鼭, board ������ ����
		ModelAndView mav = new ModelAndView();
		
		if (board != null && id.equals(board.getId()) && password.equals(board.getPassword())) {
		    // �α��� ����
		    mav.setViewName("loginConfirm");
		} else {
		    // �α��� ����
		    mav.setViewName("memberJoin"); // ���� �� �̵��� ������ ����
		}

	        return mav;
	    }
		
	
}