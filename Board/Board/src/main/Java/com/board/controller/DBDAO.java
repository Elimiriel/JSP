package com.board.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Board.src.main.Java.com.board.model.BoardDTO;

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
    public void makeDBTable(String tablename) {
        try {
            conn = DBManager.getConnection();
            sql = "create table ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.setString(1, tablename);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeConn();
        }
    }
    public void openConn() {
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="scott";
        String password="tiger";
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
    public int getDocNums() {
        int result=0;
        try {
            openConn();
            sql = "select count(*) from emp";
            pstmt = conn.prepareStatement(sql);
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
    public List<BoardDTO> getList() {
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        try {
            openConn();
            sql = "select * from board order by bno desc";
            pstmt = conn.prepareStatement(sql);
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
    public void updateHit(int bno) {
        //update views action
        openConn();
        sql="update board set board_hit = board_hit + 1 where board_no = ?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    public BoardDTO contentBoard(int bno) {
        BoardDTO dto = new BoardDTO();
        try {
            openConn();
            sql = "select * from board where board_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
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
}
