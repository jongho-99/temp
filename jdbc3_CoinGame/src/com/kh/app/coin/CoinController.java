package com.kh.app.coin;

import java.util.List;
import java.util.Scanner;

public class CoinController {
	
	Scanner sc = new Scanner(System.in);
	CoinService coinService = new CoinService();
	PlayerVo Pvo = new PlayerVo();
	CoinVo Cvo = new CoinVo();
	
	
	//코인구매 메서드
	public void buyCoin(String name) {
		try {
			//데이터 준비
			System.out.print("구매하실 코인 번호를 입력해주세요 : ");
			int menu_n = Integer.parseInt(sc.nextLine());
			
			System.out.print("몇 개 구매하시겠습니까? : ");
			int cnt = Integer.parseInt(sc.nextLine());
			
			//서비스 호출
			int result = coinService.buyCoin(name, menu_n, cnt);
			//결과 확인
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("구매되었습니다.");
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("구매 실패하였습니다.");
		}
		
	}
	
	//코인판매 메서드
	public void sellCoin(String name) {
		try {
			//데이터 준비
			System.out.print("판매하실 코인 번호를 입력해주세요 : ");
			int menu_n = Integer.parseInt(sc.nextLine());
			
			System.out.print("몇 개 판매하시겠습니까? : ");
			int cnt = Integer.parseInt(sc.nextLine());
			
			//서비스 호출
			int result = coinService.sellCoin(name, menu_n, cnt);
			//결과 확인
			if(result != 1) {
				throw new Exception();
			}
			System.out.println("판매되었습니다.");
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("판매 실패하였습니다.");
	}
		
		
		
		
		
	}
	
	//내 보유 코인목록 출력(SELECT)
	public void printmyCoin(String name) {
		try {		
			//서비스 호출
			List<PlayerCoin> coinVoList = coinService.printmyCoin(name);
			//결과 확인
			if(coinVoList.size() < 0) {
				throw new Exception();
			}
			
			for(PlayerCoin x : coinVoList) {
				System.out.println(x);
			}
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("출력 실패하였습니다."); 
		}
	}

	public void selectCoin() {
		//데이터 준비
		
		//서비스 호출
		
		//결과 확인
	}

	

	
	
}
