package com.member.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Board.src.main.Java.com.board.model.BoardDTO;
import Springlike.src.main.java.com.member.model.TableDTO;

public class DBDAO {
    Connection conn = DBManager.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String sql;
    private static DBDAO instance = null; //singleton
    public static DBDAO getInstance() {
        //initial generation task
        if (instance == null) {
            instance = new DBDAO();
        }
        return instance;
    }
    public void openConn() {
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");
        try {
            Class.forName(driver);//driver loading
            conn = DriverManager.getConnection(url, user, password);//connection
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeConn() {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public int getDocNums(String tablename) {
        int result=0;
        try {
            openConn();
            sql = "select count(*) from ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    public List<BoardDTO> getList(String tablename) {
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        try {
            openConn();
            sql = "select * from ? order by bno desc";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setBoard_no(rs.getInt("bno"));
                dto.setBoard_title(rs.getString("title"));
                dto.setBoard_writer(rs.getString("writer"));
                dto.setBoard_content(rs.getString("content"));
                dto.setBoard_hit(rs.getInt("hit"));
                dto.setBoard_regdate(rs.getString("regdate"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return list;
    }
    public void updateHit(String tablename, int bno) {
        //update views action
        openConn();
        sql="update ? set board_hit = board_hit + 1 where board_no = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.setInt(2, bno);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    public BoardDTO contentBoard(String tablename, int bno) {
        BoardDTO dto = new BoardDTO();
        try {
            openConn();
            sql = "select * from ? where board_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.setInt(2, bno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                dto.setBoard_no(rs.getInt("board_no"));
                dto.setBoard_title(rs.getString("board_title"));
                dto.setBoard_writer(rs.getString("board_writer"));
                dto.setBoard_content(rs.getString("board_content"));
                dto.setBoard_hit(rs.getInt("board_hit"));
                dto.setBoard_regdate(rs.getString("board_regdate"));
                dto.setBoard_edit(rs.getString("board_edit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return dto;
    }
    public int insertBoard(String tablename, BoardDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "insert into ? values(?, ?, ?, ?, ?, default, sysdate, '')";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.setInt(2, dto.getBoard_no());
            pstmt.setString(3, dto.getBoard_title());
            pstmt.setString(4, dto.getBoard_writer());
            pstmt.setString(5, dto.getBoard_content());
            pstmt.setString(6, dto.getBoard_pwd());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    public int updateBoard(BoardDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "update board set board_title = ?, board_content = ?, board_edit = ? where board_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getBoard_title());
            pstmt.setString(2, dto.getBoard_content());
            pstmt.setString(3, dto.getBoard_edit());
            pstmt.setInt(4, dto.getBoard_no());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    public int deleteDoc(BoardDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "delete from board where board_no = ? and board_pwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getBoard_no());
            pstmt.setString(2, dto.getBoard_pwd());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
}