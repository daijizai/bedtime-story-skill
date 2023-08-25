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
        food.eatFood(food);
        int a=100;
        int b=101;
        System.out.println(10086);
        String ans = add(a, b);
        System.out.println(ans);
    }

    private String add(int a,int b){
        int res=a+b;
        return "ans is "+res;
    }
}
