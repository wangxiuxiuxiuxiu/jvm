package day11;

import java.util.ArrayList;
import java.util.List;

/*//gc 的使用情况

-XX:+PrintCommandLineFlags  打印具体使用了哪些垃圾回收器
JDK 8默认使用 ParallelGC
JDK 9 之后用 G1GC，将parNewGC 和 ConcMarkSweepGC（cms收集器） 废弃了




*/
public class GCUseTest {

    public static void main(String[] args) {

        byte[] arr = new byte[1024*1024*3];
        List list = new ArrayList();
        for (int i=0;i<5;i++){
            list.add(arr);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("就是简单试试！");
    }
}
