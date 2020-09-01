public class InterCompTest {

/*
执行引擎
    解释器：当程序启动，马上开始解释执行，省去了编辑时间
    即时编译：需要先把字节码编译成本地机器码在去执行

    -Xint 解释器执行  执行时间 18451ms
    -Xcomp 即使编辑器执行 执行时间 7193ms
    -Xmixed 混合执行 执行时间 6309
    */

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        for (int i=0;i<1000000;i++){
            System.out.println("执行count："+i);
        }
        long end = System.currentTimeMillis();
        System.out.println("执行时间："+(end-start));
    }
}
