package Board.src.main.Java.com.board.controller;

import java.io.IOException;

import Board.src.main.Java.com.board.model.BoardDTO;

@WebServlet("/modok")
public class ModOK extends HttpSublet {
    private static final long serialVersionUID = 1L;

    public ModOK() {
        super();
    }
    @WebServlet("/insert")
    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title").trim();
        String writer = request.getParameter("writer").trim();
        String content = request.getParameter("content").trim();
        String pwd=request.getParameter("pwd").trim();
        int bno = Integer.parseInt(request.getParameter("board_no").trim());//hidden
        
        
        DBDTO dto = new DBDTO();
        dto.setBoard_title(title);
        dto.setBoard_writer(writer);
        dto.setBoard_content(content);
        dto.setBoard_pwd(pwd);
        
        //connector
        DBDAO dao = DBDAO.getInstance();
        int result = dao.insertok(dto);
        if (result == 1) {
            response.sendRedirect("list");
        } else {
            response.sendRedirect("write");
        }
    }
    }
    @WebServlet("/remove")
    protected void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title").trim();
        String writer = request.getParameter("writer").trim();
        String content = request.getParameter("content").trim();
        String pwd=request.getParameter("pwd").trim();
        int bno = Integer.parseInt(request.getParameter("board_no").trim());//hidden
        
        DBDTO dto = new DBDTO();
        dto.setBoard_title(title);
        dto.setBoard_writer(writer);
        dto.setBoard_content(content);
        dto.setBoard_pwd(pwd);
        
        //connector
        DBDAO dao = DBDAO.getInstance();
        int result = dao.deleteok(dto);
        if (result == 1) {
            response.sendRedirect("list");
        } else {
            response.sendRedirect("write");
        }
    }
    public int insertok(BoardDTO dto) {
        int result = 0;
        int bno=0;
        try {}
            openConn();
            sql = "select max(board_no) from board";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                bno = rs.getInt(1) + 1;
                sql="insert into board values(?, ?, ?, ?, ?, default, sysdate, '')";
                pstmt=conn.prepareStatement(sql);
                pstmt.setInt(1, bno);
                pstmt.setInt(2, pstmt.getBoard_writer());`
                pstmt.setString(3, pstmt.getBoard_title());
                pstmt.setString(4, pstmt.getBoard_content());
                pstmt.setString(5, pstmt.getBoard_pwd());
                pstmt.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeconn();
            }
        if(result > 0) {
            out.println("<script>");
            out.println("alert('게시글 추가 성공!!!')");
            out.println("location.href='list.go'");
            out.println("</script>");
        }else {
            out.println("<script>");
            out.println("alert('게시글 추가 실패~~~')");
            out.println("history.back()");
            out.println("</script>");
        }
        return result;
    }
    public int deleteok(BoardDTO dto) {
        int result = 0;
        try {
            openConn();
            sql = "delete from board where board_no = ? and board_pwd = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, dto.getBoard_no());
            pstmt.setString(2, dto.getBoard_pwd());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
    @WebServlet("/modify")
    protected void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String title = request.getParameter("title").trim();
        String content = request.getParameter("content").trim();
        int bno = Integer.parseInt(request.getParameter("bno"));
        DBDAO dao = DBDAO.getInstance();
        if (dao.getPwd(bno).equals(request.getParameter("pwd"))) {
            response.sendRedirect("list");
    }
        
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int bno = Integer.parseInt(request.getParameter("bno"));
        DBDAO dao = DBDAO.getInstance();
        if (dao.getPwd(bno).equals(request.getParameter("pwd"))) {
            response.sendRedirect("list");
        }
    }
    @WebServlet("/modPwd")
    public boolean matchPwd(int bno, String pwd) {
        boolean result = false;
        try {
            openConn();
            sql = "select board_pwd from board where board_no = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString(1).equals(pwd)) {
                    //pwd check
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return result;
    }
}
