package com.spring.service;

import java.util.ArrayList;

import com.spring.boardex.impl.BoardDo;

public interface BoardService {
	
	//1.�Խ��� ������ ����
	void insertBoard(BoardDo bdo);
	
	//2.��ü �Խ��� ������ ��������
	ArrayList<BoardDo> getBoardList();

	//3.�ϳ��� �Խ��� ������ ��������
	BoardDo getOneBoard(BoardDo bdo);
	
	//4.�ϳ��� �Խ��� ������ �����ϱ�
	void updateBoard(BoardDo bdo);
	
	//5.�ϳ��� �Խ��� �����ϱ�
	void deleteBoard(BoardDo bdo);

	//6.����� ���� ��ȸ�ϱ�
	boolean checkUser(BoardDo bdo);

	//7.���� �� �˻��ϱ�
	ArrayList<BoardDo> searchAndSortAddr();

	//8.����¡ ���
	int getTotalItems();
	
}
