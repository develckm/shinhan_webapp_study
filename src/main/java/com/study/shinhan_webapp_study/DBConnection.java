package com.study.shinhan_webapp_study;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection conn;
    private static String user="boardServerDev";
    private static String password="mysql123";
    private static String url="jdbc:mysql://localhost:3306/webAppBoard";
    public static Connection getConn() throws Exception{
        if( conn==null || conn.isClosed()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,password);
        }
        return conn;
    }
    //test 용도의 main => 보기도 흉하고 관리도 힘들다 -> 단위 테스트 (jUnit)
//    public static void main(String[] args) throws Exception {
//        System.out.println(DBConnection.getConn());
//    }

}
