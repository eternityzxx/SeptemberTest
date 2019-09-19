package com.test.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;//数据库连接对象
		Statement statement = null;//数据库操作对象
		PreparedStatement ps = null;	
	    int count =0;

			try {
				//1.注册驱动
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2.获取数据库连接
				String url = "jdbc:mysql://localhost:3306/testdemo_db?serverTimezone=GMT&useSSL=false";
				String user = "root";
				String password = "zxx123321";
				con=DriverManager.getConnection(url,user,password);	//返回数据库连接对象
//				//3.定义SQL语句框架   DML->insert
//				String sql_insert = "insert into t_user(username,password) values(?,?)";
//				//4.执行SQL语句的预编译
//				ps = con.prepareStatement(sql_insert);
//				//5.进行赋值
//				ps.setString(1, "王大伍");
//				ps.setString(2, "wdw");
//				//6.执行SQL语句
//				count = ps.executeUpdate();
				
//				//执行SQL语句框架   DML->update
//				String sql_update = "update t_user set username = ? where id = ?";
//				//进行SQL语句的预编译
//				ps = con.prepareStatement(sql_update);
//				//进行赋值
//				ps.setString(1, "张哈哈");
//				ps.setInt(2, 3);
//				//执行SQL语句
//				count = ps.executeUpdate();
				
				//执行SQL语句框架  DML-delete
				String sql_delete = "delete from t_user where id = ?";
				//进行SQL语句的预编译
				ps = con.prepareStatement(sql_delete);
				//进行赋值
				ps.setInt(1, 3);
				//执行SQL语句
				count = ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(ps!=null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
	}

}
