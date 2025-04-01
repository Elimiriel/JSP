package Board.src.main.Java.com.board.model;

public class BoardDTO {
    private int board_no;
    private String board_writter;
    private String board_title;
    private String board_cont;
    private String board_pwd;
    private String board_hit;
    private DateTime board_wdate;
    private DateTime board_edit;

    /**
     * @return int return the board_no
     */
    public int getBoard_no() {
        return board_no;
    }

    /**
     * @param board_no the board_no to set
     */
    public void setBoard_no(int board_no) {
        this.board_no = board_no;
    }

    /**
     * @return String return the board_writter
     */
    public String getBoard_writter() {
        return board_writter;
    }

    /**
     * @param board_writter the board_writter to set
     */
    public void setBoard_writter(String board_writter) {
        this.board_writter = board_writter;
    }

    /**
     * @return String return the board_title
     */
    public String getBoard_title() {
        return board_title;
    }

    /**
     * @param board_title the board_title to set
     */
    public void setBoard_title(String board_title) {
        this.board_title = board_title;
    }

    /**
     * @return String return the board_cont
     */
    public String getBoard_cont() {
        return board_cont;
    }

    /**
     * @param board_cont the board_cont to set
     */
    public void setBoard_cont(String board_cont) {
        this.board_cont = board_cont;
    }

    /**
     * @return String return the board_pwd
     */
    public String getBoard_pwd() {
        return board_pwd;
    }

    /**
     * @param board_pwd the board_pwd to set
     */
    public void setBoard_pwd(String board_pwd) {
        this.board_pwd = board_pwd;
    }

    /**
     * @return String return the board_hit
     */
    public String getBoard_hit() {
        return board_hit;
    }

    /**
     * @param board_hit the board_hit to set
     */
    public void setBoard_hit(String board_hit) {
        this.board_hit = board_hit;
    }

    /**
     * @return DateTime return the board_wdate
     */
    public DateTime getBoard_wdate() {
        return board_wdate;
    }

    /**
     * @param board_wdate the board_wdate to set
     */
    public void setBoard_wdate(DateTime board_wdate) {
        this.board_wdate = board_wdate;
    }

    /**
     * @return DateTime return the board_edit
     */
    public DateTime getBoard_edit() {
        return board_edit;
    }

    /**
     * @param board_edit the board_edit to set
     */
    public void setBoard_edit(DateTime board_edit) {
        this.board_edit = board_edit;
    }

}
