package week2;

import java.util.Scanner;

public class Main {

	private static int before_x;

	public static void main(String[] args) {
		//사용자 입력을 위한 클래스 객체 선언
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("======== Escape ========");
		System.out.println("안녕하세요 탈출게임입니다.");
		
		//user1 객체 생성
		Player user1 = new Player();
		
		System.out.print("사용하실 닉네임을 입력해주세요 : ");
		user1.name = sc.next();
		
		System.out.println(user1.name +"님 반갑습니다 !!");
		
		System.out.print("난이도를 선택해주세요 (1.쉬움 / 2.어려움) : ");
		int level = sc.nextInt();
		
		switch(level) {
		case 1:
			user1.hp = 100;
			user1.level = "쉬움";
			System.out.println("쉬운 난이도를 선택하셨습니다.(hp: 100)");
			
			break;
		case 2:
			user1.hp = 70;
			user1.level = "어려움";
			System.out.println("어려움 난이도를 선택하셨습니다.(hp:70)");
			break;
		}
		
		//한개의 맵 객체 생성
		Map map = new Map();
		
		//시간지연함수 
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		System.out.println("=============== 탈출 게임을 시작하겠습니다 =============");
		user1.player_info();
		//게임 시작!!!
		while(true) {
			
			//시간지연함수 
			try {
			    Thread.sleep(500); // 0.5초 동안 지연
			} catch (InterruptedException e) {
			    e.printStackTrace();
			}
			
			map.printmap();
			
			System.out.print("움직이실 방향을 선택해주세요 (동(1) 서(2) 남(3) 북(4)) : ");
			int n = sc.nextInt();
			
			String dir = "";
			
			if((n > 0 && n < 5) != true) {
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				continue;
			}
			
				
			//플레이어 움직임
			
			//출력할 맵 초기화
				
			int before_x = user1.pos_x;
			int before_y = user1.pos_y;
	
			switch(n) {
			case 1:
				dir = "east";
				user1.move_x(dir);
				map.reload_map(before_x, before_y ,user1.pos_x, user1.pos_y);
				break;
			case 2:
				dir = "west";
				user1.move_x(dir);
				map.reload_map(before_x, before_y, user1.pos_x, user1.pos_y);
				break;
			case 3:
				dir = "south";
				user1.move_y(dir);
				map.reload_map(before_x,before_y,user1.pos_x, user1.pos_y);
				break;
			case 4:
				dir = "north";
				user1.move_y(dir);
				map.reload_map(before_x,before_y,user1.pos_x, user1.pos_y);
				break;
			}
			
			//함정설정 =================================================================
			//함정설정 =================================================================
			//함정설정 =================================================================	
			if(user1.pos_y == 0 && user1.pos_x == 5) {
				System.out.println("함정을 밟으셨습니다...(hp -30)");		
				user1.boom();
				user1.player_info();		
			}
			if(user1.pos_y == 1 && user1.pos_x == 0) {
				System.out.println("함정을 밟으셨습니다...(hp -30)");		
				user1.boom();
				user1.player_info();		
			}
			if(user1.pos_y == 2 && user1.pos_x == 2) {
				System.out.println("함정을 밟으셨습니다...(hp -30)");		
				user1.boom();
				user1.player_info();		
			}
			if(user1.pos_y == 3 && user1.pos_x == 4) {
				System.out.println("함정을 밟으셨습니다...(hp -30)");		
				user1.boom();
				user1.player_info();		
			}
			if(user1.pos_y == 3 && user1.pos_x == 2) {
				System.out.println("함정을 밟으셨습니다...(hp -30)");		
				user1.boom();
				user1.player_info();		
			}
			if(user1.pos_y == 4 && user1.pos_x == 1) {
				System.out.println("함정을 밟으셨습니다...(hp -30)");		
				user1.boom();
				user1.player_info();		
			}
			
			
			
			
			//하트 설정 ===============================================================
			//하트 설정 ===============================================================
			//하트 설정 ===============================================================		
			if(user1.pos_y == 1 && user1.pos_x == 3) {
				System.out.println("하트를 찾았습니다 (hp +50)");		
				user1.getheart();
				user1.player_info();		
			}
			
			if(user1.pos_y == 3 && user1.pos_x == 1) {
				System.out.println("하트를 찾았습니다 (hp +50)");		
				user1.getheart();
				user1.player_info();		
			}
			
			
			//키 설정 ====================================================================
			if(user1.pos_y == 4 && user1.pos_x == 0) {
				System.out.println("탈출 키를 획득하셨습니다 !!");
				System.out.println("탈출구를 통해 탈출하세요");			
				user1.getkey();
				user1.player_info();		
			}
			
			
			//hp를 모두 소모했을때 반복문을 멈추고 실패 문구 출력		
			if(user1.hp < 0) {
				System.out.println("hp가 모두 소모되어 실패하셨습니다...");
				break;
			}
			
			if(user1.pos_y == 4 && user1.pos_x == 4) {
				if(user1.key > 0) {
					map.printmap();
					System.out.println("탈출 키를 이용하여 탈출에 성공하셨습니다 !!");
					System.out.println("축하드립니다 !!!");
					break;
				}
				else {
					System.out.println("탈출 키가 없어 탈출하지 못합니다.");
					System.out.println("탈출 키를 찾아 오세요");
					
				}
					
			}
			
			
		}
	}

}
