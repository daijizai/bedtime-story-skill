package asia.daijizai.hotlist.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/17 16:29
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
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
     * 吃食物
     * @param food 被吃的食物
     */
    public void eatFood(Food food){
        System.out.println("I am eating "+food.name);
    }
}
