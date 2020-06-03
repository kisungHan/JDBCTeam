package com.kh.team.model.service;

import static com.kh.team.common.JDBCTemplate.close;
import static com.kh.team.common.JDBCTemplate.commit;
import static com.kh.team.common.JDBCTemplate.getConnection;
import static com.kh.team.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.team.model.dao.BookDAO;
import com.kh.team.model.vo.Member;

public class BookService {

	public int bookCountChk(int no) throws Exception {

		Connection conn = getConnection();

		int result = new BookDAO().bookCountChk(no, conn);

		close(conn);

		return result;
	}

	public int bookRental(int no) throws Exception {

		Connection conn = getConnection();

		int result = new BookDAO().bookRental(no, conn);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}

}
