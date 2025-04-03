package Springlike.src.main.java.com.member.controller;

import Springlike.src.main.java.com.member.model.TableDTO;

public class TableDAO implements DBDAO {
    private static TableDAO("table") instance = null;
    public static TableDAO getInstance() {
        return instance;
    }
    String boardname="Board_Admin_Table";

    @Override
    public int createOK(TableDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = webapp/WEB-INF/sql/Table.sql;
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardname);
            pstmt.executeUpdate();
            sql="insert into ? values(?, ?)";
            pstmt.setString(1, boardname);
            pstmt.setString(2, dto.getTableAdmin());
            pstmt.setString(3, dto.getTablePwd());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }

    @Override
    public int readOK(TableDTO dto) {
        int result = 0;
        
        try {
            openConn();
            sql = "select ?, ? from ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getTableAdmin());
            pstmt.setString(2, dto.gettablePwd());
            pstmt.setString(3, boardname);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                dto.setTableAdmin(rs.getString(1));
                dto.settablePwd(rs.getString(2));
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
    public int updateOK(TableDTO dto, TableDTO ndto) {
        int result = 0;
        try {
            openConn();
            sql="select tablePwd from ? where tableAdmin = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardname);
            pstmt.setString(2, dto.getTableAdmin());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                if(rs.getString(1).equals(dto.getTablePwd())) {
                    sql = "update (select tableAdmin, tablePwd from ?) set (tableAdmin= ?, tablePwd = ?) where tableAdmin = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, boardname);
                    pstmt.setString(2, dto.setTableAdmin());
                    pstmt.setString(3, dto.settablePwd());
                    pstmt.setString(4, dto.getTableAdmin());
                    result = pstmt.executeUpdate();
                }
            }
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
            sql = "remove table ? where tableName = ? and tablePwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boardname);
            pstmt.setString(2, dto.getBoard_no());
            pstmt.setString(3, dto.getBoard_pwd());
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
}