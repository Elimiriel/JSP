package Board.src.main.Java.com.board.controller;

import com.board.controller.DBDAO;

@HttpSublet("/content")
public class ContentSublet {
    private static final long serialVersionUID = 1L;

    public ContentSublet() {
        super();
    }

    protected void hitup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bno = Integer.parseInt(request.getParameter("board_no"));
        DBDAO dao = DBDAO.getInstance();
        BoardDTO dto = dao.getContent(bno);
        request.setAttribute("content", dto);
        request.getRequestDispatcher("board/list.jsp").forward(request, response);
        DBDAO.getInstance().updateHit(bno);
    }

    protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bno = Integer.parseInt(request.getParameter("board_no"));
        DBDAO dao = DBDAO.getInstance();
        BoardDTO dto = dao.getContent(bno);
        request.setAttribute("content", dto);
        request.getRequestDispatcher("board/content.jsp").forward(request, response);
    }
    
}
