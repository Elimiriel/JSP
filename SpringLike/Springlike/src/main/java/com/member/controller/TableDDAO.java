package Springlike.src.main.java.com.member.controller;

import com.member.model.BoardDTO;

import Springlike.src.main.java.com.member.model.TableDTO;

public class TableDDAO {
    private static TableDDAO("thread", String boardname, String tableAdmin=null) instance = null;
    public static TableDDAO getInstance() {
        return instance;
    }
    @Override
    public int createOK(BoardDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = member/WEB-INF/sql/Board.sql;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardname);
            if(tableAdmin != null) pstmt.setString(2, tableAdmin);
            else pstmt.setString(2, dto.getBoardEdit());
            result=pstmt.executeUpdate();
            if(dto.getBoardNo()!=null) {
                //when create board and write thread are inputted at once
                sql="insert into ? values(? primary key, ?, ?, ?, ?, default, sysdate, '', ?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, boardname);
                pstmt.setString(2, dto.getBoardNo());
                pstmt.setString(3, dto.getBoardTitle());
                pstmt.setString(4, dto.getBoardWriter());
                pstmt.setString(5, dto.getBoardContent());
                pstmt.setString(6, dto.getBoardPwd());
                if(tableAdmin != null) pstmt.setString(7, tableAdmin);
                else pstmt.setString(7, dto.getBoardEdit());
                result = pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    @Override
    public int readOK(BoardDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "select * from ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardname);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dto.setBoardNo(rs.getString(board_no));
                dto.setBoardTitle(rs.getString(board_title));
                dto.setBoardWriter(rs.getString(board_writer));
                dto.setBoardContent(rs.getString(board_content));
                //dto.setBoardPwd(rs.getString(5));
                dto.setBoardHit(rs.getInt(board_hit));
                dto.setBoardWdate(rs.getString(board_wdate));
                dto.setBoardEdit(rs.getString(board_edate));
                //dto.setBoardAdmin(rs.getString(9));
            }
            result = rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }

    @Override
    public int updateOK(TableDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "update table ? where boardNo = ? and boardPwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getTablename());
            pstmt.setString(2, dto.getBoardNo());
            pstmt.setString(3, dto.getBoardPwd());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    @Override
    public int deleteOK(TableDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "remove table ? where boardNo = ? and boardPwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getTablename());
            pstmt.setString(2, dto.getBoardNo());
            pstmt.setString(3, dto.getBoardPwd());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
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
    public void boardHit(String tablename, int bno) {
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
}
