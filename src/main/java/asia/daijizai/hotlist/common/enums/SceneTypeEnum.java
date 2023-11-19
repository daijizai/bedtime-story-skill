package asia.daijizai.hotlist.common.enums;

import lombok.AllArgsConstructor;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/26 11:41
 * @description
 */

@AllArgsConstructor
public enum SceneTypeEnum {
    SUGGEST_SCENE("3","推荐场景")
    ;

    private String key;
    private String desc;

    public String getKey(){
        return key;
    }
    public String getDesc(){
        return desc;
    }
}
