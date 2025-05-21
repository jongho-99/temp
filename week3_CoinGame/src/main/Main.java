package main;

public class Main {

	public static void main(String[] args) {
		System.out.println("==================== 코인게임 ====================");
		
		
		CoinManager coinmanager = new CoinManager();
		
		//게임 시작 전 코인 가격 세팅
		coinmanager.coinSet();
		coinmanager.playerSet();
		
		//처음 코인가격 출력
		coinmanager.print1Coin();
		
        // 쓰레드 실행
        Thread coinUpdater = new CoinUpdater(coinmanager);
        Thread userInput = new UserInputThread(coinmanager);
		
        coinUpdater.start();
        userInput.start();
        
        try {
            userInput.join(); // 사용자가 종료 입력할 때까지 기다림
            coinUpdater.interrupt(); // 종료되면 코인 업데이트 쓰레드도 중단
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("코인게임을 종료합니다. 감사합니다!");
    }
}
