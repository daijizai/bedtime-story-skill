package asia.daijizai.asia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/12 14:44
 * @description
 */

public class ThreadPoolTest {

    private static final ThreadPoolExecutor threadPool
            = new ThreadPoolExecutor(5, 30, 10, TimeUnit.SECONDS, new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws Exception {

        System.out.println(async1(new ArrayList<>()));
        System.out.println(async2(1));
        threadPool.shutdown();
    }

    public static Boolean async1(List<Integer> nums) throws ExecutionException, InterruptedException, TimeoutException {
        List<Future<Boolean>> futures=new ArrayList<>();
        for (Integer num : nums) {
            Callable<Boolean> task = () -> {
                // do something
                return num > 0;
            };
            futures.add(threadPool.submit(task));
        }
        for (Future<Boolean> future : futures) {
            if (!future.get()){
                return future.get();
            }
        }
        return true;
    }

    public static Boolean async2(Integer num) throws ExecutionException, InterruptedException, TimeoutException {
        CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
            // do something
            return num > 0;
        }, threadPool);

        return future.get(100,TimeUnit.MILLISECONDS);
    }

    public static Boolean async3(List<Integer> nums) throws InterruptedException, ExecutionException, TimeoutException {
        List<CompletableFuture<Boolean>> completableFutures = new ArrayList<>();
        for (Integer num : nums) {
            CompletableFuture<Boolean> completableFuture = CompletableFuture.supplyAsync(() -> {
                // do something
                return num > 0;
            }, threadPool);
            completableFutures.add(completableFuture);
        }

        CompletableFuture<Void> allFutures =
                CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));

        CompletableFuture<List<Boolean>> resultsFuture = allFutures.thenApply(v ->
                completableFutures.stream()
                        .map(CompletableFuture::join)
                        .collect(Collectors.toList())
        );

        List<Boolean> results = resultsFuture.get(5, TimeUnit.SECONDS);
        for (Boolean result : results) {
            if (!result) {
                return false;
            }
        }
        return true;
    }


}
