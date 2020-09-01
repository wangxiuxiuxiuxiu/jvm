public class SynchronizedTest {
    private volatile int count =0;
    public static void main(String[] args) {

        new SynchronizedTest().add();
    }
    public void add(){
      /*  synchronized (this){
            count = 100;//volatile写
        }*/
        count = 100;//volatile写
        int sum = count;//volatile读
    }
}
