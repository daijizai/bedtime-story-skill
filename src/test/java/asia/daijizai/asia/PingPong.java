package asia.daijizai.asia;

import java.util.concurrent.*;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/9/17 23:55
 * @description PingPong测试
 */

public class PingPong {

    static final ExecutorService THREAD_POOL = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        BlockingQueue<Byte> q1 = new LinkedBlockingQueue<>(), q2 = new LinkedBlockingQueue<>();
        THREAD_POOL.submit(() -> pingpong(q2, q1)); // thread A
        Future<?> f = THREAD_POOL.submit(() -> pingpong(q1, q2)); // thread B
        q1.put((byte) 1);
        System.out.println(f.get() + " ms");
    }

    private static long pingpong(BlockingQueue<Byte> in, BlockingQueue<Byte> out) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) out.put(in.take());
        return System.currentTimeMillis() - start;
    }
}
