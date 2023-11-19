package asia.daijizai.hotlist.engine.strategy;

import asia.daijizai.hotlist.common.enums.SceneTypeEnum;
import asia.daijizai.hotlist.engine.domain.CustomStrategyDTO;
import asia.daijizai.hotlist.engine.domain.CustomSuggestStrategy;
import asia.daijizai.hotlist.engine.domain.StrategyInfo;
import asia.daijizai.hotlist.engine.domain.StrategyProcessRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/8/26 11:09
 * @description
 */

public class StrategyEngineImpl implements StrategyEngine{
    @Override
    public <T extends StrategyInfo> List<T> allStrategyProcess(StrategyProcessRequest req, Class<T> object) {
        return null;
    }

    @Override
    public <T extends StrategyInfo> T firstStrategyProcess(StrategyProcessRequest req, Class<T> object) {
        return null;
    }

    private List<CustomStrategyDTO> strategyGroupProcess(StrategyProcessRequest req){
        // 从cache中拿到
        List<CustomSuggestStrategy> suggestStrategies=new ArrayList<>();

        //策略类型、场景、规则 校验
        suggestStrategies.stream()
                .filter(s->s.getStrategyGroupId()!=null)
                .filter(s->s.getCustomStrategyMap().keySet().contains(req.getStrategyType().getType()))
                .filter(s->s.getSuggestSceneId()==null||sceneCheck(req,s.getSuggestSceneId(),SceneTypeEnum.SUGGEST_SCENE))
                .filter(s->ruleCheck(req,s.getId(),s.getRuleMap()))
                .collect(Collectors.toList());

        return null;
    }

    /**
     * 场景校验
     * @param req
     * @param suggestSceneId
     * @param sceneTypeEnum
     * @return
     */
    private Boolean sceneCheck(StrategyProcessRequest req, String suggestSceneId, SceneTypeEnum sceneTypeEnum){
        return null;
    }

    /**
     * 规则校验
     * @param req
     * @param checkObjectId
     * @param ruleMap
     * @return
     */
    private Boolean ruleCheck(StrategyProcessRequest req, Long checkObjectId, Map<String ,Object> ruleMap){
        return null;
    }
}
