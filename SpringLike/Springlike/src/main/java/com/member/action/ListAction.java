package com.member.action;
/*class to sublet as Action */

import java.lang.reflect.Member;
import java.util.List;

import com.board.controller.DBDAO;
import com.member.model.BoardDTO;

import Springlike.src.main.java.com.member.controller.TableDDAO;

public class ListAction implements Action {
    @Override
    public String execute(HttpSubletRequest request, HttpSubletResponse response) throws ActionException {
        //paging process
        int rowsize=10;//number of rows per page
        int blocksize=10;//number of max page blocks per page
        int allDBthreads=0;//total number of threads/items in DB
        int allPage=0;//total number of pages
        int curPage=0;//current page memoryspace
        if(request.getParameter("curPage")!=null) {
            //returning to current page
            curPage=Integer.parseInt(request.getParameter("curPage").trim());
        } else {
            //initial page
            curPage=1;
        }
        //start thread of current page
        int startRow=(curPage-1)*rowsize+1;//:=(curPage*rowsize)-(rowsize-1);//start row of current page
        int endRow=startRow+rowsize-1;//end row of current page:=(curPage*rowsize);
        //setting block view range
        int startBlock=(curPage-1)/blocksize*blocksize+1;//start block of current page
        int endBlock=startBlock+blocksize-1;//end block of current page
        
        TableDDAO dao = TableDDAO.getInstance();
        allDBthreads=dao.getDocNums();
        allPage=allDBthreads/rowsize+(allDBthreads%rowsize==0?0:1);//total number of pages+extra thread page. :=Math.ceil(allDBthreads/rowsize)
        if(endBlock>allPage) endBlock=allPage;//removing empty block

        //FrontController is the dispatcher+sending paging info to 
        TableDDAO dao = TableDDAO.getInstance();
        List<BoardDTO> list = dao.getDocNums(tablename, startRow, endRow);//contents
        //setting ALL parameters
        request.setAttribute("startRow", startRow);
        request.setAttribute("endRow", endRow);
        request.setAttribute("allPage", allPage);
        request.setAttribute("startBlock", startBlock);
        request.setAttribute("endBlock", endBlock);
        request.setAttribute("curPage", curPage);
        request.setAttribute("allDBthreads", allDBthreads);
        request.setAttribute("tablename", tablename);
        request.setAttribute("blocksize", blocksize);
        request.setAttribute("rowsize", rowsize);
        request.setAttribute("list", list);//contents
        return "/member/list.jsp";//not need if Action returns void
    }
}