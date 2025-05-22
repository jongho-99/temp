package com.kh.app.coin;

import java.util.Scanner;

public class PlayerController {
	Scanner sc = new Scanner(System.in);
	PlayerVo playerVo = new PlayerVo();
	PlayerService playerService = new PlayerService();
	public String addPlayer() {
		String name = null;
		try {		
			//데이터 준비
			System.out.print("플레이어 이름 : ");
			name = sc.nextLine();
			playerVo.setName(name);
			System.out.print("플레이어 자산 : ");
			int money = Integer.parseInt(sc.nextLine());
			playerVo.setMoney(money);
			
			
			//서비스 호출
			int result = playerService.addPlayer(playerVo);
			
			//결과 확인
			if(result != 1)
				throw new Exception();
			System.out.println(name + "님 반갑습니다.");
		} catch(Exception e) {
			System.out.println("플레이어 등록에 실패했습니다.");
		}
		
		
		return name;
		
	}
	public String login() {
		String name = null;
		try {		
			//데이터 준비
			System.out.print("ID : ");
			name = sc.nextLine();
			playerVo.setName(name);
			System.out.print("PWD : ");
			int money = Integer.parseInt(sc.nextLine());
			playerVo.setMoney(money);
			
			
			//서비스 호출
			int result = playerService.addPlayer(playerVo);
			
			//결과 확인
			if(result != 1)
				throw new Exception();
			System.out.println(name + "님 반갑습니다.");
		} catch(Exception e) {
			System.out.println("플레이어 등록에 실패했습니다.");
		}
		
		
		
		return null;
	}
}
