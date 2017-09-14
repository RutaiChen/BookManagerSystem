package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author Artest
 *
 */
public class DbUtil {

	//���ݿ����ӵ�ַ
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	//���ݿ���û���
	private String dbUserName = "root";
	//���ݿ������
	private String dbPassword = "123456";
	//��������
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);//��������
		//��������
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * �ر����ݿ�����
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con)throws Exception{
		if(con != null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			Connection con = dbUtil.getCon();
			System.out.println("���ݿ����ӽ����ɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
	}
}
