package com.freeproject01.src.references.model;

import java.io.File;
import java.util.Map;

import com.freeproject01.src.references.util.DBManager;

public class SubletDAO {
    private SubletDAO() {}
    private static SubletDAO instance = null;
    public static SubletDAO getInstance() {
        if (instance == null) {
            instance = new SubletDAO();
        }
        return instance;
    }
    public void insert(String tablename, Map<String, Integer>[] coltype, String[] colname) {
        File file;
        file = new File("SubletDTO.java");
        if (file.exists()) {
            file.canWrite();
            Class<?> targetclass = file.getClass();
            for(int i=0; i<colname.length; i++) {
                try {
                    Object instance = targetclass.getDeclaredConstructor().newInstance();
                    // Assuming coltype[i] is a Map.Entry<String, Integer> and colname[i] is the field name
                    // Assuming a setter method exists for the field
                    String setterMethodName = "set" + Character.toUpperCase(colname[i].charAt(0)) + colname[i].substring(1);
                    targetclass.getMethod(setterMethodName, coltype[i].get(colname[i]).getClass()).invoke(instance, coltype[i].get(colname[i]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
        public void insert(SubletDTO dto) {
        try {
            conn = DBManager.getConnection();
            sql = "insert into emp values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getEmpno());
            pstmt.setString(2, dto.getEname());
            pstmt.setString(3, dto.getJob());
            pstmt.setInt(4, dto.getMgr());
            pstmt.setString(5, dto.getHiredate());
            pstmt.setInt(6, dto.getSal());
            pstmt.setInt(7, dto.getComm());
            pstmt.setInt(8, dto.getDeptno());
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
    public void update(SubletDTO dto) {
        try {
            conn = DBManager.getConnection();
            sql = "update emp set ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? where empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getEname());
            pstmt.setString(2, dto.getJob());
            pstmt.setInt(3, dto.getMgr());
            pstmt.setString(4, dto.getHiredate());
            pstmt.setInt(5, dto.getSal());
            pstmt.setInt(6, dto.getComm());
            pstmt.setInt(7, dto.getDeptno());
            pstmt.setInt(8, dto.getEmpno());
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
    public void delete(SubletDTO dto) {
        try {
            conn = DBManager.getConnection();
            sql = "delete from emp where empno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getEmpno());
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
    }