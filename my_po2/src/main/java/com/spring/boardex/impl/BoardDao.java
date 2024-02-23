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
	        String sql = "insert into my values (null,?,?,?,?)";

	        //2. sql문 완성
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());
	        pstmt.setString(3, bdo.getContent());
	        pstmt.setString(4, bdo.getTitle());

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
			String sql = "select * from my";
			pstmt = conn.prepareStatement(sql);
			//sql문 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardDo bdo = new BoardDo();
				bdo.setSeq(rs.getInt(1)); //seq
				bdo.setId(rs.getString(2));
				bdo.setPassword(rs.getString(3));
				bdo.setContent(rs.getString(4));
				bdo.setTitle(rs.getString(5));
				
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
		BoardDo board = new BoardDo();
		
		
		//1. 디비 연결
		conn = JdbcUtil.getConnection();
		
		//2. sql문 완성(?? 처리 주된 내용)
		String sql = "select * from my where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			//3. sql문 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setSeq(rs.getInt(1));
				board.setId(rs.getString(2));
				board.setPassword(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setTitle(rs.getString(5));
			}
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("getOneBoard 처리 완료!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return board;
	}

	
	//4. seq=?인 데이터 수정하기
	public void updateBoard(BoardDo bdo) {
	    System.out.println("updateBoard() --> ");
	    
	    //1. 디비 연결
	    conn = JdbcUtil.getConnection();
	    String sql = "update my set title=?, content=? where seq=?";
	    
	    try {
	        //2. sql 문 완성
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getTitle()); 
	        pstmt.setString(2, bdo.getContent()); 
	        pstmt.setInt(3, bdo.getSeq()); 

	        //3. sql문 실행
	        pstmt.executeUpdate();
	        
	        JdbcUtil.close(rs, pstmt, conn);
	        System.out.println("updateBoard 처리 완료 !!");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//5. seq=?인 데이터 삭제하기
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		
		//1. 디비 연결
		conn = JdbcUtil.getConnection();
		
		//2. sql 문 완성
		String sql = "delete from my where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3. sql 문 실행
			pstmt.executeUpdate();
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard 처리 완료");
			
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
		
	// 6. 사용자 정보 조회하기
	public boolean checkUser(BoardDo bdo) {
	    System.out.println("checkUserBoard() ==> ");

	    // 1. 디비 연결
	    conn = JdbcUtil.getConnection();

	    // 2. sql 문 완성
	    String sql = "SELECT * FROM my WHERE id=? AND password=?";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());

	        // 3. sql 문 실행
	        rs = pstmt.executeQuery();

	        // 결과를 이용하여 로직 추가 (사용자 정보가 존재하는지 확인)
	        boolean userExists = rs.next();

	        JdbcUtil.close(rs, pstmt, conn);
	        System.out.println("checkUser 처리 완료");

	        return userExists;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	//7. 정렬, 검색, 페이징 기능
	public ArrayList<BoardDo> searchAndSortAddr(String sortOption, String keyword, int currentPage, int itemsPerPage) {
	    System.out.println("searchAndSortAddr_ ==>");

	    ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
	    try {
	        // 데이터베이스 연결
	        conn = JdbcUtil.getConnection();

	        // SQL 쿼리 생성
	        String sql = "SELECT * FROM my ";

	        // 검색어가 전달되면 WHERE 절 추가
	        if (keyword != null && !keyword.isEmpty()) {
	            sql += "WHERE seq LIKE ? ";
	        }

	        // 정렬 옵션에 따라 SQL 쿼리 수정
	        if (sortOption != null) {
	            switch (sortOption) {
	                case "seq_asc":
	                    sql += "ORDER BY seq ASC";
	                    break;
	                case "seq_desc":
	                    sql += "ORDER BY seq DESC";
	                    break;
	                default:
	                    sql += "ORDER BY seq ASC"; 
	                    break;
	            }
	        }

	        // 페이징 적용
	        int startIdx = (currentPage - 1) * itemsPerPage;
	        sql += " LIMIT " + startIdx + ", " + itemsPerPage;

	        // 출력문 추가: 생성된 SQL 쿼리 확인
	        System.out.println("SQL Query: " + sql);

	        pstmt = conn.prepareStatement(sql);

	        // 검색어가 전달된 경우 매개변수 설정
	        if (keyword != null && !keyword.isEmpty()) {
	            pstmt.setString(1, "%" + keyword + "%");
	        }

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            BoardDo temp = new BoardDo();
	            temp.setSeq(rs.getInt(1));
	            temp.setId(rs.getString(2));
	            temp.setPassword(rs.getString(3));
	            temp.setContent(rs.getString(4));
	            temp.setTitle(rs.getString(5));

	            bList.add(temp);
	        }

	        JdbcUtil.close(rs, pstmt, conn);
	        System.out.println("-- 데이터베이스 처리 완료(searchAndSortAddr()) --");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return bList;
	}
	
	 //8. 전체 아이템 수 가져오기
    public int getTotalItems() {
        System.out.println("getTotalItems() ==> ");

        // 1. 디비 연결
        conn = JdbcUtil.getConnection();

        // 2. sql 문 완성
        String sql = "SELECT COUNT(*) FROM my";
        int totalItems = 0;

        try {
            pstmt = conn.prepareStatement(sql);

            // 3. sql 문 실행
            rs = pstmt.executeQuery();

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }

            JdbcUtil.close(rs, pstmt, conn);
            System.out.println("getTotalItems 처리 완료");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }
}