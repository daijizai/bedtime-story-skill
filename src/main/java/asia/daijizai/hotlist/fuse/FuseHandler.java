package asia.daijizai.hotlist.fuse;

import asia.daijizai.hotlist.fuse.enums.FuseStrategyEnum;
import asia.daijizai.hotlist.fuse.strategy.AbstractFuseStrategy;
import asia.daijizai.hotlist.fuse.strategy.FuseStrategyFactory;
import asia.daijizai.hotlist.fuse.strategy.SlidingWindowStrategy;
import com.alibaba.fastjson2.JSON;
import com.ctrip.framework.apollo.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/27 15:45
 * @description 熔断查询处理器
 */
@Slf4j
@Component
public class FuseHandler {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        ConfigService.getAppConfig().addChangeListener(new BlackListChangeListener(redisTemplate));
    }

    public Boolean count(FuseModel fuseModel) {
        AbstractFuseStrategy strategy = FuseStrategyFactory.getStrategy(FuseStrategyEnum.SLIDING_WINDOW, redisTemplate);
        Boolean result = strategy.handle(fuseModel);
        if (result) {
            log.warn("[熔断] 触发因子：{}", JSON.toJSONString(fuseModel.getFuseFactors()));
        }
        return result;
    }

    public Boolean isFuse(FuseModel fuseModel) {
        AbstractFuseStrategy strategy = FuseStrategyFactory.getStrategy(FuseStrategyEnum.SLIDING_WINDOW, redisTemplate);
        return strategy.isFuse(fuseModel);

    }
}
