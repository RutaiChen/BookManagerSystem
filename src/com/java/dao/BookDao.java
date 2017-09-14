package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.model.Book;
import com.java.model.BookType;
import com.java.util.StringUtil;

/**
 * 图书Dao类
 * @author Artest
 *
 */
public class BookDao {

	/**
	 * 添加图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询图书
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_book b,t_bookType bt where b.bookType = bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId() != null && book.getBookTypeId()!= -1){
			sb.append(" and b.bookType = "+book.getBookTypeId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	/**
	 * 删除图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id)throws Exception{
		String sql = "delete from t_book where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 更新图书信息
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Book book)throws Exception{
		String sql = "update t_book set bookName = ?,author = ?,sex = ?,price = ?,bookDesc = ?,bookType = ? where id =? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
	
	public boolean existBookByBookTypeId(Connection con,String bookTypeId)throws Exception{
		String sql = "select * from t_book where bookType = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookTypeId);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
}
