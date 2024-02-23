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
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        //1. ��� ����
	        conn = JdbcUtil.getConnection();
	        String sql = "insert into memb values (null,?,?)";

	        //2. sql�� �ϼ�
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());

	        //3. sql�� ó��
	        pstmt.executeUpdate();

	        //4. ���� ����
	        JdbcUtil.close(null, pstmt, conn); // rs ���� �߰�

	        System.out.println("insertBoard() ó�� �Ϸ�");
	    } catch (SQLException e) {
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
			String sql = "select * from memb";
			pstmt = conn.prepareStatement(sql);
			//sql�� ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1)); //seq
				bdo.setId(rs.getString(2));
				bdo.setPassword(rs.getString(3));
				
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
	    BoardDo board = null;
	    conn = JdbcUtil.getConnection();
	    //2. sql�� �ϼ�(?? ó�� �ֵ� ����)
	    try {
	        String sql = "SELECT * FROM memb WHERE id=? AND password=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // ��ġ�ϴ� �����Ͱ� ���� ���� ��ü�� �����ϰ� ���� ����
	            board = new BoardDo();
	            board.setId(rs.getString("id"));
	            board.setPassword(rs.getString("password"));
	        }

	        System.out.println("getOneBoard ó�� �Ϸ�!!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JdbcUtil.close(rs, pstmt, conn);
	    }

	    return board;
	}

	
	//4. seq=?�� ������ �����ϱ�
	public void updateBoard(BoardDo bdo) {
		System.out.println("updateBoard() --> ");
		
		//1. ��� ����
		conn = JdbcUtil.getConnection();
		String sql = "update memb set title=?, content=? where seq=?";
		
		try {
			//2. sql �� �ϼ�
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getId());
			pstmt.setString(2, bdo.getPassword());
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
		String sql = "delete from memb where seq=?";
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
	
	
