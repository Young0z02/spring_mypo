package com.spring.boardex.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.service.BoardService;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	//boardDao 객체 이용 (중요)
	@Autowired
	private BoardDao bdao;
	
	@Override
	public void insertBoard(BoardDo bdo) {
		bdao.insertBoard(bdo);
	}

	@Override
	public ArrayList<BoardDo> getBoardList() {
		return bdao.getBoardList();
	}

	@Override
	public BoardDo getOneBoard(BoardDo bdo) {
		return bdao.getOneBoard(bdo);
	}

	@Override
	public void updateBoard(BoardDo bdo) {
		bdao.updateBoard(bdo);
		
	}

	@Override
	public void deleteBoard(BoardDo bdo) {
		bdao.deleteBoard(bdo);
	}
	
	
	

}
