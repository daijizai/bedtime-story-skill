package asia.daijizai.hotlist.fuse.enums;

import lombok.Getter;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/27 15:57
 * @description 熔断策略枚举
 */
@Getter
public enum FuseStrategyEnum {
    SLIDING_WINDOW("滑动窗口实现","SlidingWindow");

    private final String desc;
    private final String classPrefix;

    FuseStrategyEnum(String desc, String classPrefix) {
        this.desc = desc;
        this.classPrefix = classPrefix;
    }
}
