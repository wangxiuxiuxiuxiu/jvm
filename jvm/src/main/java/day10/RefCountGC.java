package day10;

import org.junit.jupiter.api.Test;

public class RefCountGC {

    //标记阶段:引用计数算法
   /*
         -XX:+PrintGCDetails 打印gc记录
        概述 ：对于每个对象保存一个整型的引用计数器属性，用于记录对象被引用的情况。

        当一个对象A被引用时，对象A的引用计数器+1，当引用失效时，引用计数器-1，
        如果对象的引用计数器为0，那么该对象没有任何引用指向，要被当成垃圾回收。

        优点：实现简单，垃圾对象便于识别，判断效率高，垃圾对象回收没有延迟。

        缺点：需要为每个对象保存一个计数器字段，这种做法增加了空间开销。
            每次引用对象，需要更新引用计数器，增加了时间开销。
            还有个致命弱点是无法解决循环引用问题。


   */
    Object refCountGC =null;

    byte[] cc = new byte[1024*1024 *5];

    //循环引用
    @Test
    public void test(){
        RefCountGC refCountGC1 = new RefCountGC();
        RefCountGC refCountGC2 = new RefCountGC();

        refCountGC1.refCountGC = refCountGC2;
        refCountGC2.refCountGC = refCountGC1;

        refCountGC1=null;
        refCountGC2=null;
        System.gc();//进行了垃圾回收，证明java 使用的不是引用计数算法


    }


}
