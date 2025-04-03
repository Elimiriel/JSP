package com.member.model;

public class BoardDTO {
    private int boardNo;
    private String boardWriter;
    private String boardTitle;
    private String boardCont;
    private String boardPwd;
    private int boardHit;
    private DateTime boardWdate;
    private DateTime boardEdit;
    private String boardAdmin;

    public List<BoardDTO> getList(String tablename, int curPage, int rowsize) {
        //
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        try {
            int startNo = (curPage - 1) * rowsize + 1;
            int endNo = startNo + rowsize - 1;
            openConn();
            //contents in page
            sql = "select * from (select row_number() over(order by board_no desc) as rnum"+//number of threads
                    ",b.* from ? b) where rnum between ? and ?";//call table as b, and rnum range in page setting
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tablename);
            pstmt.setInt(2, startNo);
            pstmt.setInt(3, endNo);
            rs = pstmt.executeQuery();
            while(re.next()) {
                BoardDTO dto = new BoardDTO();
                dto.setBoardNo(rs.getInt("board_no"));
                dto.setBoardTitle(rs.getString("board_title"));
                dto.setBoardWriter(rs.getString("board_writer"));
                dto.setBoardCont(rs.getString("board_cont"));
                dto.setBoardHit(rs.getInt("board_hit"));
                dto.setBoardWdate(rs.getString("board_wdate"));
                dto.setBoardEdit(rs.getString("board_edit"));
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
        return list;
    }

    /**
     * @return int return the board_no
     */
    public int getBoardNo() {
        return boardNo;
    }

    /**
     * @param board_no the board_no to set
     */
    public void setBoardNo(int boardNo) {
        this.boardNo = boardNo;
    }

    /**
     * @return String return the board_writter
     */
    public String getBoardWriter() {
        return boardWriter;
    }

    /**
     * @param board_writter the board_writter to set
     */
    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    /**
     * @return String return the board_title
     */
    public String getBoardTitle() {
        return boardTitle;
    }

    /**
     * @param board_title the board_title to set
     */
    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    /**
     * @return String return the boardCont
     */
    public String getBoardCont() {
        return boardCont;
    }

    /**
     * @param boardCont the boardCont to set
     */
    public void setBoardCont(String boardCont) {
        this.boardCont = boardCont;
    }

    /**
     * @return String return the boardPwd
     */
    public String getBoardPwd() {
        return boardPwd;
    }

    /**
     * @param boardPwd the boardPwd to set
     */
    public void setBoardPwd(String boardPwd) {
        this.boardPwd = boardPwd;
    }

    /**
     * @return String return the boardHit
     */
    public int getBoardHit() {
        return boardHit;
    }

    /**
     * @param boardHit the boardHit to set
     */
    public void setBoardHit(int boardHit) {
        this.boardHit = boardHit;
    }

    /**
     * @return DateTime return the boardWdate
     */
    public DateTime getBoardWdate() {
        return boardWdate;
    }

    /**
     * @param boardWdate the boardWdate to set
     */
    public void setBoardWdate(DateTime boardWdate) {
        this.boardWdate = boardWdate;
    }

    /**
     * @return DateTime return the boardEdit
     */
    public DateTime getBoardEdit() {
        return boardEdit;
    }

    /**
     * @param boardEdit the boardEdit to set
     */
    public void setBoardEdit(DateTime boardEdit) {
        this.boardEdit = boardEdit;
    }


    /**
     * @return String return the boardAdmin
     */
    public String getBoardAdmin() {
        return boardAdmin;
    }

    /**
     * @param boardAdmin the boardAdmin to set
     */
    public void setBoardAdmin(String boardAdmin) {
        this.boardAdmin = boardAdmin;
    }

}
