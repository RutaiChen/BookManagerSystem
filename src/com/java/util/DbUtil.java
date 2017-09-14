package com.java.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author Artest
 *
 */
public class DbUtil {

	//数据库连接地址
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	//数据库的用户名
	private String dbUserName = "root";
	//数据库的密码
	private String dbPassword = "123456";
	//驱动名称
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);//加载驱动
		//建立连接
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	/**
	 * 关闭数据库连接
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
			System.out.println("数据库连接建立成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}
