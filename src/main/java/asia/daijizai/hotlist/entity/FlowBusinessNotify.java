package asia.daijizai.hotlist.entity;

import lombok.Data;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/8 15:00
 * @description
 */
@Data
public class FlowBusinessNotify {
    /**
     * 流程定义键（哪个流程）
     */
    private String flowDefinitionKey;
    /**
     * 流程实例id（哪个实例）
     */
    private String flowInstanceId;
    /**
     * 任务定义键（哪个任务）
     */
    private String taskDefinitionKey;
    /**
     * 本次的数据
     */
    private String businessData;
    /**
     * 开始流程的时候，业务侧返回的，如果为空，缺省为
     */
    private String businessKey;
    /**
     * 提交的操作
     */
    private String actionData;
}
