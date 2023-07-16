package asia.daijizai.hotlist.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author daijizai
 * @version 1.0
 * @date 2023/7/6 0:13
 * @description 数字签名
 */

@Component
@Slf4j
public class Md5WithRsaSignature {

    public static final String PRIVATE_KEY ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAMR+ZURStkHGkLl/" +
            "u74mp4oHMo60IdMcVBXdbMuXBQ1Jy8pD9mqwv90ofHLuNQftDI2pkzLHHHkM86eI" +
            "RiYNDtAM76rU+66TQqrK65BN9xUWS36zUa6M/1EBifHnyRI3HNSHdJlAdHft+jYW" +
            "mGVK5biSzFUEi0jbLpsRaKIi4nMJAgMBAAECgYAA7rSeUWIqB74yEygZ6+cJoaUc" +
            "xkAO12iSvf1BLhNJD9uWtyHZOcN/UizdAsJfqkFP/skDCazZ6jTRy7TBg3hZhEU+" +
            "upV9e0TM+lGOM2FvBlwfpTnrE2D8Sua8ijfIck9qbivWaezPT30mIkBvmlb0bhDN" +
            "ZbOZ96WOAWlAY6RvcQJBAOIlltFpXnjyniknM8rzo3LhHf2RLA5XhsH+YYto9UAs" +
            "eB2mNa6BPdAevDUp/s4LQnS1S7o+O6PdW8kpkArl0n0CQQDebrV+CnBndONgTJO3" +
            "LESI89b0q66zSWXqvJb7zQuaCUThxAeSltcXt5FsEyZ3dJSOq6VGL7DRo9k9VXXI" +
            "SRx9AkBEY4+vdoj+VIil81gDWRilxhRWuU80ax2yjuYazbvVE12jwb7cLfNue8z4" +
            "2uFWmCsZtjXXdbh9fpSiSfJoiUXVAkAmc1raY/GUYMdhgTtTwcpDJmu1NexoP7rn" +
            "fhxXgNWNliabJGjutTaPegMgfJr8sWFw3EkgvePCCaHnEVvf+It9AkEAyePuLLg1" +
            "94rgigair1tWVlj4AtJM4hTw2YE3lA+CqkGRpLpjUzbSdZfagJKJ1eTR8ZhjE+Ox" +
            "XAGcUH3VRA5QUw==";
    public static final String PUBLIC_KEY ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDEfmVEUrZBxpC5f7u+JqeKBzKO" +
            "tCHTHFQV3WzLlwUNScvKQ/ZqsL/dKHxy7jUH7QyNqZMyxxx5DPOniEYmDQ7QDO+q" +
            "1Puuk0KqyuuQTfcVFkt+s1GujP9RAYnx58kSNxzUh3SZQHR37fo2FphlSuW4ksxV" +
            "BItI2y6bEWiiIuJzCQIDAQAB";

    public String sign(String source){
        try {
            String hashedSource = DigestUtils.md5DigestAsHex(source.getBytes());

            byte[] privateKeyBytes = PRIVATE_KEY.getBytes(StandardCharsets.UTF_8);
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyBytes));
            PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(priPKCS8);
            Signature signatureUtil = Signature.getInstance("MD5withRSA");
            signatureUtil.initSign(privateKey);
            signatureUtil.update(hashedSource.getBytes(StandardCharsets.UTF_8));
            byte[] signed = signatureUtil.sign();
            String signedStr = Base64.getEncoder().encodeToString(signed);
            log.info("md5:{},ras:{}",hashedSource,signedStr);
            return signedStr;
        }catch (Exception e){
            log.error("签名失败，{}",e.getMessage());
        }
        return null;
    }

    public boolean checkSign(String source,String signature){
        try {
            String hashedSource = DigestUtils.md5DigestAsHex(source.getBytes());

            byte[] publicKeyBytes = PUBLIC_KEY.getBytes(StandardCharsets.UTF_8);
            X509EncodedKeySpec pubX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyBytes));
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(pubX509);
            Signature signatureUtil = Signature.getInstance("MD5withRSA");
            signatureUtil.initVerify(publicKey);
            signatureUtil.update(hashedSource.getBytes(StandardCharsets.UTF_8));
            return  signatureUtil.verify(Base64.getDecoder().decode(signature));
        }catch (Exception e){
            log.error("验签失败，{}",e.getMessage());
        }
        return false;

    }
}
