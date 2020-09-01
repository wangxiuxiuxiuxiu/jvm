package day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class HeapTest {
    int array[] = new int[new Random().nextInt(1024*1024)];
    public static void main(String[] args) {


        while (true){
            HeapTest test = new HeapTest();
            System.out.println(test.array.length);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
