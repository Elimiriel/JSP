package Springlike.src.main.java.com.member.action;

import com.board.controller.DBDAO;

public class DeleteAction implements Action {

    @Override
    public String execute(HttpSubletRequest request, HttpSubletResponse response) throws ActionException {
        DBDAO dao = DBDAO.getInstance();
        int delete = dao.deleteDoc();
        request.setAttribute("delete", delete);
        return "/member/delete.jsp";
    }
}