import org.openjdk.jol.info.ClassLayout;

public class Demo {
    public static void main(String[] args) {

        Object o = new Object();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        System.out.println(ClassLayout.parseClass(A.class).toPrintable());

    }
   }
class A{
    int i;
    long[] arr = new long[6];
}