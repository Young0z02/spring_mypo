package com.spring.springmvc2.ano.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

//@Controller
public class BoardController {
	
	//<prop key="/insertBoard.do"> insertBoard </prop>
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard() {
		
		return "insertBoardView";
	}
		
		
	//<prop key="/insertProcBoard.do"> insertBoardProc </prop> 
	@RequestMapping(value="/insertProcBoard.do")
	public String insertBoardProc(BoardDo bdo) {
		System.out.println("InsertBOardProcController(Ano) -->");
		
		System.out.println("title :" + bdo.getTitle());
		System.out.println("Witer :" + bdo.getWriter());
		System.out.println("Content :" + bdo.getContent());
		
		BoardDao bdao = new BoardDao();
		bdao.insertBoard(bdo);
		
		return "redirect:getBoardList.do";
	}
	
	
	//<prop key="/getBoard.do"> getBoard </prop>
	@RequestMapping(value="/getBoard.do")
	public ModelAndView getBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("GetBoardController(Ano) -->");
		
		BoardDo board = bdao.getOneBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("getBoardView");
		
		return mav;
	}
	
	
	//<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value="/getBoardList.do")
	public ModelAndView getBoardList(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		 System.out.println("GetBoardListController(Ano) -->");
		 
		 ArrayList<BoardDo> bList = bdao.getBoardList();
		 mav.addObject("bList", bList);
		 mav.setViewName("getBoardListView");
		 
		 return mav;
	}
	
	
	//<prop key="/modifyBoard.do"> modifyBoard </prop>
	@RequestMapping(value="/modifyBoard.do")
	public ModelAndView modifyBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyController(Ano) --> ");
		
		BoardDo board = bdao.getOneBoard(bdo);
		mav.addObject("board", board);
		mav.setViewName("modifyBoardView");
		
		return mav;
	}
	
	
	//<prop key="/modifyProcBoard.do"> modifyProcBoard </prop>
	@RequestMapping(value="/modifyProcBoard.do")
	public ModelAndView modifyProcBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("ModifyBoardProcController(Ano) --> ");
		
		bdao.updateBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	
	
	//<prop key="/deleteBoard.do"> deleteBoard </prop>
	@RequestMapping(value="/deleteBoard.do")
	public ModelAndView deleteBoard(BoardDo bdo, BoardDao bdao, ModelAndView mav) {
		System.out.println("DeleteBoardController(Ano) --> ");
	
	
		bdao.deleteBoard(bdo);
		mav.setViewName("redirect:getBoardList.do");
		return mav;
	}
	

}
