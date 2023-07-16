package asia.daijizai.asia;

import asia.daijizai.hotlist.fuse.FuseHandler;
import asia.daijizai.hotlist.fuse.FuseModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TreeMap;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/5/27 15:43
 * @description
 */
@SpringBootTest
public class SlidingWindowStrategyTest {


    @Test
    public void testFuse() throws InterruptedException {
        FuseHandler fuseHandler = new FuseHandler();
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("userNo", "101");
        FuseModel fuseModel = FuseModel.builder()
                .serviceScene("TEST")
                .samplingTimeSecond(30)
                .threshold(20)
                .fuseTimeSecond(30)
                .fuseFactors(treeMap).build();
        for (int i = 0; i < 30; i++) {
            System.out.println(i + "times fuse is " + fuseHandler.count(fuseModel));
        }
        Thread.sleep(2000L);

        System.out.println("》》》窗口未过期《《《");
        for (int i = 0; i < 30; i++) {
            System.out.println("黑名单未过期" + i + "times fuse is " + fuseHandler.count(fuseModel));
        }
        Thread.sleep(30000L);

        System.out.println("》》》窗口已过期《《《");
        for (int i = 0; i < 30; i++) {
            System.out.println("窗口已过期" + i + "times fuse is " + fuseHandler.count(fuseModel));
        }
    }
}
