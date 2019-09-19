package com.test.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDemo {

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
			
			//�ر��Զ��ύ����ʼ������
			con.setAutoCommit(false);
			//3.����SQL��䣺����ֻ��DML����й�
			String sql_delete = "delete from t_user where id = ?";
			//4.����SQL����Ԥ����
			ps = con.prepareStatement(sql_delete);
			//5.���и�ֵ
			ps.setInt(1, 4);
			//6.ִ��SQL���
			count = ps.executeUpdate();
			//�ύ����
			con.commit();
		} catch (Exception e) {
			
			try {
				// ����ع�
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
