package com.kh.team.model.dao;

import static com.kh.team.common.JDBCTemplate.*;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.kh.team.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() throws Exception {
		try {
			prop = new Properties();
			prop.load(new FileReader("memberSql.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Member login(Member inputLogin, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member mem = null;
		
		try {
			String sql = prop.getProperty("loginMember");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inputLogin.getMemberId());
			pstmt.setString(2, inputLogin.getMemberPwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				mem = new Member(rset.getString("id"),
						rset.getString("pwd"),
						rset.getString("name"),
						rset.getString("gender").charAt(0),
						rset.getString("tel"),
						rset.getString("addr"),
						rset.getInt("mem_grade"),
						rset.getString("return_yn").charAt(0),
						rset.getInt("rental_count"),
						rset.getInt("rental_book"),
						rset.getDate("enroll_date"));
			}
			
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return mem;
	}

	/** 회원가입용
	 * @param mem
	 * @param conn
	 * @return mem
	 * @throws Exception
	 */
	public int insertJoin(Member mem, Connection conn) throws Exception{
		
		PreparedStatement pstmt = null; //SQL을 DB에 전달하고 결과를 반환받을 PreparedStatement 변수 선언.
		
		int result = 0; // DB 삽입 결과 저장용 변수 선언 
		
		String sql = prop.getProperty("insertJoin"); // sql에 외부에 있는 memberSql.properties에 insertJoin를 넣어줌
		
		try { // 무슨 상황이 발생할수 있어서 try를 쓴다했는데 여전히 까먹음.
			
			pstmt = conn.prepareStatement(sql); // 위에 작성한 sql을 가져옴
			
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getGender() + "");// char형태에서 String으로 변경해주기위해 + ""를 넣어줌;
			pstmt.setString(5, mem.getMemTel());
			pstmt.setString(6, mem.getMemAddr());
			
			result = pstmt.executeUpdate();// 쿼리 실행 후 결과를 받아옴
	
		}finally {
			close(pstmt);
		}
		return result;
		
	}	
	
	public int memberRental(String id, int no, Connection conn) throws Exception {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = prop.getProperty("memberRental");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		return result;
	}	// 도서 대여

}
