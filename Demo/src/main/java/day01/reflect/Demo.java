package day01.reflect;

import java.lang.reflect.Method;

public class Demo {

    public static void main(String[] args)  throws  Exception{
        doReflect();
    }

    public static void doReflect()  throws  Exception{
        // 1. 使用外部配置的实现，进行动态加载类
        Class<?> cz = Class.forName("reflect.TempFunctionTest");
        Object instant = cz.newInstance();
        Method method = cz.getMethod("sayHello", String.class);
        method.invoke(instant, "hi");
    }


}

class TempFunctionTest {

    public void sayHello(String name) {
        System.out.println("hello:" + name);
    }

}
