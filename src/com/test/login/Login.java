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
		System.out.println("�������û�����������е�¼��");
		System.out.print("�������û���:");
		String username = br.readLine();
		System.out.print("����������:");
		String pwd = br.readLine();
		//-------�������ݿ�--------
		Connection con = null;//���ݿ����Ӷ���
		Statement statement = null;//���ݿ��������
		PreparedStatement ps = null;
		ResultSet rs = null;// 3.ResultSet�࣬������Ż�ȡ���Ľ����
		boolean flag = false;
		try {
			//1.ע������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/testdemo_db?serverTimezone=GMT&useSSL=false";
			String user = "root";
			String password = "zxx123321";
			con=DriverManager.getConnection(url,user,password);	//�������ݿ����Ӷ���
			//3.����SQL�����
			String sql = "select username from t_user where username = ? and password = ?";
			//4.ִ��SQL����Ԥ����
			ps = con.prepareStatement(sql);
			//5.��SQL�����и�ֵ
			ps.setString(1, username);
			ps.setString(2, pwd);
			//6.ִ��SQL���
			rs = ps.executeQuery();
			if(rs.next()) {
				flag = true;
			}
//		    //3.��ȡ���ݿ��������
//			statement = con.createStatement();
//			//4.ִ��SQL��� 
//			String sql = "select username from t_user where username = '"+username+"' and password = '"+pwd+"'";
//			rs = statement.executeQuery(sql);
//			//5.�����ѯ�����
			
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
			System.out.println("��¼�ɹ���");
		}else {
			System.out.println("��������û�������������,���������룡");
		}
	}

}
