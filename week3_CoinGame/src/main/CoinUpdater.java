package main;

public class CoinUpdater extends Thread {
    private CoinManager manager;

    public CoinUpdater(CoinManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // 15초 대기
                Thread.sleep(15000);

                // 카운트다운
                for (int i = 5; i >= 1; i--) {
                    System.out.println("[주의] " + i + "초 후 코인가격이 변동됩니다!");
                    Thread.sleep(1000);
                }

                manager.skipAndFluct(); // 가격 변동 및 출력

            } catch (InterruptedException e) {
                System.out.println("[코인 갱신 쓰레드 종료]");
                break;
            }
        }
    }
}