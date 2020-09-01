import java.lang.ref.WeakReference;

public class Refelence {

    public static void main(String[] args) {
        System.out.println("init");
        Thread t = new Thread(() -> {

            for (int i=0;i<5;i++){
                System.out.println("t");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(() -> {

            try {
                t.join();
            }catch (Exception E){

            }
            for (int i=0;i<5;i++){
                System.out.println("t2");

                try {

                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(() -> {

            try {
                t2.join();
            }catch (Exception E){

            }
            for (int i=0;i<5;i++){
                System.out.println("t3");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        t.start();
        t2.start();
        t3.start();
        System.out.println();
    }
}
