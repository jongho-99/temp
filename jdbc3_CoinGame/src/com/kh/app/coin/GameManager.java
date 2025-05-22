package com.kh.app.coin;

import java.util.Scanner;

public class GameManager {
	CoinController coinController = new CoinController();
	PlayerController playerController = new PlayerController();
	Scanner sc = new Scanner(System.in);
	
	
	public String addPlayer() {
		String name = playerController.addPlayer();
		return name;
	}
	
	
	//사용자 추가 메서드 (INSERT 연습하려고 넣음 ㅋㅋ)
//	public String login() {
//		System.out.println("안녕하세요 코인게임 입니다.");
//		System.out.println("1. 회원가입");
//		System.out.println("2. 로그인");
//		
//		System.out.print("메뉴를 선택해주세요: ");
//		int num = Integer.parseInt(sc.nextLine());
//		
//		String name;
//		switch (num) {
//		case 1:
//			name = playerController.addPlayer();
//			break;
//		case 2:
//			name = playerController.login();
//		default:
//		}
//		
//
//		
//		return name;
//		
//	}
	
	//가격출력 메서드
	public void coinlist() {
		
	}
	
	
	//메뉴출력 메서드
	public boolean menu(String name) {
		
		
		System.out.println("----- menu -----");
		System.out.println("1. 코인 구매하기");
		System.out.println("2. 코인 판매하기");
		System.out.println("3. 내 코인 확인하기");
		System.out.println("4. 특정 코인 최근가격 확인");
		System.out.println("5. 종료");
		
		System.out.print("메뉴를 선택해주세요: ");
		int num = Integer.parseInt(sc.nextLine());
		
		switch(num) {
		case 1:
			coinController.buyCoin(name);
			break;
		case 2:
			coinController.sellCoin(name);
			break;
		case 3:
			coinController.printmyCoin(name);
			break;
		case 4:
			coinController.selectCoin();
			break;
		case 5:
			System.out.println("종료합니다.");
			return false;
		}
		
		
		return true;
	}

}
