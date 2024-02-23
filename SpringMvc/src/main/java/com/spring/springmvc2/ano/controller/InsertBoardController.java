package com.spring.springmvc2.ano.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
public class InsertBoardController {
	
	//<prop key="/insertBoard.do"> insertBoard </prop>
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard() {
		
		return "insertBoardView";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("InsertBoardController --> ");
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("insertBoardView");
//		
//		
//		return mav;
//	}

}
