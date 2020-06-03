package com.kh.team.model.service;

import static com.kh.team.common.JDBCTemplate.*; // 별 사용
import static com.kh.team.common.JDBCTemplate.close;
import static com.kh.team.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.team.model.dao.MemberDAO;
import com.kh.team.model.vo.Member;

public class MemberService {

	public Member login(Member inputLogin) throws Exception {
		Connection conn = getConnection();

		Member loginMeber = new MemberDAO().login(inputLogin, conn);

		close(conn);

		return loginMeber;
	}

	/**
	 * 회원가입용
	 * 
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int insertJoin(Member mem) throws Exception {
		Connection conn = getConnection(); // JDBCTemplate에 작성해놓은 구문을 사용 커넥션

		MemberDAO dao = new MemberDAO(); // dao와 연결 고리 작성

		int result = dao.insertJoin(mem, conn); // 기성이형이 알려줬는데 까먹음 ㅎㅎ.. db랑 주고 오는 값은 int여서 int로 하는거였나? ㅎㅎㅎ..

		// 1_22. DB 처리 결과에 따라 드랜잭션 처리 진행
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		// db에 연결된 커넥션 닫아주고

		close(conn);
		// 처리결과를 컨트롤러로 이동
		return result;
	}

	public int memberRental(String id, int no) throws Exception { // 도서 검색용

		Connection conn = getConnection();

		int result = new MemberDAO().memberRental(id, no, conn);

		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}

		close(conn);

		return result;
	}
}
