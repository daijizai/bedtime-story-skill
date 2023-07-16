package asia.daijizai.hotlist.strategy.common.flow;

import asia.daijizai.hotlist.entity.BizFrontSerial;
import asia.daijizai.hotlist.entity.FlowBusinessNotify;
import asia.daijizai.hotlist.handler.flow.SerialHandler;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/8 1:51
 * @description
 */

public interface IFlowTask {

    /**
     * 处理任务
     */
    void dealTaskKey(FlowBusinessNotify flowBusinessNotify, BizFrontSerial bizFrontSerial);

    /**
     * 获取流水处理
     */
    SerialHandler getSerialHandler();
}
