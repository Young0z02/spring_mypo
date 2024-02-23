package com.spring.springmvc2.ano.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class GetBoardListController {
	//<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		 System.out.println("GetBoardListController(Ano) -->");
		 
		 ArrayList<BoardDo> bList = bdao.getBoardList();
		 mav.addObject("bList", bList);
		 mav.setViewName("getBoardListView");
		 
		 return mav;
		 
		 
	}
	
	
	
	
	
	
	
//
//   @Override
//   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//      System.out.println("GetBoardListController -->");
//      
//      
//      //1. ���κ��� ��ü ������ ��������
//      BoardDo bdo = new BoardDo();
//      BoardDao bdao = new BoardDao();
//      ArrayList<BoardDo> bList = bdao.getBoardList();
//      
//	 for(BoardDo board: bList) {
//		System.out.println("-->" + board.toString());
//	}
//      
//      //2. �� ȣ���ϸ鼭, ������ �ѱ��
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("bList", bList);
//		mav.setViewName("getBoardListView");
//	
//	
//      return mav;
//   }

}