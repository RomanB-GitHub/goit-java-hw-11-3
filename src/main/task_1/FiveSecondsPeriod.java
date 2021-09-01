package main.task_1;

public class FiveSecondsPeriod implements Runnable {

    @Override
    public void run() {

        Thread myTread = Thread.currentThread();

        while (!myTread.isInterrupted()) {
            synchronized (this) {
                if (!fiveSecondPause()) break;
                System.out.println("\nFive seconds pause is gone!\n");
            }
        }

    }

    private boolean fiveSecondPause() {
        for (int i = 0; i < 5; i++) {
            try {
                wait(1000);
            } catch (InterruptedException e) {
                return false;
            }
            notify();
        }
        return true;

    }
}
