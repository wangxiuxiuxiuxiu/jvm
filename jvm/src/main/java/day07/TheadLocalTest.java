package day07;

public class TheadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<String> theadLocal = new ThreadLocal<String>();
        theadLocal.set("main thread");
      //  System.out.println(theadLocal.get());
        theadLocal.set("main thread1");
        System.out.println(theadLocal.get());

        new Thread(()->{
            theadLocal.set("thread1");
            System.out.println(theadLocal.get());

        }).start();

        theadLocal.remove();
        System.out.println(theadLocal.get());
    }
}
