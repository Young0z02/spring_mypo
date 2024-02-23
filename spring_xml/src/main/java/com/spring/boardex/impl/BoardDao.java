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
	
	//1. 데이터 저장	
	public void insertBoard(BoardDo bdo) {
	    System.out.println("insertBoard() -->");
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        //1. 디비에 연결
	        conn = JdbcUtil.getConnection();
	        String sql = "insert into memb values (null,?,?)";

	        //2. sql문 완성
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());

	        //3. sql문 처리
	        pstmt.executeUpdate();

	        //4. 연결 해제
	        JdbcUtil.close(null, pstmt, conn); // rs 변수 추가

	        System.out.println("insertBoard() 처리 완료");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//2. 전체 데이터 가져오기
	public ArrayList<BoardDo> getBoardList() {
		System.out.println("getBoardList)_ ==>");
		ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
		try {
			//데이터베이스 연결
			conn = JdbcUtil.getConnection();
			
			//sql문 완성
			String sql = "select * from memb";
			pstmt = conn.prepareStatement(sql);
			//sql문 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1)); //seq
				bdo.setId(rs.getString(2));
				bdo.setPassword(rs.getString(3));
				
				bList.add(bdo);
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("-- 데이터베이스 처리 완료(getBoardList()) --");
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bList;
		
		
				
		}

	//3. seq= ? 인 하나의 데이터 가져오기
	public BoardDo getOneBoard(BoardDo bdo) {
	    System.out.println("getOneBoard() --> ");
	    //리턴 타입
	    BoardDo board = null;
	    conn = JdbcUtil.getConnection();
	    //2. sql문 완성(?? 처리 주된 내용)
	    try {
	        String sql = "SELECT * FROM memb WHERE id=? AND password=?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	            // 일치하는 데이터가 있을 때만 객체를 생성하고 값을 설정
	            board = new BoardDo();
	            board.setId(rs.getString("id"));
	            board.setPassword(rs.getString("password"));
	        }

	        System.out.println("getOneBoard 처리 완료!!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        JdbcUtil.close(rs, pstmt, conn);
	    }

	    return board;
	}

	
	//4. seq=?인 데이터 수정하기
	public void updateBoard(BoardDo bdo) {
		System.out.println("updateBoard() --> ");
		
		//1. 디비 연결
		conn = JdbcUtil.getConnection();
		String sql = "update memb set title=?, content=? where seq=?";
		
		try {
			//2. sql 문 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdo.getId());
			pstmt.setString(2, bdo.getPassword());
			pstmt.setInt(3,  bdo.getSeq());
			
			//3. sql문 실행
			pstmt.executeUpdate();
			
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("updateBoard 처리 완료 !!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//5. seq=?인 데이터 삭제하기
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		
		//1. 디비 연결
		conn = JdbcUtil.getConnection();
		
		//2. sql 문 완성
		String sql = "delete from memb where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3. sql 문 실행
			pstmt.executeUpdate();
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard 처리 완료");
			
		} catch (SQLException e) {
			// TODO Auto-generted catch block
			e.printStackTrace();
		}
	}
}
	
	
