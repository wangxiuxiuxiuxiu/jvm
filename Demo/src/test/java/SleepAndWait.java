public class SleepAndWait {
    public  int conunt=0;
    Object lock = new Object();
    public static void main(String[] args) {
        SleepAndWait sleepAndWait = new SleepAndWait();

        for (int i=0;i<3;i++){

            new Thread(()->{
                sleepAndWait.add();
            }).start();
        }

       /* for (int i=0;i<3;i++){

            new Thread(()->{
                sleepAndWait.get();
            }).start();
        }*/

    }
    public  void add(){

        synchronized (lock){


            try {
                Thread.sleep(3000);
                conunt ++;
                System.out.println(conunt+"--add--"+Thread.currentThread().getName());
                lock.wait();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    public synchronized int get(){

        synchronized (lock){
            System.out.println(conunt+"--get--"+Thread.currentThread().getName());
            try {
                conunt--;
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        return conunt;

    }
}
