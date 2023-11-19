package asia.daijizai.hotlist.engine.domain;

import asia.daijizai.hotlist.entity.BaseDO;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/26 11:14
 * @description
 */

@Data
public class CustomSuggestStrategy extends BaseDO {
    private String name;
    private String description;
    /**
     * 策略组id
     */
    private Long strategyGroupId;
    /**
     * 关联的策略信息
     */
    private Map<String , List<Long>> customStrategyMap;
    /**
     * 推荐场景id
     */
    private String suggestSceneId;
    private Map<String ,Object> ruleMap;
}
