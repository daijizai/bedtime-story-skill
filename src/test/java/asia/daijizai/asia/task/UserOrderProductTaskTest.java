package asia.daijizai.asia.task;

import asia.daijizai.hotlist.entity.BizFrontSerial;
import asia.daijizai.hotlist.entity.FlowBusinessNotify;
import asia.daijizai.hotlist.strategy.common.flow.IFlowTask;
import asia.daijizai.hotlist.strategy.tenant.flow.task.UserOrderProductTask;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/17 23:46
 * @description
 */
@SpringBootTest
public class UserOrderProductTaskTest {


    @Test
    public void orderTest(){
        IFlowTask flowTask = new UserOrderProductTask();
        FlowBusinessNotify flowBusinessNotify=new FlowBusinessNotify();
        BizFrontSerial bizFrontSerial=new BizFrontSerial();
        flowTask.dealTaskKey(flowBusinessNotify,bizFrontSerial);
    }
}
