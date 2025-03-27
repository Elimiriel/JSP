package References.java.com.emp.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

@WebServlet("/select")
public class SelectServlet {
    private SelectServlet() {
        super();
    }
    public static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //DB Access Object
        EmpDAO dao= EmpDAO.getInstance();
        List<EmpDTO> list = dao.allSelect(request);
        openconnection();
        sql = "select * from emp order by empno desc";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while(rs.next()) {
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
        request.setAttribute("list", list);
        request.getRequestDispatcher("view/emp_select.jsp").forward(request, response);
    }
    public List<EmpDTO> allSelect(HttpServletRequest request) {
        EmpDAO dao = EmpDAO.getInstance();
        List<EmpDTO> list = dao.selectAll(request);
        return list;
    }
    public List<EmpDTO> htmlOut(String outtype) {
        switch(outtype) {
            case "html":
                List emplist=this.allSelect(null);
                for(emplist.size();i<emplist.size();i++) {
                    
                }
                break;
            case "json":
                break;
        }
        
    }
}
