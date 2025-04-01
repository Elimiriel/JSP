package com.freeproject01.src.references.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.naming.spi.DirStateFactory.Result;

public class DBManager {
    private static DBManager instance = null;

    private DBManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }
    public static String DRIVER;
    public static String URL;
    public static String USER;
    public static String PASSWORD;
    public static void SetConnvalue(String kindDB, String user, String password) {
        kindDB=kindDB.toLowerCase();
        if(kindDB.contains("oracle")) {
            DBManager.DRIVER = "oracle.jdbc.driver.OracleDriver";
            DBManager.URL = "jdbc:oracle:thin:@localhost:1521:xe";
        } else {
            //while(kindDB.contains("oracle")) {}
            //Not ready for other DB yet
            DBManager.DRIVER = "oracle.jdbc.driver.OracleDriver";
            DBManager.URL = "jdbc:oracle:thin:@localhost:1521:xe";
        }
        DBManager.USER = user;
        DBManager.PASSWORD = password;
    }
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}