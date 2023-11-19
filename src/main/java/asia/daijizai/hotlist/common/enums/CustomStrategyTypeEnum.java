package asia.daijizai.hotlist.common.enums;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/26 11:41
 * @description
 */

@AllArgsConstructor
public enum CustomStrategyTypeEnum {
    SHELF_REINFORCE("shelfReinforce","货架氛围策略")
    ;

    private String type;
    private String desc;

    public String getType(){
        return type;
    }
    public String getDesc(){
        return desc;
    }
}
