package asia.daijizai.hotlist.strategy.common.flow;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/8 1:51
 * @description 流程任务key注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IFlowTaskKey {
    String value();
    String desc();
}
