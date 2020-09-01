package day10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

public class GCReference {

    public static void main(String[] args) throws InterruptedException {

        GCReference gcReference = new GCReference();
        ArrayList list = new ArrayList();

        System.out.println("数据加载结束");
        new Scanner(System.in).next();
        gcReference=null;
        list = null;

        System.gc();

        Thread.sleep(100);
        new Scanner(System.in).next();

        System.out.println("GC 结束");

    }
    //内存溢出 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    @Test
    public  void test1(){
        int [] arry = new int[1024*1024*10];
        while (true){
            int [] arrys = new int[1024*1024*1000];
        }
    }

}
