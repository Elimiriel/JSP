String board_writer = request.getParameter("writer").trim();
String board_title = request.getParameter("title").trim();
String board_cont = request.getParameter("content").trim();
String board_pwd = request.getParameter("pwd").trim(); {
    
    dto.setBoard_no(board_no);
    dto.setBoard_writer(board_writer);
    dto.setBoard_title(board_title);
    dto.setBoard_cont(board_cont);
    dto.setBoard_pwd(board_pwd);