package dept02.dept02.com.dept02.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import dept02.dept02.com.dept02.DBManager;
import java.sql.ResultSet;
import dept02.dept02.com.dept02.DeptDTO;

public class DeptController01DAO {
    Connection conn = null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    String sql;
    public DeptController01DAO() {
        String driver="oracle.jdbc.driver.OracleDriver";
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="web"; //scott
        String password="1234"; //tiger

        try {
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<DeptDTO> deptlist() {
        ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
        try {
            conn = DBManager.getConnection();
            sql = "select * from dept order by deptno";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();//DB command run
            while (rs.next()) {
                //ArrayList of DeptDTO
                DeptDTO dto = new DeptDTO();
                dto.setDeptno(rs.getInt("deptno"));
                dto.setDname(rs.getString("dname"));
                dto.setLocation(rs.getString("loc"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return list;
    }
    public int insertDept(DeptDTO dto) {
        int result=0;
        try {
            conn = DBManager.getConnection();
            sql = "insert into dept values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getDeptno());
            pstmt.setString(2, dto.getDname());
            pstmt.setString(3, dto.getLocation());
            result = pstmt.executeUpdate();
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
        return result;
    }
    public int deleteDept(int deptno) {
        int result=0;
        try {
            conn = DBManager.getConnection();
            sql = "delete from dept where deptno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, deptno);
            result = pstmt.executeUpdate();
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
        return result;
    }
    public int updateDept(DeptDTO dto) {
        int result=0;
        try {
            conn = DBManager.getConnection();
            sql = "update dept set dname=?, location=? where deptno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getDname());
            pstmt.setString(2, dto.getLocation());
            pstmt.setInt(3, dto.getDeptno());
            result = pstmt.executeUpdate();
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
        return result;
    }
}
