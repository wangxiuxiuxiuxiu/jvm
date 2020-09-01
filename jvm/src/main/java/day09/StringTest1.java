package day09;

import org.junit.jupiter.api.Test;

//字符串操作
public class StringTest1 {


      /*  1、字符串字面量进行拼接，会在编译期进行优化，保存在字符串常量池中
      2、字符串常量池中的字符串不能重复，因为常量池的底层数据结构是一个hashtable
      3、字符串拼接如果出现变量，那么会将在堆中new 一个String（），具体内容为拼接的结果。
      4、被final 修饰的字符串引用，在和字面量进行拼接时，会在编译期进行优化，保存在字符串常量池中。
    */

    public static void main(String[] args) {

        //1、下面这行代码创建了几个对象？
      /*
         0 new #2 <java/lang/String>
         3 dup
         4 ldc #3 <AB>
         6 invokespecial #4 <java/lang/String.<init>>
         9 astore_1
        10 return

      两个：看字节码指令可以知道
            一个是通过new关键字在堆空间创建。
            另一个是字符串常量池中创建 --ldc */
        String s = new String("AB");
       //-----------------------------------------------------------------------------
        // -----------------------------------------------------------------------------





    }
    @Test
    public void test10(){
        //2、下面这行代码创建了几个对象？
        String s2 = new String("x")+new String("y" );

     /*
            字节码指令：

                0 new #5 <java/lang/StringBuilder>
                3 dup
                4 invokespecial #6 <java/lang/StringBuilder.<init>>
                7 new #2 <java/lang/String>
                10 dup
                11 ldc #7 <x>
                13 invokespecial #4 <java/lang/String.<init>>
                16 invokevirtual #8 <java/lang/StringBuilder.append>
                19 new #2 <java/lang/String>
                22 dup
                23 ldc #9 <y>
                25 invokespecial #4 <java/lang/String.<init>>
                28 invokevirtual #8 <java/lang/StringBuilder.append>
                31 invokevirtual #10 <java/lang/StringBuilder.toString>
                34 astore_1
                35 return

                对象1：创建StringBuilder对象
                对象2：通过关键字new 在堆空间创建对象 new String("X")
                对象3：在字符串常量池中创建对象“X”
                对象4：通过关键字new 在堆空间中创建对象 new String("Y")
                对象5：在字符串常量池中创建对象“Y”

                深入剖析：
                        通过字节码可以看到在最后StringBuilder 调用了 toString 方法之后返回。
                        深入StringBuilder 的toString 源码 ，我们可以看见，他实际上是new String()
                对象6：new String("XY")

                注意！这里在字符串常量池中没有创建对象“XY”

      public String toString() {
      return isLatin1() ? StringLatin1.newString(value, 0, count): StringUTF16.newString(value, 0, count);

    }
     public static String newString(byte[] val, int index, int len) {
        if (String.COMPACT_STRINGS) {
            byte[] buf = compress(val, index, len);
            if (buf != null) {
                return new String(buf, LATIN1);
            }
        }
        int last = index + len;
        return new String(Arrays.copyOfRange(val, index << 1, last << 1), UTF16);
    }

                */






    }



    @Test
    public void test1(){
        String s1="a";
        String s2 = "bc";
        String s3 = new String("abc").intern();
        //在堆中和字符串常量池中分别创建对象 “abc”，
        // 调用intern（），会去字符串常量池中加载“abc”，如果存在则返回常量池地址,如果不存在，则在常量池中创建一个“abc” 对象并返回地址。

        String s4 = s1+s2;

       /*
       String s4 = s1+s2; 细节
       1、创建一个 StringBuilder b = new StringBuilder();
       2、b.append("a")
       3、b.append("bc")
       4、b.toString() 约等于 new String(“abc”)
       */
        String s5 ="abc";
        System.out.println(s3==s4);//false
        System.out.println(s5==s3);//true


    }
    @Test
    public void test2(){
        String s1="abc";
        String s2 = "abc";

        s2 = s2+"vv";
        System.out.println(s1==s2);
        System.out.println(s1);
        System.out.println(s2);
    }
    @Test
    public void test3(){

       for (int i=0;i<10000000;i++){
           String ss = "hello";
           ss = ss+"-"+i;
           System.out.println(ss);
       }
    }
    @Test
    public void test4(){
        String  s = new String("123");
        /*
        严格来说首先肯定会在堆中创建一个123的对象，然后再去判断常量池中是否存在123的对象，
        如果不存在，则在常量池中创建一个123的常量(与堆中的123不是一个对象)，
        如果存在，则不做任何操作
        */
        System.out.println(s == s.intern());//false



    }
    @Test
    public void test5(){

        String  s1 = new String("123").intern();
        String  s2 = "1"+"23";
        /*
         *  首先第一句话 String  s1 = new String("123") 以上分析过创建了两个对象（一个堆中，一个常量池 中）此时s1指向堆中
         *  当s1调用.intern()方法之后，发现常量池中已经有了字面量是123的常量，则直接把常量池的地址返回给s1
         *  在执行s2等于123时候，去常量池查看，同上常量池已经存在了，则此时s2不创建对象，直接拿常量池123的地址值使用
         *  所以此时s1 和 s2 都代表是常量池的地址值，则输出为true
         */
        System.out.println(s1 == s2);//true


    }
    @Test
    public void test6(){

       /*  分析： 1 首先看第一行是两个new String类型的字符串相加（详见上文第4点）可知道，这里创建了堆中有3个对象 一个是1， 一个是23，还有一个是结果 123，由于程序刚启动常量池也没有 1，23 所以会在常量池创建2个对象 （1 ， 23）

        2 当s1执行intern()方法之后，首先去常量池判断有没有123，此时发现没有，所以会把对象加入到常量池，并且返回 当前对象的引用（堆中的地址）

        3 当创建s2时候（详见上文第1点），并且找到常量池中123，并且把常量池的地址值返回给s2

        4 由于常量池的地址值就是s1调用intern（）方法之后得到的堆中的引用，所以此时s1和s2的地址值一样，输出true。*/
        String s1 = new String("1")+new String("23");
        s1.intern();
        String s2 = "123";
        System.out.println( s1 == s2);

        /*

        intern():

        判断这个常量是否存在于常量池。

        如果存在，则直接返回地址值（只不过地址值分为两种情况，1是堆中的引用，2是本身常量池的地址）

        如果是引用，返回引用地址指向的堆空间对象地址值

        如果是常量，则直接返回常量池常量的地址值，

        如果不存在，

        将当前对象引用复制到常量池,并且返回的是当前对象的引用（这个和上面最开始的字符串创建分析有点不同）

        结论：如果程序中存在大量字符串，可以使用intern（） ，他可以提高效率，和节省空间。

        */
    }

    @Test
    public void test7(){
        final String s2="bc";//常量
        String s3="abc";
        String s4 = "a" + s2;
        System.out.println(s3==s4);



    }
    @Test
    public void test8(){
        String s = new String("A")+new String("B");

        String s1 = s.intern();//jdk 6 在字符串常量池中加载，如果存在就返回在常量池的地址，不存在则在常量池中创建一个对象“AB”，并返回地址。
                                //jdk 7 后  在字符串常量池中加载，如果存在就返回在常量池的地址，不存在那就在常量池中创建一个引用，指向堆中的对象"AB"，并返回该引用地址。

        System.out.println(s=="AB");//jdk6 true/jdk  7 后 true
        System.out.println(s1=="AB");//jdk 6 false/jdk  7 后 true




    }

}
