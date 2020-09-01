package day06;

public class HeapTest1 {
    public static void main(String[] args) {

        System.out.println("heapTest1 start");

        long start = Runtime.getRuntime().totalMemory()/1024/1024;
        long max = Runtime.getRuntime().maxMemory()/1024/1024;

        System.out.println("start:"+start+"M");
        System.out.println("max:"+max+"M");



        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("heapTest1 end");
    }
}
