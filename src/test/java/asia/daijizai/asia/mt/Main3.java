package asia.daijizai.asia.mt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/19 19:34
 * @description
 */

public class Main3 {

    public static void main(String[] args) {
        createThread();
    }


    public static void createThread() {
        Thread thread = new Thread(() -> {
            createThread(); // 递归创建新线程
        });
        thread.start();
    }
}
