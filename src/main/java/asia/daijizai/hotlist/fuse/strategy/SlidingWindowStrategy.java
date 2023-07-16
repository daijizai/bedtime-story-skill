package asia.daijizai.hotlist.fuse.strategy;

import asia.daijizai.hotlist.fuse.FuseModel;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.concurrent.TimeUnit;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/27 1:01
 * @description 基于redis中zset实现滑动窗口策略
 */

public class SlidingWindowStrategy extends AbstractFuseStrategy {

    public SlidingWindowStrategy(RedisTemplate<String, String> redisTemplate) {
        super(redisTemplate);
    }

    @Override
    protected Boolean doHandle(FuseModel fuseModel) {
        long current = System.currentTimeMillis();
        long windowSize = fuseModel.getSamplingTimeSecond() * 1000L;
        long expired = current - windowSize;
        String fuseKey = PREFIX + buildFuseKey(fuseModel);
        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
        //删除已过期的数据（窗口范围外的数据）
        zSetOperations.removeRangeByScore(fuseKey, 0, expired);
        //加入新节点 为什么要加随机数？
        zSetOperations.add(fuseKey, current + random(), current);
        //设置过期时间
        redisTemplate.expire(fuseKey, fuseModel.getSamplingTimeSecond() * 2 * 1000L, TimeUnit.MILLISECONDS);
        Long count = zSetOperations.count(fuseKey, expired, current);
        //count大于等与熔断阈值，返回True，表示熔断
        return count.compareTo(new Long(fuseModel.getThreshold())) >= 0;
    }

    private String random() {
        String random = String.valueOf(Math.random());
        return random.substring(random.length() - 4);
    }
}
