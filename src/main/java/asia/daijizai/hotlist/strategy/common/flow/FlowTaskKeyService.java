package asia.daijizai.hotlist.strategy.common.flow;

import asia.daijizai.hotlist.entity.BizFrontSerial;
import asia.daijizai.hotlist.entity.FlowBusinessNotify;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Map;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/8 1:47
 * @description
 */

public class FlowTaskKeyService implements ApplicationListener<ContextRefreshedEvent> {

    private static Map<String,IFlowTask>flowTaskMap=null;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }

    public void executor(FlowBusinessNotify flowBusinessNotify){
        IFlowTask flowTask = getFlowTask(flowBusinessNotify.getTaskDefinitionKey());
        BizFrontSerial bizSerial = flowTask.getSerialHandler().getBizSerial(flowBusinessNotify.getBusinessKey());

        flowTask.dealTaskKey(flowBusinessNotify,bizSerial);
    }

    /**
     * 查询流水Task
     * @param taskKey
     * @return
     */
    private IFlowTask getFlowTask(String taskKey){
        IFlowTask iFlowTask = flowTaskMap.get(taskKey);
        if(iFlowTask==null){

        }
        return iFlowTask;
    }


}
