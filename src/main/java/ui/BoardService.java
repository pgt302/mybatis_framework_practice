package ui;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import dao.BoardDAO;
import dao.MemberDAO;
import vo.*;

public class BoardService {
	private Scanner sc;
	
	private MemberVO member;
	private BoardVO board;
	private MemberDAO mDao;
	private BoardDAO bDao;
	
	
	public BoardService() {
		mDao = new MemberDAO();
		bDao = new BoardDAO();
		sc = new Scanner(System.in);
		while(true) {
			showUI();
		}
	}
	public void showUI() {
		System.out.println("***게시판에 오신 것을 환영합니다***");
		System.out.println("1. 회원가입 하기.");
		System.out.println("2. 회원정보 수정하기.");
		System.out.println("3. 회원 탈퇴하기");
		System.out.println("4. 게시글 작성하기");
		System.out.println("5. 게시글 보기");
		System.out.println("6. 내가 작성한 글목록 보기");
		System.out.println("0. 종료하기");
		System.out.print("번호를 입력하십시오 >> : ");
		int num = sc.nextInt();
		switch(num) {
			case 1:
				insertMember();
				break;
			case 2:
				goUpdateinfo();
				break;
			case 3:
				goDeleteMember();
				break;
			case 4:
				insertBoard();
				break;
			case 5: 
				showAllBoard();
				break;
			case 6:
				showMyBoard();
				break; 
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("잘못된 입력입니다.");
		}
	}
	public void insertMember() {
		System.out.println("**** 회원가입 페이지입니다 ****");
		
		System.out.println("아이디를 입력하십시오");
		System.out.print("ID: ");
		String memberId = sc.next();
		sc.nextLine();
		
		System.out.println("비밀번호를 입력하십시오");
		System.out.print("PW: ");
		String pw = sc.next();
		sc.nextLine();
		System.out.println("email을 입력하십시오");
		System.out.print("email: ");
		String email = sc.next();
		sc.nextLine();
		
		System.out.println("전화번호를 입력하십시오");
		System.out.print("phone: ");
		String phone = sc.nextLine();
		member = new MemberVO(memberId, pw, email, phone);
		int result = mDao.insertMember(member);
		if(result != 0) {
			System.out.println("회원가입에 성공하였습니다.");
			System.out.println(member.toString());
		} else {
			System.out.println("등록에 실패하였습니다.");
		}
	}
	
	public void goUpdateinfo() {
		System.out.println("**** 회원정보 수정 페이지입니다 ****");
		System.out.println("수정할 정보를 선택하십시오.");
		System.out.println("1. 비밀번호 수정");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 이메일 수정");
		System.out.print("입력 : ");
		int num = sc.nextInt();
		sc.nextLine();
		switch(num) {
		case 1:
			updatePassword();
			break;
		case 2:
			updatePhone();
			break;
		case 3:
			updateEmail();
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
	}
	public void updatePassword() {
		System.out.println("**** 비밀번호 수정 페이지입니다 ****");
		System.out.println("수정할 비밀번호를 입력하십시오.");
		System.out.print("비밀번호 : ");
		String password = sc.nextLine();
		member.setPassword(password);
		int result = mDao.updatePassword(member);
		if(result != 0) {
			System.out.println("비밀번호 수정에 성공하였습니다.");
			System.out.println(member.toString());
		} else {
			System.out.println("비밀번호 수정에 실패하였습니다.");
		}
	}
	public void updatePhone() {
		System.out.println("**** 전회번호 수정 페이지입니다 ****");
		System.out.println("수정할 전화번호를 입력하십시오.");
		System.out.print("전화번호 : ");
		String phone = sc.nextLine();
		member.setPhone(phone);
		int result = mDao.updatePhone(member);
		if(result != 0) {
			System.out.println("이메일 수정에 성공하였습니다.");
			System.out.println(member.toString());
		} else {
			System.out.println("이메일 수정에 실패하였습니다.");
		}
	}
	public void updateEmail() {
		System.out.println("**** 이메일 수정 페이지입니다 ****");
		System.out.println("수정할 이메일을 입력하십시오.");
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		member.setEmail(email);
		int result = mDao.updateEmail(member);
		if(result != 0) {
			System.out.println("이메일 수정에 성공하였습니다.");
			System.out.println(member.toString());
		} else {
			System.out.println("이메일 수정에 실패하였습니다.");
		}
	}
	public void goDeleteMember() {
		System.out.println("**** 회원 탈퇴 페이지입니다 ****");
		System.out.println("정말로 탈퇴하시겠습니까?");
		System.out.println("탈퇴를 원하시면 1번을 누르십시오.");
		System.out.print("입력 : ");
		int num = sc.nextInt();
		if(num == 1) {
			deleteMember();
		} else {
			 System.out.println("잘못된 입력입니다.");
		}
	}
	public void deleteMember() {
		boolean result = mDao.deleteMember(member.getMemberId()) != 0 ? true : false;
		if(result) {
			System.out.println("탈퇴에 성공했습니다.");
		} else {
			System.out.println("탈퇴에 실패했습니다.");
		}
	}
	public void insertBoard() {
		System.out.println("**** 게시글 작성 페이지입니다 ****");
		board = new BoardVO();
		board.setMemberId(member.getMemberId());
		System.out.print("제목: ");
		String title = sc.next();
		sc.nextLine();
		board.setTitle(title);
		System.out.print("내용 : ");
		String content = sc.nextLine();
		board.setContent(content);
		
		int result = bDao.insertBoard(board);
		if(result != 0) {
			System.out.println("글 등록에 성공했습니다.");
		} else {
			System.out.println("글 등록에 실패했습니다.");
		}
	}
	public void showAllBoard() {
		List<HashMap<String, Object>> bList = bDao.selectAllBoard();
		for(int i = 0; i < bList.size(); i++) {
			HashMap<String, Object> tempMap = bList.get(i);
			System.out.println("-----------------------------------");
			System.out.println("제목: " + tempMap.get("title"));	
			System.out.println("글번호: " + tempMap.get("boardNum") + "  작성자: " + tempMap.get("memberId") + " 작성일시: " + tempMap.get("boardDate"));
			System.out.println("내용");
			System.out.println(tempMap.get("content"));
			System.out.println("연락이 필요하시면 => " + tempMap.get("phone") + " 으로 연락주세요.");
			
		}
		
	}
	public void showMyBoard() {
		List<BoardVO> bList = bDao.selectMyBoard(member.getMemberId());
		System.out.println("글번호          제목         작성일");
		for(int i = 0; i < bList.size(); i++) {
			BoardVO board = bList.get(i);
			System.out.println("-----------------------------------");
			System.out.println(board.toString());
		}
	}
}
