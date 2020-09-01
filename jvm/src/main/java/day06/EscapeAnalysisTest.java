package day06;


/*逃逸分析，java虚拟机在分析对象作用范围，决定是否将其在堆中分配内存。
    对象逃逸：在方法外能够引用该对象则为对象逃逸，比如 成员变量的赋值，方法返回值，实例对象参数传递。
         如果对象没有发生逃逸的话，会在栈中分配。将不会创建对象。
逃逸分析优化：

1) 锁消除

    我们知道线程同步锁是非常牺牲性能的，当编译器确定当前对象只有当前线程使用，那么就会移除该对象的同步锁。

    例如，StringBuffer 和 Vector 都是用 synchronized 修饰线程安全的，但大部分情况下，它们都只是在当前线程中用到，这样编译器就会优化移除掉这些锁操作。

    锁消除的 JVM 参数如下：

    开启锁消除：-XX:+EliminateLocks
    关闭锁消除：-XX:-EliminateLocks
    锁消除在 JDK8 中都是默认开启的，并且锁消除都要建立在逃逸分析的基础上。
2）标量替换：首先要明白标量和聚合量，基础类型和对象引用可以理解为标量，不可进行下一步分解，而能被进一步分解的量就是聚合量，比如：对象。

          对象是聚合量，它又可以被进一步分解成标量，将其成员变量分解为分散的变量，这就叫做标量替换。

          这样，如果一个对象没有发生逃逸，那压根就不用创建它，只会在栈或者寄存器上创建它用到的成员标量，
          节省了内存空间，也提升了应用程序性能。

   栈上分配

当对象没有发生逃逸时，该对象就可以通过标量替换分解成成员标量分配在栈内存中，和方法的生命周期一致，随着栈帧出栈时销毁，减少了 GC 压力，提高了应用程序性能。

*/
public class EscapeAnalysisTest {

    public static void main(String[] args) {

        EscapeAnalysisTest escapeAnalysisTest = new EscapeAnalysisTest();
        long start = System.currentTimeMillis();
        for (int i=0;i<100000000;i++){

            escapeAnalysisTest.getA();

        }
        long end = System.currentTimeMillis();
        System.out.println("time:"+(end-start)+"ms");

    }
    public void getA(){
        A a = new A();
    }
}
class A{
    int i = 10;
    int j = 20;
    //如果加了下面这行，即使A 对象没有发生逃逸，也会在堆上分配。
    //猜测--因为类B 是个聚合量 无法进行标量替换
   // B b = new B();


}
class B{
    int i = 10;
    int j = 20;

}
