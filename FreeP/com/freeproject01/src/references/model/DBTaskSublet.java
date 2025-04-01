package com.freeproject01.src.references.model;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.freeproject01.src.references.util.DBManager; // Adjust the package path as needed

import java.sql.ResultSet;

public class DBTaskSublet {
    private static DBTaskSublet instance = null;
    public static DBTaskSublet getInstance() {
        if (instance == null) {
            instance = new DBTaskSublet();
        }
        return instance;
    }
    Connection conn = DBManager.getConnection();
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String sql;
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
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
                    } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void constructCol(String tablename, Map<String, Integer> coltype, String colname, String colprop) {
        PreparedStatement pstmt2 = null; // Declare pstmt2 at the beginning of the method
        try {
            conn = DBManager.getConnection();
            sql = "ALTER TABLE ? ADD ?, ?(?), ?";
            String sqlSize = "SELECT column_num FROM ?";
            pstmt = conn.prepareStatement(sql);
            pstmt2 = conn.prepareStatement(sqlSize);
            pstmt2.setString(1, tablename);
            rs = pstmt2.executeQuery();
            if (!rs.next()) {
                colprop = "Primary Key" + colprop;
            }
            pstmt.setString(1, tablename);
            pstmt.setString(2, colname);
            pstmt.setString(3, coltype.keySet().toString());
            pstmt.setString(4, coltype.values().toString());
            pstmt.setString(5, colprop);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (pstmt2 != null) { // Properly indent this block
                    pstmt2.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void constructCols(String tablename, Map<String, Integer>[] coltype, String[] colname, String[] colprop) {
        PreparedStatement pstmt2=null;
        try {
            conn = DBManager.getConnection();
            String sqlSize = "SELECT column_num FROM ?";
            pstmt2 = conn.prepareStatement(sqlSize);
            pstmt2.setString(1, tablename);
            rs=pstmt2.executeQuery();
            if(!rs.next()) {
                colprop[0]="Primary Key"+colprop[0];
            }
            for(int i=0; i<colname.length; i++) {
                sql = "ALTER TABLE " + tablename + " ADD ?, ?(?), ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, colname[i]);
                pstmt.setString(2, coltype[i].keySet().toString());
                pstmt.setString(3, coltype[i].values().toString());
                pstmt.setString(4, colprop[i]);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (pstmt2 != null)
                    pstmt2.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void dropCol(String tablename, String colname) {
        try {
            conn = DBManager.getConnection();
            sql = "ALTER TABLE ? DROP ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.setString(2, colname);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    public void dropTable(String tablename) {
        try {
            conn = DBManager.getConnection();
            sql = "drop table ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}

