package com.kh.team.controller;

import com.kh.team.model.service.BookService;
import com.kh.team.model.service.MemberService;
import com.kh.team.model.vo.Member;
import com.kh.team.view.SubView;

public class BookController {
	
	public static Member loinMember = null;
	private BookService service = new BookService();
	private MemberService mService = new MemberService();
	private SubView sView = new SubView();
	
	public void login() {
		Member inputLogin = sView.inputLogin();

		try {
			BookController.loinMember = mService.login(inputLogin);

			if (BookController.loinMember != null) {
				sView.displaySuccess("로그인 성공");
			} else {
				sView.displayFail("아이디 또는 비밀번호 학인");
			}

		} catch (Exception e) {
			e.printStackTrace();
			sView.displayError("로그인 중 에러 발생");
		}
	}

	public void join() {
		Member mem = sView.inputJoin(); // 서브뷰에서 가입자 정보를 가져옴
		
		try {
			int result = mService.insertJoin(mem); // 멤버서비스에 있는insertJoin(mem) 입력받은 값을 변환시켜 가져옴!
			if (result > 0) { // 받아 온값이 0이상
				sView.displaySuccess("계정 생성 완료"); // 오류 값이 없을경우 출력
			}else {
				sView.displayFail("계정 생성 과정중 오류 발생"); // 받아 온값이 0이면 오류 발생 출력
			}
		}catch (Exception e) {
			e.printStackTrace();
			sView.displayError("회원가입 도중 알 수 없는 오류 발생"); // 그 외 오류발생 시 출력
		}
		
	}
	
	public void bookRental() {
		int no = sView.inputBookNo();
		int coChk = 0;
		int bookResult = 0;
		int memberResult = 0;
		try {
			// 빌릴수 있는 권수는 한 권이기 때문에
			// 전에 빌리고 아직 반납안했는지 확인
			if(BookController.loinMember.getYn() == 'N' || BookController.loinMember.getRentalCo() == 0) {
				// 빌릴 책 있는지 확인
				coChk = service.bookCountChk(no);
				if (coChk > 0) {
					// 업데이트 처리 (Member의 카운트 증가와 렌탈 y로 변경)
					// 책 yn처리를 빌렸으면 n으로
						
					memberResult = mService.memberRental(BookController.loinMember.getMemberId(),no);
					bookResult = service.bookRental(no);
					
					if(memberResult > 0) {
						if(bookResult > 0) {
							// 처리가 완료 되었다면 현재 로그인 객체 갱신부분
							BookController.loinMember = mService.login(BookController.loinMember);
							sView.displaySuccess("성공적으로 책을 대여 함");
						} else {
							sView.displayFail("책대여 실패.");
						}
					} else {
						sView.displayFail("책을 대여하는데 실패하였습니다. 멤버쪽 업데이트 실팩");
					}
					
					
				} else {
					sView.displayFail("요청하신 책이 존재하지 않습니다.");
				}
			} else {
				sView.displayFail("아직 반납 안한 책이있습니다 먼저 반납 후 진행해주세요");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
