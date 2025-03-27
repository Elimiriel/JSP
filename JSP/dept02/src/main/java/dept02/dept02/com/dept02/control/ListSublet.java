package dept02.dept02.com.dept02.control;

import java.io.IOException;
import java.util.ArrayList;

import dept02.dept02.com.dept02.DeptDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListSublet extends HttpServlet {
    public ListSublet() {
        super();
    }
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptController01DAO dao = new DeptController01DAO();
        ArrayList<DeptDTO> list = dao.deptlist();
        request.setAttribute("list", list);
        RequestDispatcher dis = request.getRequestDispatcher("list.jsp");
        dis.forward(request, response);
    }

}
