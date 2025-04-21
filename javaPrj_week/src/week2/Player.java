package week2;

public class Player {
	
	String name;
	int hp;
	int item_n;
	int key = 0;
	int getkey = 0;
	String level = "";
	
	//위치좌표
	int pos_x = 0;
	int pos_y = 0;

	//플레이어가 x축으로 움직인 경우 x좌표 변화
	public int move_x(String dir) {
		
		if(dir.equals("east"))
			pos_x += 1;
		if(dir.equals("west"))
			pos_x -= 1;
		
		return pos_x;		
	}
	
	//플레이어가 y축으로 움직인 경우 y좌표 변화
	public int move_y(String dir) {
		
		if(dir.equals("south"))
			pos_y += 1;
		if(dir.equals("north"))
			pos_y -= 1;
		
		return pos_y;		
	}
	//플레이어가 함정을 밟았을 때, 피를 낮춤
	public void boom() {
		hp -= 30;
		//시간지연함수 
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	}
	
	//플레이어가 체력회복 물약을 먹었을때 피를 상승
	public void getheart() {
		//시간지연함수 
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		if(getkey > 0) {
			hp = hp;
		}
		else
			hp += 50;
			getkey += 1;
			if(hp > 100) {
				hp = 100;
			}			
	}
	
	//플레이어가 탈출 키를 먹었을 때, 키 값을 상승
	public void getkey() {
		//시간지연함수 
		try {
		    Thread.sleep(1000); // 1초 동안 지연
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		key += 1;
		if(key > 1) {
			key = 1;
		}
	}
	
		
	//플레이어 현재 체력과 탈출 키를 보유중인지 출력하는 메서드
	public void player_info() {
		System.out.println("["+name + "님의 체력: " + hp + " / " +"탈출 키 :" +key+" / "+"난이도: "+level+"]");
	}
	
	
	
}

