package day03;


/*

栈溢出 ：

默认情况下 count 6508  后会报StackOverflowError 异常
设置 -Xss256 count 1647 后会报StackOverflowError 异常
*/

public class Stack {
    private static   int count =0;
    public static void main(String[] args) {
        System.out.println("--"+count);
        count++;

        main(args);
    }

}
