package day08;

public class StaticVarialTest {

    public static void main(String[] args) {
        byte [] cc = new byte[200*1024*1024];
        int m = get();
        System.out.println(m);

    }
    public static int get(){
        int count=1;
        count++;
        int m=10;
        return ++m;
    }
    public static void add(){
        //第一类问题
        int i1 = 10;
        i1++;
        System.out.println(i1);

        int i2 = 10;
        ++i2;
        System.out.println(i2);

        //第二类问题
        int i3 = 10;
        int i4 = i3++;
        System.out.println(i4);

        int i5 = 10;
        int i6 = ++i5;
        System.out.println(i6);

        //第三类问题
        int i7 = 10;
        i7 = i7++;
        System.out.println(i7);

        int i8 = 10;
        i8 = ++i8;
        System.out.println(i8);

        //第四类问题：重点，易错
       /* bipush 10
        100 istore 8
        102 iinc 8 by 1
        105 iload 8
        107 iload 8
        109 iinc 8 by 1
        112 iadd
        113 istore 9
        115 getstatic #4 <java/lang/System.out>
        118 iload 9
        120 invokevirtual #5 <java/io/PrintStream.println>
*/
        int i9 = 10;
        int i10 = i9++ + i9++;
        System.out.println(i10);

    }
}
