package main;

import main.task_1.FiveSecondsPeriod;
import main.task_1.OneSecondPeriod;
import main.task_2.SecondTask;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("First task");
        Thread fiveSecondThread = new Thread(new FiveSecondsPeriod());
        Thread oneSecondThread = new Thread(new OneSecondPeriod());

        oneSecondThread.start();
        fiveSecondThread.start();

        try{
            Thread.sleep(21000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        fiveSecondThread.interrupt();
        oneSecondThread.interrupt();

        devider();

        System.out.println("Second task");
        System.out.println(SecondTask.addNumbersToTheString(15));

    }
    private static void devider(){

        System.out.println("\n\n|||||||||||||||||||||||||||||||||||||||||||||||||||\n\n");

    }
}
