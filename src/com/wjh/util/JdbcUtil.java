package com.wjh.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
    //加载资源文件
    static Properties pros = null;
    static{
        pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //与数据库建立连接
    public static Connection getConn(){
        try {
            Class.forName(pros.getProperty("mysqlDriver"));
            return DriverManager.getConnection(pros.getProperty("mysqlUrl"),pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //关闭   rs,ps,conn
    public static void close(ResultSet rs, Connection conn, PreparedStatement ps){

        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    // 关闭   ps conn
    public static void close( Connection conn, PreparedStatement ps){

        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    //关闭 conn
    public static void close(Connection conn){

        try {
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
