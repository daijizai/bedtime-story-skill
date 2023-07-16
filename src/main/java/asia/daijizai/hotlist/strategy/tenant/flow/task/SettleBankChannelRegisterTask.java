package asia.daijizai.hotlist.strategy.tenant.flow.task;

import asia.daijizai.hotlist.entity.BizFrontSerial;
import asia.daijizai.hotlist.entity.FlowBusinessNotify;
import asia.daijizai.hotlist.handler.flow.SerialHandler;
import asia.daijizai.hotlist.lock.LockServiceHazelcastImpl;
import asia.daijizai.hotlist.strategy.common.flow.IFlowTask;
import asia.daijizai.hotlist.strategy.common.flow.IFlowTaskKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/8 15:27
 * @description
 */
@Slf4j
@IFlowTaskKey(value = "",desc = "")
@Service(value = "")
public class SettleBankChannelRegisterTask implements IFlowTask {

    @Autowired
    private LockServiceHazelcastImpl lockService;

    @Override
    public void dealTaskKey(FlowBusinessNotify flowBusinessNotify, BizFrontSerial bizFrontSerial) {
        String lockKey=flowBusinessNotify.getTaskDefinitionKey()+flowBusinessNotify.getFlowInstanceId();
        lockService.lock(lockKey,60);
        try {

        }catch (Exception e){
            lockService.unLock(lockKey);
        }
    }

    @Override
    public SerialHandler getSerialHandler() {
        return null;
    }
}
