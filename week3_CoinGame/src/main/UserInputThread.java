package main;

public class UserInputThread extends Thread {
    private CoinManager manager;

    public UserInputThread(CoinManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int n = manager.printMenu();

            if (n == 0) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (n >= 1 && n <= 5) {
                manager.workMenu(n);
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
            }
        }
    }
}