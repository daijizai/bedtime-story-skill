package asia.daijizai.hotlist.fuse.strategy;

import asia.daijizai.hotlist.fuse.FuseModel;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/26 23:58
 * @description 抽象熔断策略
 */

public abstract class AbstractFuseStrategy {
    protected RedisTemplate<String, String> redisTemplate;
    private static final String SPLIT = ":";
    private static final String BLACK = "black";
    protected static final String PREFIX = "fuse_";

    public AbstractFuseStrategy(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Boolean handle(FuseModel fuseModel) {
        String blackKey = buildBlackKey(fuseModel);
        if (redisTemplate.hasKey(blackKey)) {
            return Boolean.TRUE;
        }
        Boolean fuseResult = doHandle(fuseModel);
        if (!fuseResult) {
            return Boolean.FALSE;
        }
        redisTemplate.opsForValue().set(blackKey, String.valueOf(System.currentTimeMillis()), fuseModel.getFuseTimeSecond(), TimeUnit.SECONDS);
        return Boolean.TRUE;
    }

    public Boolean isFuse(FuseModel fuseModel) {
        String blackKey = buildBlackKey(fuseModel);
        return redisTemplate.hasKey(blackKey) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 执行熔断算法
     *
     * @param fuseModel 熔断模型
     * @return 熔断结果，True表示发生熔断
     */
    protected abstract Boolean doHandle(FuseModel fuseModel);

    protected static String buildFuseKey(FuseModel fuseModel) {
        StringBuilder keyBuilder = new StringBuilder();
        keyBuilder.append(fuseModel.getServiceScene()).append(SPLIT);
        for (String fuseFactor : fuseModel.getFuseFactors().values()) {
            keyBuilder.append(fuseFactor).append(SPLIT);
        }
        return keyBuilder.toString();
    }

    public static String buildBlackKey(FuseModel fuseModel) {
        return PREFIX + BLACK + SPLIT + buildFuseKey(fuseModel);
    }
}
