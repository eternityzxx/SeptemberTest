package com.test.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名和密码进行登录！");
		System.out.print("请输入用户名:");
		String username = br.readLine();
		System.out.print("请输入密码:");
		String pwd = br.readLine();
		//-------连接数据库--------
		Connection con = null;//数据库连接对象
		Statement statement = null;//数据库操作对象
		PreparedStatement ps = null;
		ResultSet rs = null;// 3.ResultSet类，用来存放获取到的结果集
		boolean flag = false;
		try {
			//1.注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.获取数据库连接
			String url = "jdbc:mysql://localhost:3306/testdemo_db?serverTimezone=GMT&useSSL=false";
			String user = "root";
			String password = "zxx123321";
			con=DriverManager.getConnection(url,user,password);	//返回数据库连接对象
			//3.定义SQL语句框架
			String sql = "select username from t_user where username = ? and password = ?";
			//4.执行SQL语句的预编译
			ps = con.prepareStatement(sql);
			//5.对SQL语句进行赋值
			ps.setString(1, username);
			ps.setString(2, pwd);
			//6.执行SQL语句
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
//		    //3.获取数据库操作对象
//			statement = con.createStatement();
//			//4.执行SQL语句 
//			String sql = "select username from t_user where username = '"+username+"' and password = '"+pwd+"'";
//			rs = statement.executeQuery(sql);
//			//5.处理查询结果集
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
		if(flag) {
			System.out.println("登录成功！");
		}else {
			System.out.println("您输入的用户名或密码有误,请重新输入！");
		}
	}

}
