package week2;

public class Map {
	
	String[][] map = {{"P","■","■","■","■"},
					  {"■","■","■","■","■"},
					  {"■","■","■","■","■"},
					  {"■","■","■","■","■"},
					  {"■","■","■","■","E"}};

	
	//현재 맵 상태를 그대로 출력하는 함수
	public void printmap() {
		for(int i=0; i<5; i++) {
			for(int k=0; k<5; k++) {
				System.out.print(map[i][k]);
			}
		System.out.println();
		}
	}
	

	
	//사용자의 위치 x,y는 플레이어가 움직인 위치 / dir은 어떻게 움직였는지(방향)
	public void reload_map(int bx, int by, int x, int y) {
		
		if((by == 0 && bx == 5) || (by == 1 && bx == 0) ||
				(by == 2 && bx == 2) || (by == 3 && bx == 2) ||
				(by == 3 && bx == 4) || (by == 4 && bx == 1))
			map[by][bx] = "*";
		else if((by == 0 && bx == 5) || (by == 1 && bx == 0))
			map[by][bx] = "♥";
		else if((by == 4 && bx == 0))
			map[by][bx] = "K";
		else 
			map[by][bx] = "□";
			
		map[y][x] ="P";
		
	}

		
//		switch(dir) {
//			case "east":
//				if((y == 0 && x == 5) || (y == 1 && x == 0) ||
//						(y == 2 && x == 2) || (y == 3 && x == 2) ||
//						(y == 3 && x == 4) || (y == 4 && x == 1))
//					map[y][x-1] = "*";
//				else if((y == 0 && x == 5) || (y == 1 && x == 0))
//					map[y][x-1] = "♥";
//				else if((y == 4 && x == 0))
//					map[y][x-1] = "K";
//				else 
//					map[y][x-1] = "□";
//				break;
				
//			case "west":
//				if((y == 0 && x == 5) || (y == 1 && x == 0) ||
//						(y == 2 && x == 2) || (y == 3 && x == 2) ||
//						(y == 3 && x == 4) || (y == 4 && x == 1))
//					map[y][x+1] = "*";
//				else if((y == 0 && x == 5) || (y == 1 && x == 0))
//					map[y][x+1] = "♥";
//				else if((y == 4 && x == 0))
//					map[y][x+1] = "K";
//				else 
//					map[y][x+1] = "□";
//				break;
//			//조건문은 현재위치가 어디이면 이전값을 바꿈 > 이건 어디였으면 이전값을 바꿔야함
//			case "south":
//				if((y == 0 && x == 5) || (y == 1 && x == 0) ||
//						(y == 2 && x == 2) || (y == 3 && x == 2) ||
//						(y == 3 && x == 4) || (y == 4 && x == 1))
//					map[y-1][x] = "*";
//				else if((y == 0 && x == 5) || (y == 1 && x == 0))
//					map[y-1][x] = "♥";
//				else if((y == 4 && x == 0))
//					map[y-1][x] = "K";
//				else 
//					map[y-1][x] = "□";
//				break;
//				
//			case "north":
//				if((y == 0 && x == 5) || (y == 1 && x == 0) ||
//						(y == 2 && x == 2) || (y == 3 && x == 2) ||
//						(y == 3 && x == 4) || (y == 4 && x == 1))
//					map[y+1][x] = "*";
//				else if((y == 0 && x == 5) || (y == 1 && x == 0))
//					map[y+1][x] = "♥";
//				else if((y == 4 && x == 0))
//					map[y+1][x] = "K";
//				else 
//					map[y+1][x] = "□";
//				break;
//			}
//		
//		map[y][x] ="P";
//	}


	
	
	
	
		
	
}


