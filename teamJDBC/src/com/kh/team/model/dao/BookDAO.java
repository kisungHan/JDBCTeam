package com.kh.team.model.dao;

import static com.kh.team.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BookDAO {
	
	private Properties prop = null;
	
	public BookDAO() throws Exception {
		try {
			prop = new Properties();
			prop.load(new FileReader("bookSql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int bookCountChk(int no, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		try {
			String sql = prop.getProperty("bookCountChk");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public int bookRental(int no, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = prop.getProperty("bookRental");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}

}
