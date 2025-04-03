package Springlike.src.main.java.com.member.action;

import com.member.model.TableDTO;

import Springlike.src.main.java.com.member.controller.TableDDAO;

public class ReadAction implements Action{

    @Override
    public String execute(HttpSubletRequest request, HttpSubletResponse response) throws ActionException {
        int boardNo=Integer.parseInt(request.getParameter("board_no"));
        int curPage=Integer.parseInt(request.getParameter("curPage"));
        if(request.getParameter("tablename")!=null||request.getParameter("board_no")!=null) {
            TableDDAO dao = TableDDAO.getInstance();
            BoardDTO dto = dao.getDocNums(boardNo);
            request.setAttribute("dto", dto);
            request.setAttribute("curPage", curPage);
            String targetname=request.getParameter("tablename");
            return "/member/read.jsp";
        }
        /*else if(request.getparameter("admin_id")!=null) {
            TableDAO dao = TableDAO.getInstance();
            TableDTO dto = dao.getDocNums(boardNo);
            request.setAttribute("dto", dto);
            request.setAttribute("curPage", curPage);
            return "/member/admin_read.jsp";
    }*/
    }
}
