package asia.daijizai.asia.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/19 19:22
 * @description
 */

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        long[] nums=new long[n];
        for (int i = 0; i < n; i++) {
            nums[i]=in.nextInt();
        }
        long oriSum=0;
        int maxIdx=0;
        long maxCount=Long.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            oriSum+=nums[i];
            if(nums[i]*nums[i+1]>maxCount){
                maxIdx=i;
                maxCount=nums[i]*nums[i+1];
            }
        }
        oriSum+=nums[nums.length-1];
        System.out.println(oriSum-nums[maxIdx]-nums[maxIdx+1]+maxCount);
    }
}
