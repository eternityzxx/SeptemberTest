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
		//-----�ӿ���̨��ȡ�û��������Ϣ------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û������������ע�ᣡ");
		System.out.print("�������û���:");
		String username = br.readLine();
		System.out.print("����������:");
		String pwd = br.readLine();
		//-------�������ݿ�--------
		Connection con = null;//���ݿ����Ӷ���
		Statement statement = null;//���ݿ��������
		int count = 0;
        try {
        	//1ע������
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	
			//2��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/testdemo_db?serverTimezone=GMT&useSSL=false";
			String user = "root";
			String password = "zxx123321";
			con=DriverManager.getConnection(url,user,password);	//�������ݿ����Ӷ���
			//3��ȡ���ݿ��������
			statement=con.createStatement();//ͨ�����ݿ����Ӷ����ṩ�ķ�����ȡ���ݿ��������
			//4ִ��SQL���->DML��䣨insert update delete��
			String sql = "insert into t_user(username,password) values('"+username+"','"+pwd+"')";
		 	count = statement.executeUpdate(sql);//ִ�У������ݿ��������	
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
        	System.out.println("ע��ɹ�");
        }else {
        	System.out.println("ע��ʧ��");
        }
	}
}
