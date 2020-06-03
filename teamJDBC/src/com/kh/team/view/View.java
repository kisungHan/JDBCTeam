package com.kh.team.view;

import java.util.Scanner;

import com.kh.team.controller.BookController;
import com.kh.team.model.vo.Member;

public class View {

	/**
	 * 구현 절차서 1. 로그인 기능과 회원가입 기능을 만든다 2. 도서 목록을 볼 수 있어야한다. - 분류 별로 볼 수 있어야하고, -
	 * 검색기능도 있어야 한다. 3. 원하는 도서를 빌릴 수 있다. - 검색을 통해 갯수가 남아있다면 - 빌릴 수 있어야함 4. 빌린 도서를
	 * 반납할 수있다. - 빌렸던 도서를 반납 할 수있어야한다 - 단, 빌릴 수 있는 권수는 단 1개 이다 5. 로그아웃 할 수 있어야한다. 6.
	 * 밀린 연체료를 낼 수 있어야 한다. - 자신 계정에서 연체료를 조회하여 - 있다면 계산할 수 있도록 구현 한다. 7. 회원 탈퇴가
	 * 가능해야한다. - 회원 탈퇴 요구시 계정 삭제
	 * 
	 */
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		BookController controller = new BookController();

		int sel = 0;
		do {
			if (BookController.loinMember == null) {
				System.out.println("===== 로그인 화면 =====");
				System.out.println("1. 로그인하기 ");
				System.out.println("2. 회원가입");
				System.out.println("0. 종료하기");
				System.out.print("메뉴 선택 : ");

				sel = sc.nextInt();
				sc.nextLine();

				switch (sel) {
				case 1:
					controller.login();
					break;
				case 2:
					controller.join();
					break;
				case 0:
					System.out.println("종료합니다");
					return;
				default:
					System.out.println("잘못입력하셨습니다.");
					break;
				}

			} else {
				System.out.println("===== 메인 화면 =====");
				System.out.println("1. 도서 목록");
				System.out.println("2. 도서 검색");
				System.out.println("3. 도서 대여");
				System.out.println("4. 도서 반납");
				System.out.println("5. 내정보");
				System.out.println("6. 로그아웃");
				System.out.println("0. 프로그램 종료");
				System.out.print("메뉴 선택 : ");
				sel = sc.nextInt();
				sc.nextLine();

				try {
					switch (sel) {
					case 1:
						break;
					case 2:
						break;
					case 3:
						controller.bookRental();
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						BookController.loinMember = null;
						break;
					case 0:
						System.out.println("프로그램이 종료됩니다.");
						return;
					default:
						System.out.println("잘못 입력 하셨습니다. 다시 입력 해주세요.");
						break;
					}

				} catch (Exception e) {
					System.out.println("정수만 입력해주세요");
					sel = -1;
					sc.nextLine();
				}
			}

		} while (sel != 0);
	}

}