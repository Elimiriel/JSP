import Springlike.src.main.java.com.member.action.Action;

public class FrontController extends HttpSublet {
    private static final long serialVersionUID = 1L;
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //common codes
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        /*
        //manual building of Spring's functions
        //getRequestURI(): http://localhost:8080/Springlike/main -> /Springlike/main String return
        String uri=request.getRequestURI();
        //getContextPath(): http://localhost:8080/Springlike/main -> /Springlike String return| project name
        String contextPath=request.getContextPath();
        //Whole URI-project path=somefile
        //substring(): /Springlike/main -> main String return
        String command=uri.substring(contextPath.length()+1);//removing project path 
        */
        command=getAction(request);
        //command=main
        Action action=null;
        action=new ${command}Action();
        /*if(command.equals("list")) {
            action=new MainAction();
        } else if(command.equals("insert")) {
            action=new InsertAction();
        } else if(command.equals("delete")) {
            action=new DeleteAction();
        } else if(command.equals("selectOne")) {
            action=new SelectOneAction();
        } else if(command.equals("login")) {
            action=new LoginAction();
        } else if(command.equals("logout")) {
            action=new LogoutAction();
        } else if(command.equals("boardList")) {
            action=new BoardListAction();
        } else if(command.equals("boardInsert")) {
            action=new BoardInsertAction();
        } else if(command.equals("boardDelete")) {
            action=new BoardDeleteAction();
        } else if(command.equals("adminLogin")) {
            action=new BoardLoginAction();
        } else if(command.equals("adminLogout")) {
            action=new BoardLogoutAction();
        } else {
            action=new MainAction();
        }*/
        try {
            //actual running part
            String path=action.execute(request, response);//path=main.jsp, don't set path if action returns void
            RequestDispatcher rd=request.getRequestDispatcher(path);//viewPage="board/list.jsp; if action returns void
            rd.forward(request, response);
        } catch (ActionException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConn();
        }
    }
    private String getAction(HttpSublet request) {
        /*manual building of Spring's functions */
        //getRequestURI(): http://localhost:8080/Springlike/main -> /Springlike/main String return
        String uri=request.getRequestURI();
        //getContextPath(): http://localhost:8080/Springlike/main -> /Springlike String return| project name
        String contextPath=request.getContextPath();
        //Whole URI-project path=somefile
        //substring(): /Springlike/main -> main String return
        String command=uri.substring(contextPath.length()+1);//removing project path. http://localhost:8080/Springlike/main -> main String return
        command=command.substring(0, 0).toUpperCase()+command.substring(1);
        return command;
    }
}