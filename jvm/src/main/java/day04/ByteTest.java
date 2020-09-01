package day04;

public class ByteTest {
    //字节码指令解析
    public static void main(String[] args) {
        int count = 0;
        count++;
        System.out.println(count);
        new ByteTest().test();
    }

    public  ByteTest(){

        System.out.println("tst");
    }


    public void test(){

        int m = tets2();
        int c=20;
    }
    public  int tets2(){
        int i = 10;
        int j = 20;
        int k = i + j;
        return k;
    }
}
