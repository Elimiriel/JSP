package com.member.action;

public interface Action {
    //only const or abstract method
    /*void also possible */
    String execute(HttpSubletRequest request, HttpSubletResponse response) throws ActionException;//+.jsp=path
}
