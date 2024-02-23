package com.spring.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	
	//1.게시판 데이터 저장
	void insertBoard(BoardDo bdo);
	
	//2.전체 게시판 데이터 가져오기
	ArrayList<BoardDo> getBoardList();

	//3.하나의 게시판 데이터 가져오기
	BoardDo getOneBoard(BoardDo bdo);
	
	//4.하나의 게시판 데이터 수정하기
	void updateBoard(BoardDo bdo);
	
	//5.하나의 게시판 삭제하기
	void deleteBoard(BoardDo bdo);

	//6.사용자 정보 조회하기
	boolean checkUser(BoardDo bdo);

	//7.정렬 및 검색하기
	ArrayList<BoardDo> searchAndSortAddr();

	//8.페이징 기능
	int getTotalItems();
	
}
