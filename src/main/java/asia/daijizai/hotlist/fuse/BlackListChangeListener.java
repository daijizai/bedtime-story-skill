package asia.daijizai.hotlist.fuse;

import asia.daijizai.hotlist.fuse.strategy.AbstractFuseStrategy;
import com.alibaba.fastjson2.JSON;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/27 16:45
 * @description 黑名单变更监听类
 */

@AllArgsConstructor
public class BlackListChangeListener implements ConfigChangeListener {
    private final static String ADD ="add_to_black_list";
    private final static String REMOVE ="remove_from_black_list";

    protected RedisTemplate<String, String> redisTemplate;

    @Override
    public void onChange(ConfigChangeEvent configChangeEvent) {
        if(configChangeEvent.isChanged(ADD)){
            add(configChangeEvent.getChange(ADD).getNewValue());
        }
        if(configChangeEvent.isChanged(REMOVE)){
            remove(configChangeEvent.getChange(REMOVE).getNewValue());
        }
    }

    /**
     * 从黑名单中移除
     * @param value
     */
    private void remove(String value){
        if(StringUtils.isBlank(value)){
            return;
        }
        FuseModel fuseModel = JSON.parseObject(value, FuseModel.class);
        String blackKey = AbstractFuseStrategy.buildBlackKey(fuseModel);
        if(redisTemplate.hasKey(blackKey)){
            redisTemplate.delete(blackKey);
        }
    }

    /**
     * 添加到黑名单中
     * @param value
     */
    private void add(String value){
        if(StringUtils.isBlank(value)){
            return;
        }
        FuseModel fuseModel = JSON.parseObject(value, FuseModel.class);
        String blackKey = AbstractFuseStrategy.buildBlackKey(fuseModel);
        redisTemplate.opsForValue().set(blackKey,String.valueOf(System.currentTimeMillis()),fuseModel.getFuseTimeSecond(), TimeUnit.SECONDS);
    }
}
