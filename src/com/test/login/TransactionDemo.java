package com.test.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

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
			
			//关闭自动提交，开始了事务
			con.setAutoCommit(false);
			//3.定义SQL语句：事务只与DML语句有关
			String sql_delete = "delete from t_user where id = ?";
			//4.进行SQL语句的预编译
			ps = con.prepareStatement(sql_delete);
			//5.进行赋值
			ps.setInt(1, 4);
			//6.执行SQL语句
			count = ps.executeUpdate();
			//提交事务
			con.commit();
		} catch (Exception e) {
			
			try {
				// 事务回滚
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
