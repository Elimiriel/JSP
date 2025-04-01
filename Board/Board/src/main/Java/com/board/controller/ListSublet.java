package Board.src.main.Java.com.board.controller;

@WebServlet("/list")
public class ListSublet {
    private static final long serialVersionUID = 1L; //1, long type

    public ListSublet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBDAO dao = DBDAO.getInstance();
        int count=DBDAO.
        request.setAttribute("list", list);
        request.setAttribute("count", count);

        //RequestDispatcher rd = request.getRequestDispatcher("path/list.jsp");
        //rd.forward(request, response);
        request.getRequestDispatcher("board/list.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    
}
