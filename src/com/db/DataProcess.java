package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

public class DataProcess {
	private String DB_URL = "jdbc:mysql://localhost:3306/webshopping?useSSL=false&serverTimezone=UTC";
	private String USER = "root";
	private String PASS = "123456";
	private Connection conn = null;
	private Statement stmt = null;
	public Vector getData(String sql){
		Vector rows=new Vector();
		try{
			// 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData rstd=rs.getMetaData();
			Vector rowData=null;
			// 展开结果集数据库
			while(rs.next()){
				rowData=new Vector();
				for (int i = 1; i <rstd.getColumnCount()+1 ; i++) {
					rowData.add(rs.getString(i));
				}
//				rowData.add(rst.getString(1));
//				rowData.add(rst.getString(2));
				rows.add(rowData);
			}
			stmt.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
		}
		return rows;
	}
	public int update(String sql){
		int num=0;
		try{
			// 注册 JDBC 驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt=conn.createStatement();
			num=stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}catch(Exception e){
			System.err.print(e);
			return -1;
		}
		return num;
	}
}



