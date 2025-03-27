package dept02.dept02.com.dept02.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dept02.dept02.com.dept02.DBManager;
import dept02.dept02.com.dept02.DeptDAO;
import dept02.dept02.com.dept02.DeptDTO;
import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("insertOK")
public class InsertOK extends HttpServlet {
    public InsertOK() {
        super();
    }
    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno").trim();
        String dname = request.getParameter("dname").trim();
        String loc = request.getParameter("loc").trim();
        DeptDTO dto = new DeptDTO();
        dto.setDeptno(Integer.parseInt(deptno));//deptno is int type
        dto.setDname(dname);
        dto.setLocation(loc);
        DeptDAO dao = new DeptDAO();
        DeptController01DAO daomain = new DeptController01DAO();
        daomain.insertDept(dto);
        response.sendRedirect("deptlist");
        PrintWriter out = response.getWriter();
        
        if (out != null)  {
            out.println("<script>");
            out.println("alert('Insert Success')");
            out.println("location.href='deptlist'");
            out.println("</script>");
            out.close();
        } else {
            response.sendRedirect("history.back()");
        }
    }
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno").trim();
        String dname = request.getParameter("dname").trim();
        String loc = request.getParameter("loc").trim();
        
        DeptDTO dto = new DeptDTO();
        dto.setDeptno(Integer.parseInt(deptno));
        dto.setDname(dname);
        dto.setLocation(loc);
        
        DeptController01DAO dao = new DeptController01DAO();
        dao.updateDept(dto);
        response.sendRedirect("deptlist");
        PrintWriter out = response.getWriter();
        
        if (out != null)  {
            out.println("<script>");
            out.println("alert('Update Success')");
            out.println("location.href='deptlist'");
            out.println("</script>");
            out.close();
        } else {
            response.sendRedirect("history.back()");
        }
    }
}
