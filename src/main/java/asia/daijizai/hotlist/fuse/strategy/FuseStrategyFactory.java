package asia.daijizai.hotlist.fuse.strategy;

import asia.daijizai.hotlist.fuse.enums.FuseStrategyEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/27 15:55
 * @description 用于获取一个熔断策略实现类的熔断策略工厂
 */
@Slf4j
public class FuseStrategyFactory {
    public static Map<FuseStrategyEnum,AbstractFuseStrategy> strategyContainer=new HashMap<>();
    public static AbstractFuseStrategy getStrategy(FuseStrategyEnum fuseStrategyEnum, RedisTemplate<String, String> redisTemplate){
        AbstractFuseStrategy fuseStrategy = strategyContainer.get(fuseStrategyEnum);
        if(fuseStrategy!=null){
            return fuseStrategy;
        }

        try {
            Class<?> strategyClass = Class.forName("asia.daijizai.hotlist.fuse.strategy." + fuseStrategyEnum.getClassPrefix() + "Strategy");
            Constructor<?> constructor = strategyClass.getConstructor(RedisTemplate.class);
            AbstractFuseStrategy strategy = (AbstractFuseStrategy) constructor.newInstance(redisTemplate);
            strategyContainer.put(fuseStrategyEnum,strategy);
            return strategy;
        }catch (Exception e){
            log.error("");
            throw new RuntimeException();
        }
    }
}
