package day01;

public class Demo {

    public static void main(String[] args) {


        int o = 128;
        Integer a = 99;
        Integer b = 128;
        Integer l = new Integer(99);
        Integer c = Integer.valueOf(128);
        Integer e = Integer.valueOf(128);

        Integer h = Integer.valueOf(100);
        Integer j = Integer.valueOf(100);
        System.out.println(a==l);//false  非 new Integer 指向了静态常量池中的数据 ，而new Integer 指向了堆内存
        System.out.println(o==e);//true Integer变量和int变量比较时，只要两个变量的值是向等的，
        //// 则结果为true（因为包装类Integer和基本数据类型int比较时，java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较）
        System.out.println(b==e);//false
        System.out.println(c==e);//false
        System.out.println(c.equals(e));//true
        System.out.println(h.equals(j));//true  由于Integer 重写了equals 方法  比较的是value 值 所以相等
    }
}
