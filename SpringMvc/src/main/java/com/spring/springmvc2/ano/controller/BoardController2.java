package com.spring.springmvc2.ano.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.boardex.impl.BoardDao;
import com.spring.boardex.impl.BoardDo;

@Controller
public class BoardController2 {
	
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
	public String getBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("GetBoardController(Ano) -->");
		
		BoardDo board = bdao.getOneBoard(bdo);
	//	mav.addObject("board", board);
	//	mav.setViewName("getBoardView");
		model.addAttribute("board", board);
		
		return "getBoardView";
	}
	
	
	//<prop key="/getBoardList.do"> getBoardList </prop>
	@RequestMapping(value="/getBoardList.do")
	public String getBoardList(BoardDo bdo, BoardDao bdao, Model model) {
		 System.out.println("GetBoardListController(Ano) -->");
		 
		 ArrayList<BoardDo> bList = bdao.getBoardList();
//		 mav.addObject("bList", bList);
//		 mav.setViewName("getBoardListView");
		 model.addAttribute("bList", bList);
		 
		 return "getBoardListView";
	}
	
	
	//<prop key="/modifyBoard.do"> modifyBoard </prop>
	@RequestMapping(value="/modifyBoard.do")
	public String modifyBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("ModifyController(Ano) --> ");
		
		BoardDo board = bdao.getOneBoard(bdo);
//		mav.addObject("board", board);
//		mav.setViewName("modifyBoardView");
		model.addAttribute("board", board);
		
		return "modifyBoardView";
	}
	
	
	//<prop key="/modifyProcBoard.do"> modifyProcBoard </prop>
	@RequestMapping(value="/modifyProcBoard.do")
	public String modifyProcBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("ModifyBoardProcController(Ano) --> ");
		
		bdao.updateBoard(bdo);
//		mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	
	
	//<prop key="/deleteBoard.do"> deleteBoard </prop>
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardDo bdo, BoardDao bdao, Model model) {
		System.out.println("DeleteBoardController(Ano) --> ");
	
	
		bdao.deleteBoard(bdo);
	//	mav.setViewName("redirect:getBoardList.do");
		
		return "redirect:getBoardList.do";
	}
	

}
