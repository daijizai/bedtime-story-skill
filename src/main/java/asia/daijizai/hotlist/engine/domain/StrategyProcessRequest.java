package asia.daijizai.hotlist.engine.domain;

import asia.daijizai.hotlist.common.enums.CustomStrategyTypeEnum;
import lombok.Data;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/26 1:25
 * @description
 */
@Data
public class StrategyProcessRequest {
    private CustomStrategyTypeEnum strategyType;
}
