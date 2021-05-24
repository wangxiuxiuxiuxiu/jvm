package test;

public class Demo {

    public static void main(String[] args) {


        Byte a = 3;
        Byte b = 3;
        Byte a1 = new Byte(a);
        byte a2 = 3;
        Integer c = new Integer(127);
        Integer d = 127;
        Integer d1 = 127;

        Double e = 2.5;
        double f = 2.5;
        Double h = 2.5;
        System.out.println(e==h);// 自动装箱 ，使用Double.valueOf() 返回一个 new Double() 比较地址
        System.out.println(e==f);//自动拆箱 doubleValue() 返回值，比较值
        System.out.println(c==d);//自动拆箱 intValue()
        System.out.println(a==a1);//比较地址
        System.out.println(a2==a1);//比较值
        System.out.println(c==d);//比较地址
        System.out.println(d1==d);//从常量池中找，发现有就返回 为true


/*        false
        true
        true
        false
        true*/
    }
}
