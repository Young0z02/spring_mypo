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
	        String sql = "insert into my values (null,?,?,?,?)";

	        //2. sql�� �ϼ�
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());
	        pstmt.setString(3, bdo.getContent());
	        pstmt.setString(4, bdo.getTitle());

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
			String sql = "select * from my";
			pstmt = conn.prepareStatement(sql);
			//sql�� ����
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
		String sql = "select * from my where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			//3. sql�� ����
			rs = pstmt.executeQuery();
			while(rs.next()) {
				board.setSeq(rs.getInt(1));
				board.setId(rs.getString(2));
				board.setPassword(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setTitle(rs.getString(5));
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
	    String sql = "update my set title=?, content=? where seq=?";
	    
	    try {
	        //2. sql �� �ϼ�
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getTitle()); 
	        pstmt.setString(2, bdo.getContent()); 
	        pstmt.setInt(3, bdo.getSeq()); 

	        //3. sql�� ����
	        pstmt.executeUpdate();
	        
	        JdbcUtil.close(rs, pstmt, conn);
	        System.out.println("updateBoard ó�� �Ϸ� !!");
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//5. seq=?�� ������ �����ϱ�
	public void deleteBoard(BoardDo bdo) {
		System.out.println("deleteBoard() ==> ");
		
		//1. ��� ����
		conn = JdbcUtil.getConnection();
		
		//2. sql �� �ϼ�
		String sql = "delete from my where seq=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bdo.getSeq());
			
			//3. sql �� ����
			pstmt.executeUpdate();
			JdbcUtil.close(rs, pstmt, conn);
			System.out.println("deleteBoard ó�� �Ϸ�");
			
		} catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
		
	// 6. ����� ���� ��ȸ�ϱ�
	public boolean checkUser(BoardDo bdo) {
	    System.out.println("checkUserBoard() ==> ");

	    // 1. ��� ����
	    conn = JdbcUtil.getConnection();

	    // 2. sql �� �ϼ�
	    String sql = "SELECT * FROM my WHERE id=? AND password=?";
	    try {
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, bdo.getId());
	        pstmt.setString(2, bdo.getPassword());

	        // 3. sql �� ����
	        rs = pstmt.executeQuery();

	        // ����� �̿��Ͽ� ���� �߰� (����� ������ �����ϴ��� Ȯ��)
	        boolean userExists = rs.next();

	        JdbcUtil.close(rs, pstmt, conn);
	        System.out.println("checkUser ó�� �Ϸ�");

	        return userExists;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	//7. ����, �˻�, ����¡ ���
	public ArrayList<BoardDo> searchAndSortAddr(String sortOption, String keyword, int currentPage, int itemsPerPage) {
	    System.out.println("searchAndSortAddr_ ==>");

	    ArrayList<BoardDo> bList = new ArrayList<BoardDo>();
	    try {
	        // �����ͺ��̽� ����
	        conn = JdbcUtil.getConnection();

	        // SQL ���� ����
	        String sql = "SELECT * FROM my ";

	        // �˻�� ���޵Ǹ� WHERE �� �߰�
	        if (keyword != null && !keyword.isEmpty()) {
	            sql += "WHERE seq LIKE ? ";
	        }

	        // ���� �ɼǿ� ���� SQL ���� ����
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

	        // ����¡ ����
	        int startIdx = (currentPage - 1) * itemsPerPage;
	        sql += " LIMIT " + startIdx + ", " + itemsPerPage;

	        // ��¹� �߰�: ������ SQL ���� Ȯ��
	        System.out.println("SQL Query: " + sql);

	        pstmt = conn.prepareStatement(sql);

	        // �˻�� ���޵� ��� �Ű����� ����
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
	        System.out.println("-- �����ͺ��̽� ó�� �Ϸ�(searchAndSortAddr()) --");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return bList;
	}
	
	 //8. ��ü ������ �� ��������
    public int getTotalItems() {
        System.out.println("getTotalItems() ==> ");

        // 1. ��� ����
        conn = JdbcUtil.getConnection();

        // 2. sql �� �ϼ�
        String sql = "SELECT COUNT(*) FROM my";
        int totalItems = 0;

        try {
            pstmt = conn.prepareStatement(sql);

            // 3. sql �� ����
            rs = pstmt.executeQuery();

            if (rs.next()) {
                totalItems = rs.getInt(1);
            }

            JdbcUtil.close(rs, pstmt, conn);
            System.out.println("getTotalItems ó�� �Ϸ�");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalItems;
    }
}