package com.test.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//-----从控制台获取用户输入的信息------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名和密码进行注册！");
		System.out.print("请输入用户名:");
		String username = br.readLine();
		System.out.print("请输入密码:");
		String pwd = br.readLine();
		//-------连接数据库--------
		Connection con = null;//数据库连接对象
		Statement statement = null;//数据库操作对象
		int count = 0;
        try {
        	//1注册驱动
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
			//2获取数据库连接
			String url = "jdbc:mysql://localhost:3306/testdemo_db?serverTimezone=GMT&useSSL=false";
			String user = "root";
			String password = "zxx123321";
			con=DriverManager.getConnection(url,user,password);	//返回数据库连接对象
			//3获取数据库操作对象
			statement=con.createStatement();//通过数据库连接对象提供的方法获取数据库操作对象
			//4执行SQL语句->DML语句（insert update delete）
			String sql = "insert into t_user(username,password) values('"+username+"','"+pwd+"')";
		 	count = statement.executeUpdate(sql);//执行，用数据库操作对象	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(statement!=null) {
				try {
					statement.close();
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
        if(count==1) {
        	System.out.println("注册成功");
        }else {
        	System.out.println("注册失败");
        }
	}
}
