package com.kgc.hadoop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by yang.liu on 2017/12/15.
 */
public class HiveJDBC {
    private static String driverName="org.apache.hive.jdbc.HiveDriver";
    private static String url="jdbc:hive2://hadoop000:10000/default";
    private static String user="hadoop";
    private static String password="";
    public static void main(String[] args)throws Exception{
        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url,user,password);
        Statement stmt = conn.createStatement();

        String sql = "select * from emp";

        ResultSet rs = stmt.executeQuery(sql);
        System.out.println("Running sql is " + sql);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
        }

        rs.close();
        stmt.close();
        conn.close();
    }
}
