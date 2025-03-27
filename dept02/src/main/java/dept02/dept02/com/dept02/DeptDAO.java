package dept02.dept02.com.dept02;
//Access and Tasking to DB Object: Single task per task and DB

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import dept02.dept02.com.dept02.DBManager;

import javax.naming.spi.DirStateFactory.Result;

public class DeptDAO {
    Connection conn = null;
    PreparedStatement pstmt=null;
    Result rs=null;
    String sql;
    public DeptDAO() {
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
    public void insert(DeptDTO dto) {
        try {
            conn = DBManager.getConnection();
            sql = "insert into dept values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getDeptno());
            pstmt.setString(2, dto.getDname());
            pstmt.setString(3, dto.getLocation());
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
    public void update(DeptDTO dto) {
        try {
            conn = DBManager.getConnection();
            sql = "update dept set dname=?, location=? where deptno=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getDname());
            pstmt.setString(2, dto.getLocation());
            pstmt.setInt(3, dto.getDeptno());
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
