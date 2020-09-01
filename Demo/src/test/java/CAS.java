import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

public class CAS {
    public static AtomicInteger atomicInteger = new AtomicInteger();
    public static void main(String[] args) {

        CAS cas = new CAS();
        List<Thread> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(new Thread(cas::count,"thread"+i));
        }
       list.forEach((o)->o.start());
  /*      for (Thread t:list) {
            t.start();
        }*/
        list.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

      //  LongAdder count2 = new LongAdder();
      //  count2.increment();
        System.out.println(cas.atomicInteger);
    }
      void count(){
        for (int i=0;i<1000;i++){
            System.out.println(CAS.atomicInteger);
            atomicInteger.incrementAndGet();
        }
    }

}
