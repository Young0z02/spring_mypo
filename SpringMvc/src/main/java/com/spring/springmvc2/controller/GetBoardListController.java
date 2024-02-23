package com.spring.springmvc2.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

public class GetBoardListController implements Controller {

   @Override
   public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      System.out.println("GetBoardListController -->");
      
      
      //1. 디비로부터 전체 데이터 가져오기
      BoardDo bdo = new BoardDo();
      BoardDao bdao = new BoardDao();
      ArrayList<BoardDo> bList = bdao.getBoardList();
      
	for(BoardDo board: bList) {
		System.out.println("-->" + board.getWriter());
	}
      
      //2. 뷰어를 호출하면서, 데이터 넘기기
	ModelAndView mav = new ModelAndView();
	mav.addObject("bList", bList);
	mav.setViewName("getBoardListView");
	
	
      return mav;
   }

}