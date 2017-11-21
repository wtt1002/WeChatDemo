package com.eastnet.wechat.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class MySQLBasic{

        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql =null;
        public Connection getConnection() 
        {
        try {
            /*****填写数据库相关信息(请查找数据库详情页)*****/
            String databaseName = "xlleBZYYFHLHxtidsFeW";
            String host = "sqld.duapp.com";
            String port = "4050";
            String username = "6f61291298ee4edf80945f82c1114274"; //用户AK
            String password = "9a3f5777c7d043c688b684efb1b1a73c"; //用户SK
            String driverName = "com.mysql.jdbc.Driver";
            String dbUrl = "jdbc:mysql://";
            String serverName = host + ":" + port + "/";
            String connName = dbUrl + serverName + databaseName;

            /******接着连接并选择数据库名为databaseName的服务器******/
            Class.forName(driverName);
            connection = (Connection) DriverManager.getConnection(connName, username,
                    password);
//            stmt = (Statement) connection.createStatement();
            /******至此连接已完全建立，就可对当前数据库进行相应的操作了*****/
            /******接下来就可以使用其它标准mysql函数操作进行数据库操作*****/
            //创建一个数据库表
//            sql = "create table if not exists test_mysql(" +
//                "id int primary key auto_increment," + "no int, " +
//                "name varchar(1024)," + "key idx_no(no))";
//            
//            stmt.execute(sql);
            return connection;
        } catch (Exception e) {
            //e.printStackTrace(resp.getWriter());
        	return null;
        }
        
    }
}
