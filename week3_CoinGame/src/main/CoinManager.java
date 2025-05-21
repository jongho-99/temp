package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.text.DecimalFormat;

public class CoinManager {
	
	Player p = new Player();
	Coin[] c = new Coin[5];
	CoinData[] cd = new CoinData[5];
	int[] before_cv = {130000000, 2600000, 3150, 870000,215000};

	int time = 6;
	
	int[] tmpArr = new int[5];
	
	
	Scanner sc = new Scanner(System.in);
	DecimalFormat df2 = new DecimalFormat("+#0.00%;-#0.00%");
	DecimalFormat df = new DecimalFormat("#,###");

	//사용자로부터 입력받고 기능 작동
	public void workMenu(int n) {

		switch(n) {
		case 1:		
			buyCoin();
			break;
		case 2:
			sellCoin();	
			break;
		case 3:
			print5hour();
			break;
		case 4:
			printWallet();	
			break;	
		case 5:
			skipAndFluct();
			break;
		}
	}
	

	private void print5hour() {
	    System.out.println("========= 최근 5시간 코인가격 확인하기 ========");
	    
	    System.out.print("확인하실 코인을 선택해주세요 (번호): ");
	    int select = sc.nextInt();
	    
	    if (select < 1 || select > c.length) {
	        System.out.println("잘못된 입력입니다.");
	        return;
	    }

	    Coin selectedCoin = c[select - 1];
	    LinkedList<String> prices = (LinkedList<String>) selectedCoin.getPriceQueue();
	    
	    System.out.println("[" + selectedCoin.getName() + " 최근 5시간 가격 기록]");
	    
	    int size = prices.size();
	    for (int i = 0; i < size; i++) {
	        int hoursAgo = size - i - 1;  // 최근일수록 0시간 전
	        System.out.println("(" + hoursAgo + "시간 전)");
	        System.out.println(prices.get(i));
	        System.out.println();
	    }
	}
	
	//메뉴출력
	public int printMenu() {
		System.out.println("=========== MENU ===========");
		System.out.println("1. 코인 구매하기");
		System.out.println("2. 코인 판매하기");
		System.out.println("3. 최근 5시간 코인시가 변동 확인하기");
		System.out.println("4. 내 자산/코인 확인하기");
		System.out.println("5. 1시간 존버하기");
		System.out.println("0. 종료");
		System.out.println("==========================");
		System.out.println("["+p.getName()+" 님의 소지 현금 자산 : "+df.format(p.getMoney())+" KRW]");
		
		System.out.print("원하시는 메뉴를 선택해주세요:  ");
		int n = sc.nextInt();
		
		return n;
	}
	
	public void print1Coin() {
		System.out.println("========== Coin List (현재시각: "+(time%24)+ ":00)==========");
		for (int i = 0; i < c.length; i++) {
	        LinkedList<String> q = (LinkedList<String>) c[i].getPriceQueue();
	        String latest = q.peekLast(); // 가장 최근 항목
	        System.out.println((i + 1) + ". " + c[i].getName());
	        double gap = ((double)(c[i].getPrice() - before_cv[i])) / before_cv[i];
	    
	        System.out.println("[현재가격 : " + df.format(c[i].getPrice())+" KRW]" 
	        			+ "\n[1시간전 대비 가격변동: "+ df2.format(gap)+" KRW]");
	        

	        System.out.println();
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	
	//현재시간 코인가격 리스트출력
	
	public void printCoin() {
		System.out.println("========== Coin List (현재시각: "+(time%24)+ ":00)==========");
		for (int i = 0; i < c.length; i++) {
	        LinkedList<String> q = (LinkedList<String>) c[i].getPriceQueue();
	        String latest = q.peekLast(); // 가장 최근 항목
	        System.out.println((i + 1) + ". " + c[i].getName());
	        if (latest != null) {
	            System.out.println(latest);
	        } else {
	            System.out.println("데이터 없음");
	        }

	        System.out.println();
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	public void buyCoin() {
		System.out.print("구매를 원하시는 코인번호를 입력해주세요: ");
		int buy = sc.nextInt();
		
		System.out.print(c[buy-1].getName() + "를(을) 몇 개 구매하시겠습니까?");
		int buy_n = sc.nextInt();
		
		tmpArr = p.getCoinArr();
		
		if((c[buy-1].getPrice()*buy_n) > p.getMoney()) {
			System.out.println("금액이 부족합니다.");
		}
		
		else {
			System.out.println(c[buy-1].getName()+"를(을) "+buy_n+"개 구매하셨습니다.");
			 
			//구매하고 플레이어 돈 차감
			p.setMoney(p.getMoney()-(c[buy-1].getPrice()*buy_n));
			
			//구매하고 플레이어 코인개수 변동
			tmpArr[buy-1] += buy_n;
			 p.setCoinArr(tmpArr);
		 
		}
	}
	
	public void sellCoin() {
		System.out.print("판매를 원하시는 코인 번호를 입력해주세요: ");
		int sell = sc.nextInt();
		
		System.out.print(c[sell-1].getName()+"를(을) 몇 개 판매하시겠습니까?");
		int sell_n = sc.nextInt();
		
		
		
		if(tmpArr[sell-1] < sell_n) {
			System.out.println("보유 코인이 부족합니다.");
		}
		
		else {
			System.out.println(c[sell-1].getName()+"를(을) "+sell_n+"개 판매하셨습니다.");				
			
			//판매 후 플레이어 자금 변동
			p.setMoney(p.getMoney() + c[sell-1].getPrice() * sell_n);
			
			
			//판매 후 플레이어 코인 개수 변동
			tmpArr[sell-1] -= sell_n;
			p.setCoinArr(tmpArr);
		}
	}

	public void printWallet() {
		System.out.println("===== 내 자산 확인하기 =====");
		for(int i=0; i < c.length; i++) {
			System.out.println(c[i].getName()+" : " + tmpArr[i]+"개");
		}
		System.out.println(p.getName() +"님의 총 코인 자산는 " + df.format(sumCoinValue())+"KRW 입니다." );
		System.out.println(p.getName() +"님의 총 자산는 " + df.format(sumCoinValue()+p.getMoney())+"KRW 입니다." );
		System.out.print("메뉴로 가시려면 엔터를 눌러주세요 ! ");
		sc.nextLine();
		sc.nextLine();
		
	}

	public void skipAndFluct() {
		System.out.println("1시간이 지났습니다...");	
		for(int i =0; i<c.length; i++) {
			before_cv[i] = c[i].getPrice();
		}
		fluctuate();
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		System.out.println("...");
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		
		}
		System.out.println("변동된 코인 가격을 확인해주세요.");			
		time++;
		
		//변동된 가격 보여주기
		printCoin();
		System.out.println("=========== MENU ===========");
		System.out.println("1. 코인 구매하기");
		System.out.println("2. 코인 판매하기");
		System.out.println("3. 최근 5시간 코인시가 변동 확인하기");
		System.out.println("4. 내 자산/코인 확인하기");
		System.out.println("5. 1시간 존버하기");
		System.out.println("0. 종료");
		System.out.println("==========================");
		System.out.println("["+p.getName()+" 님의 소지 현금 자산 : "+df.format(p.getMoney())+" KRW]");
		
		System.out.print("원하시는 메뉴를 선택해주세요:  ");
	}
	
	//총 코인가치 계산
	private int sumCoinValue() {
		int sum = 0;
		for(int i =0; i < c.length; i++) {
			sum += tmpArr[i] * c[i].getPrice();
		}
		return sum;
	}

	//게임 시작 전 초기 세팅
	public void coinSet() {
		
		for(int i =0; i <c.length; i++) {
			c[i] = new Coin();
		}
		c[0].setName("비트코인");
		c[1].setName("이더리움");
		c[2].setName("리플");
		c[3].setName("바이낸스");
		c[4].setName("솔라나");
		
		c[0].setPrice(130000000);
		c[1].setPrice(2600000);
		c[2].setPrice(3150);
		c[3].setPrice(870000);
		c[4].setPrice(215000);
		
		for (int i = 0; i < c.length; i++) {
		    c[i].addPriceQueue("[현재가격 : " + df.format(c[i].getPrice())+" KRW]" 
		        + "\n[1시간전 대비 가격변동: 0.00%]");
		}
	}
	
	
	//게임 시작 전 플레이어 초기세팅 밑 시작멘트
	public void playerSet() {
		System.out.println("안녕하세요 코인게임입니다.");
		
		//player 객체필드 초기화
		System.out.print("사용하실 닉네임을 적어주세요: ");
		p.setName(sc.next());
		System.out.println("보유하신 자금은 1000만원 입니다.");
		p.setMoney(10000000);
		//코인 보유량 초기화
		p.setCoinArr(new int[5]);
		
		System.out.println("게임 시작하겠습니다.");
		
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		System.out.println("...");
		try {
		    Thread.sleep(500); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		
		}
		
		System.out.println("...");
		try {
		    Thread.sleep(500); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
	}
	
	
	
	// 가격 변동 메서드
	public void fluctuate() {
		//Math
        double rand;  // -10% ~ 10%
        for(int i =0; i<c.length; i++) {
        	rand = (Math.random() - 0.5) * 0.6;
        	c[i].setPrice(c[i].getPrice() + (int)(c[i].getPrice() * rand));
        	
        	double gap = ((double)(c[i].getPrice() - before_cv[i])) / before_cv[i];
        	
        	c[i].addPriceQueue("[현재가격 : " + df.format(c[i].getPrice())+" KRW]" 
        			+ "\n[1시간전 대비 가격변동: "+ df2.format(gap)+" KRW]");

        }  
	}	
	
	
}

