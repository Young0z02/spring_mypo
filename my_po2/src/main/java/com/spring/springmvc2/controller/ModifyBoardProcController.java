package com.spring.springmvc2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class ModifyBoardProcController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									HttpServletResponse response) throws Exception {
		System.out.println("ModifyBoardProcController --> ");
		
		//1. ������ �����͸� ������ ����
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("seq: " + seq +
							"title" + title +
							"content" + content );
		
		
		//2. ������ ������ ��� ����
		BoardDo bdo = new BoardDo();
		bdo.setSeq(seq);
		bdo.setTitle(title);
		bdo.setContent(content);
		
		BoardDao bdao = new BoardDao();
		bdao.updateBoard(bdo);
		
		//3. ��� ȣ��
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberList.do");
		
		

		
		return mav;
	}

}
