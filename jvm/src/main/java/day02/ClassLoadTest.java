package day02;


public class ClassLoadTest {


    public static void main(java.lang.String[] args) {


        try {
            //获取当前类的类加载器

            ClassLoader classLoader = Class.forName("day02.ClassLoadTest").getClassLoader();
            System.out.println(classLoader);
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);

            java.lang.String test = new  java.lang.String();
           // Jack jack = new Jack();
            System.out.println(test.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public   void add(){
         int  i = 10;
    }
}
