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
		Connection con = null;//���ݿ����Ӷ���
		Statement statement = null;//���ݿ��������
		PreparedStatement ps = null;	
	    int count =0;

			try {
				//1.ע������
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2.��ȡ���ݿ�����
				String url = "jdbc:mysql://localhost:3306/testdemo_db?serverTimezone=GMT&useSSL=false";
				String user = "root";
				String password = "zxx123321";
				con=DriverManager.getConnection(url,user,password);	//�������ݿ����Ӷ���
//				//3.����SQL�����   DML->insert
//				String sql_insert = "insert into t_user(username,password) values(?,?)";
//				//4.ִ��SQL����Ԥ����
//				ps = con.prepareStatement(sql_insert);
//				//5.���и�ֵ
//				ps.setString(1, "������");
//				ps.setString(2, "wdw");
//				//6.ִ��SQL���
//				count = ps.executeUpdate();
				
//				//ִ��SQL�����   DML->update
//				String sql_update = "update t_user set username = ? where id = ?";
//				//����SQL����Ԥ����
//				ps = con.prepareStatement(sql_update);
//				//���и�ֵ
//				ps.setString(1, "�Ź���");
//				ps.setInt(2, 3);
//				//ִ��SQL���
//				count = ps.executeUpdate();
				
				//ִ��SQL�����  DML-delete
				String sql_delete = "delete from t_user where id = ?";
				//����SQL����Ԥ����
				ps = con.prepareStatement(sql_delete);
				//���и�ֵ
				ps.setInt(1, 3);
				//ִ��SQL���
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
