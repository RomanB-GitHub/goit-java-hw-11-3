package main.task_2;

import java.util.Arrays;

public class SecondTask {

    public static String addNumbersToTheString(int n) {

        int[] integers = new int[n];
        String[] strings = new String[n];

        for (int i = 0; i < n; i++) {
            integers[i] = i + 1;
        }

        Thread fizzThread = new Thread(() -> {
            fizz(integers, strings);
        });
        fizzThread.start();

        Thread buzzThread = new Thread(() -> {
            buzz(integers, strings);
        });
        buzzThread.start();

        Thread fizzBuzzThread = new Thread(() -> {
            fizzBuzz(integers, strings);
        });
        fizzBuzzThread.start();

        Thread numberThread = new Thread(() -> {
            number(integers, strings);
        });
        numberThread.start();

        while (!ifAllThreadsTerminated(fizzBuzzThread, fizzThread, buzzThread, numberThread)) {
            delayOneSecond();
        }

        return String.join(",", Arrays.asList(strings));
    }

    public static void delayOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean ifAllThreadsTerminated(Thread... threads) {
        boolean ifTerminated = true;
        for (Thread flow : threads) {
            ifTerminated = ifTerminated && flow.getState() == Thread.State.TERMINATED;
        }
        return ifTerminated;
    }

    private static void number(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (strings[i] == null) {
                strings[i] = String.valueOf(integers[i]);
            }
        }
    }

    private static void fizz(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 3 == 0 && integers[i] % 5 != 0)
                strings[i] = "fizz";
        }
    }

    private static void fizzBuzz(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 3 == 0 && integers[i] % 5 == 0)
                strings[i] = "fizzbuzz";
        }
    }

    private static void buzz(int[] integers, String[] strings) {
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 5 == 0 && integers[i] % 3 != 0)
                strings[i] = "buzz";
        }
    }


}
