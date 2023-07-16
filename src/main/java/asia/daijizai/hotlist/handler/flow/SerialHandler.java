package asia.daijizai.hotlist.handler.flow;

import asia.daijizai.hotlist.entity.BizFrontSerial;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/8 16:11
 * @description
 */

public interface SerialHandler {

    BizFrontSerial getBizSerial(String businessKey);
}
