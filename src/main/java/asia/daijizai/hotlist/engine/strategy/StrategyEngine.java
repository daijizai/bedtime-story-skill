package asia.daijizai.hotlist.engine.strategy;

import asia.daijizai.hotlist.engine.domain.StrategyInfo;
import asia.daijizai.hotlist.engine.domain.StrategyProcessRequest;

import java.util.List;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/26 1:18
 * @description
 */

public interface StrategyEngine {

    <T extends StrategyInfo> List<T> allStrategyProcess(StrategyProcessRequest req, Class<T> object);
    <T extends StrategyInfo> T firstStrategyProcess(StrategyProcessRequest req, Class<T> object);

}
