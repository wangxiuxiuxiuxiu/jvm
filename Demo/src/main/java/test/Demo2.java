package test;

public class Demo2 {

    public static void main(String[] args) {
        int a = 3;
        int b= 4;
        a = a & b; // a = 4 ^ 3, b=3;

        System.out.println(a);
        b = a ^ b; // a = 4 ^ 3, b = 4 ^ 3 ^ 3 = 4

        System.out.println(b);
        a = a ^ b; // a = 4 ^ 3 ^ 4 = 3, b = 4;

        System.out.println(a);

      /*
       a    0000 0011  3
       b    0000 0100  4

            0000 0111  7
            0000 0100  4


       */

        System.out.println(a);
        System.out.println(b);


    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans= ans^nums[i];   //异或运算
        }
        return ans;
    }
}
