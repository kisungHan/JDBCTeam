package com.kh.team.view;

import java.util.Scanner;

import com.kh.team.model.vo.Member;

public class SubView {
	private Member mb = new Member();
	private Scanner sc = new Scanner(System.in);

	public Member inputJoin() { // 회원가입 정보를 입력받음

		System.out.println("=============================================================");
		System.out.println(
				"                                                       회원 가입                                           ");
		System.out.println("=============================================================");
		System.out.print("아이디 : ");
		String memberId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.nextLine();
		System.out.print("이름 : ");
		String memberName = sc.nextLine();
		System.out.print("성별 (M/F): ");
		char gender = sc.nextLine().toUpperCase().charAt(0); // toUpperCase() = 입력받은 값을 대문자로 변환
		System.out.print("전화번호 (-포함): ");
		String memTel = sc.nextLine();
		System.out.print("주소 : ");
		String memAddr = sc.nextLine();
		return new Member(memberId, memberPwd, memberName, gender, memTel, memAddr); // 매개변수있는 생성자를 만들어줘서 받아올것 !
	}

	// 에러 출력 용

	public void displaySuccess(String msg) {
		System.out.println("서비스 요청 성공" + msg);
	}

	public void displayFail(String msg) {
		System.out.println("서비스 요청 실패." + msg);
	}

	public void displayError(String msg) {
		System.out.println("Error " + msg);
	}
	
	public char chkYN(String msg) {
		System.out.println("정말 " + msg + "진행 하시겠습니까? (Y/N)");
		return sc.nextLine().toUpperCase().charAt(0);
	}
	
	public Member inputLogin() {
		System.out.println("======== 로그인 =======");
		System.out.print("ID : ");
		String memberId = sc.nextLine();
		System.out.print("PWD : ");
		String memberPwd = sc.nextLine();

		return new Member(memberId, memberPwd);
	}

	public int inputBookNo() { // 3번 도서대여
		System.out.print("대여하고 싶은 도서 번호 입력 : ");
		int no = sc.nextInt();
		sc.nextLine();
		return no;
	}
	

}
