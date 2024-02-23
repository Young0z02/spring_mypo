package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class ModifyBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ModifyController --> ");
		
		//1. seq �� ��������
		int seq = Integer.parseInt(request.getParameter("seq"));
				
		//2. ���κ��� seq�� �ش�Ǵ� ������ ��������
		BoardDo bdo = new BoardDo();
		bdo.setSeq(seq);
		BoardDao bdao = new BoardDao();
		BoardDo board = bdao.getOneBoard(bdo);
		
		//3. mav�� �̿��Ͽ� �� ������ ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", board);
		mav.setViewName("modifyBoardView");
		
		
		return mav;
	}
	

}
