package com.emp.controller;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/insert")
public class InsertSublet extends HttpSublet {
    public InsertSublet() {
        super();
    }
    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EmpDAO dao = EmpDAO.getInstance();
    List<String> list = dao.getJoblist();
    List<EmpDTO> mgrlist = dao.selectMgrlist();
    List<DeptDTO> deptlist = dao.selectDeptlist();//connecting dept and emp
    request.setAttribute("mgrlist", mgrlist);
    request.setAttribute("list", list);
    request.setAttribute("deptlist", deptlist);
    request.getRequestDispatcher("view/emp_insert.jsp").forward(request, response);
    }
}
