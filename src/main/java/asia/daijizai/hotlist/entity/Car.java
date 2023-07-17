package asia.daijizai.hotlist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/18 0:00
 * @description
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    /**
     * 名字
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 价格
     */
    private String price;

    /**
     * 攻击
     */
    public void attack(){
        System.out.println("I am attacking.");
    }
}
