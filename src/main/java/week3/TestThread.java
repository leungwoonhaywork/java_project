package week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RunnableDemo implements Runnable {
    private Thread t;
    private int[] array;

    RunnableDemo(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }

    public void join() {
    }
}

public class TestThread {

    public static void main(String args[]) {
        int[] array = new int [1000];
        for (int i = 0; i < array.length; i ++){
            array[i] = i;
        }

        List<RunnableDemo> list = new ArrayList<>();

        long start = System.nanoTime();

        RunnableDemo R1 = new RunnableDemo(Arrays.copyOfRange(array, 0, array.length / 2));
        R1.start();

        list.add(R1);

        RunnableDemo R2 = new RunnableDemo(Arrays.copyOfRange(array, array.length / 2 + 1, array.length));
        R2.start();

        list.add(R2);

        for (RunnableDemo runnableDemo : list) {
            runnableDemo.join();
        }

        long end = System.nanoTime();

        System.out.println("Time taken: " + (end - start) + " nanoseconds");

    }
}
