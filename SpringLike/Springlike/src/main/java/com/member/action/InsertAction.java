package Springlike.src.main.java.com.member.action;

import com.board.controller.DBDAO;

public class InsertAction implements Action {
    @Override
    public String execute(HttpSubletRequest request, HttpSubletResponse response) throws ActionException` {
        DBDAO dao = DBDAO.getInstance();
        int insert = dao.insert();
        int boardNo=Integer.parseInt(request.getParameter("board_no"));
        int curPage=Integer.parseInt(request.getParameter("curPage"));
        
        request.setAttribute("insert", insert);
        return "/member/insert.jsp";
    }
}