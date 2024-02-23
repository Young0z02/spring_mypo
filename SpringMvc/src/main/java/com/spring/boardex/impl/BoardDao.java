package com.spring.boardex.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.spring.boardex.common.JdbcUtil;

@Repository("boardDao")
public class BoardDao {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//1. ������ ����	
	public void insertBoard(BoardDo bdo) {
		System.out.println("insertBoard() -->");
		
		//1. ��� ����
		conn = JdbcUtil.getConnection();
		String sql = "insert into board values (null, ?,?,?)";
		try {
			//2. sql�� �ϼ�
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  bdo.getTitle());
			pstmt.setString(2,  bdo.getWriter());
			pstmt.setString(3,  bdo.getContent());
			
			//3. sql�� ó��
			pstmt.executeUpdate();
			
			//4. ���� ����
			JdbcUtil.close(rs,  pstmt, conn);
			System.out.println("insertBoard() ó�� �Ϸ�");
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//2. ��ü ������ ��������
	public ArrayList<BoardDo> getBoardList() {
		System.out.println("getBoardList)_ ==>");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		try {
			//�����ͺ��̽� ����
			conn = JdbcUtil.getConnection();
			
			//sql�� �ϼ�
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			//sql�� ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1)); //seq
				bdo.setTitle(rs.getString(2));
				bdo.setWriter(rs.getString(3));
				bdo.setContent(rs.getString(4));
				
				bList.add(bdo);
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("-- �����ͺ��̽� ó�� �Ϸ�(getBoardList()) --");
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
		
		
				
		}

	//3. seq= ? �� �ϳ��� ������ ��������
	public BoardDo getOneBoard(BoardDo bdo) {
		System.out.println("getOneBoard() --> ");
		//���� Ÿ��
		BoardDo board = new BoardDo();
		
		
		//1. ��� ����
		conn = JdbcUtil.getConnection();
		
		//2. sql�� �ϼ�(?? ó�� �ֵ� ����)
		String sql = "select * from board where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			//3. sql�� ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setSeq(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4));
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getOneBoard ó�� �Ϸ�!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return board;
	}

	//4. seq=?�� ������ �����ϱ�
	public void updateBoard(BoardDo bdo) {
		System.out.println("updateBoard() --> ");
		
		//1. ��� ����
		conn = JdbcUtil.getConnection();
		String sql = "update board set title=?, content=? where seq=?";
		
		try {
			//2. sql �� �ϼ�
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getTitle());
			pstmt.setString(2, bdo.getContent());
			pstmt.setInt(3,  bdo.getSeq());
			
			//3. sql�� ����
			pstmt.executeUpdate();
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("updateBoard ó�� �Ϸ� !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//5. seq=?�� ������ �����ϱ�
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		
		//1. ��� ����
		conn = JdbcUtil.getConnection();
		
		//2. sql �� �ϼ�
		String sql = "delete from board where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3. sql �� ����
			pstmt.executeUpdate();
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard ó�� �Ϸ�");
			
		} catch (SQLException e) {
			// TODO Auto-generted catch block
			e.printStackTrace();
		}
	}
}
	
	
