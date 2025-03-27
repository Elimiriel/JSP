package com.emp.model;

/*
 * Singeton Pattern
 * 1. private static EmpDAO instance = new EmpDAO(); | private static!
 * 2. public static EmpDAO getInstance() { return instance; } | access object interface
 */
public class EmpDAO {
	private EmpDAO() {
		// Private constructor to prevent instantiation
	}
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql;
		public void openconnection() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "web", "1234");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static EmpDAO getInstance() {
			return instance;
		}
	public void closeCon(PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeCon(ResultSet rs, PreparedStatement pstmt, Connection con) {
			try {
				if(rs != null) rs.close();
				
				if(pstmt != null) pstmt.close();
				
				if(con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	public static List<EmpDTO> selectAll(HttpServletRequest request) {
		List<EmpDTO> list = new ArrayList<>();
		String sql = "select * from emp";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "web", "1234");
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setEmpno(rs.getInt("empno"));
				dto.setEname(rs.getString("ename"));
				dto.setJob(rs.getString("job"));
				dto.setMgr(rs.getInt("mgr"));
				dto.setHiredate(rs.getString("hiredate"));
				dto.setSal(rs.getInt("sal"));
				dto.setComm(rs.getInt("comm"));
				dto.setDeptno(rs.getInt("deptno"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			//무조건 실행부
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public list<String> getJoblist() {
        openConn();
        String sql = "select distinct job from emp order by job";//no duplicates
        List<String> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("job"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(rs, pstmt, conn);
        }
        return list;
    }
	public List<EmpDTO> selectMgrlist() {
        openConn();
        String sql = "select * from emp where empno in (select distinct(mgr) from emp) order by empno desc";
        List<EmpDTO> mgrlist = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                EmpDTO dto = new EmpDTO();
                dto.setMgr(rs.getInt("mgr"));
                mgrlist.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeCon(rs, pstmt, conn);
        }
        return mgrlist;
	}
	public List<EmpDTO> selectDeptlist() {
		openConn();
		String sql = "select * from emp where empno in (select distinct(deptno) from emp) order by empno desc";
		List<EmpDTO> deptlist = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EmpDTO dto = new EmpDTO();
				dto.setDeptno(rs.getInt("deptno"));
				deptlist.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeCon(rs, pstmt, conn);
		}
		return deptlist;
	}
}