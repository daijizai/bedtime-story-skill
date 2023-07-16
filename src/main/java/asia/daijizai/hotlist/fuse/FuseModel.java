package asia.daijizai.hotlist.fuse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.TreeMap;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/26 23:37
 * @description 熔断模型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FuseModel {

    /**
     * 业务场景
     */
    private String serviceScene;
    /**
     * 熔断因子
     */
    private TreeMap<String,String> fuseFactors;
    /**
     * 采样时间
     */
    private Integer samplingTimeSecond;
    /**
     * 熔断阈值
     */
    private Integer threshold;
    /**
     * 熔断时间
     */
    private Integer fuseTimeSecond;
}
