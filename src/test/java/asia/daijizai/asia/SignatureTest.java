package asia.daijizai.asia;

import asia.daijizai.hotlist.security.Md5WithRsaSignature;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/6 0:59
 * @description
 */
@SpringBootTest
public class SignatureTest {

    @Test
    public void test(){
        Md5WithRsaSignature signature = new Md5WithRsaSignature();
        String body ="test";
        String sign = signature.sign(body);
        boolean checked = signature.checkSign(body, sign);
        System.out.println(checked);
    }


}
