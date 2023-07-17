package asia.daijizai.asia;

import asia.daijizai.hotlist.entity.Food;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/17 16:31
 * @description
 */
@SpringBootTest
public class FoodTest {

    @Test
    public void test(){
        Food food = new Food("apple","green apple","1");
        System.out.println(food);

    }
}
