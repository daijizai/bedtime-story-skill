package asia.daijizai.asia.mt;

import java.util.Scanner;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/19 19:02
 * @description
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int q=in.nextInt();
        while ( q --!=0) { // 注意 while 处理多个 case
            int m = in.nextInt();//5
            int x = in.nextInt();//17
            if(x<=m){
                System.out.println(x);
                continue;
            }
            for (int i = 1; i < Integer.MAX_VALUE; i++) {
                if(m*i>x){
                    System.out.println(x-(i-1)*m);
                    break;
                }
            }
        }
    }
}
