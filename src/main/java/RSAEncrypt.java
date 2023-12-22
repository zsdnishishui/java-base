



import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加密解密
 *
 * @author lg
 * @version 1.0
 * @date 2022/7/1 17:12
 */
public class RSAEncrypt {
    //默认的公钥
    public final static String PUBLIC_KEY_DEFAULT = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDN7VKDpN8cbfjM1xvSQxYGAndYweziXPPEwdCmGAkRSxUO5w0gpZThJFFGbnqeTpOlRm4uQi4fD0OAJP4fd4+hRcTaeIxWGn+ymUmnjY2VjPAtsQTyYDqVPL6hp6yUrToneuT0ChjadsgUJU8F5fPW9twbyszcVBfQ+hIM8WTWkQIDAQAB";
    //默认的私钥
    public final static String PRIVATE_KEY_DEFAULT = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAM3tUoOk3xxt+MzXG9JDFgYCd1jB7OJc88TB0KYYCRFLFQ7nDSCllOEkUUZuep5Ok6VGbi5CLh8PQ4Ak/h93j6FFxNp4jFYaf7KZSaeNjZWM8C2xBPJgOpU8vqGnrJStOid65PQKGNp2yBQlTwXl89b23BvKzNxUF9D6EgzxZNaRAgMBAAECgYASvv35+fJNlj1F+HcR5wWEOok+zTiRSsDuMm6aECoTJvCd0K7DQA+Th0jWzovfCWwraYPyNhgYv7z3V2bC2pF6hOQoYkfR4OqUQG//0z4xWDXnNvRgjE7ZY9nDSUQN43ZVUPVHEzkA9sE1z8dLCfxL+OWkmqhTvZe3DHC7I9I1eQJBAP8nu+eRFMbJtb3U7Od2cfZ18b7ioGsFuQA+8YG3RQMX+cM/vOwB5ueHFmmofxq1lqwiYa1U4ifEKKDpS+A2rRcCQQDOm9z7N6pWsedxzRyv9Xj2BurPORVs82SS3qRC0ms7worGuWGpoQb3FpJqgOcHWG2NrmuTxiRQZPc1uaK/w/KXAkEAhG086xyzadD60IGYSzGASGhChc3dcG5R7Dy+35Ic8VQaPynvhZYfH39PNJtNDLG+d6yIgYuSrQz0AT/UL5RxFQJBAKkFXVyvB0zxMXQp5mQUnyY2NnXcLyj4XLjCJwL7fPpghoNYOQs6TqZo8tLqLRYXQ1h67krv99lFH+/1s6zJsnUCQAsvJwhEi+Or+WS0RlgXl1iOXf0NdVfFQ1LPW2v6xVFcR7RzXbFtVfDV4+7K3yuxQeoWzst/xLOYaEHrXcE33k4=";

    public static void main(String[] args) throws Exception {
        //生成公钥和私钥
//        Map keyMap=genKeyPair();
//        //加密字符串
//        System.out.println("随机生成的公钥为:" + keyMap.get("publicKey"));
//        System.out.println("随机生成的私钥为:" + keyMap.get("privateKey"));
        String s="admin123";
        String message=encrypt(s,PUBLIC_KEY_DEFAULT);
        System.out.println("加密字符串："+s+">>>"+message);

        //解密字符串
        String messageDe = decrypt(message, PRIVATE_KEY_DEFAULT);
        System.out.println("还原后的字符串为:" + messageDe);

//        String timestamp = messageDe.substring(0, 14);
//        String phone = messageDe.substring(14, 25);
//        String userId = messageDe.substring(25);
//        System.out.println(">>" + timestamp + ">>" + phone + ">>" + userId);

//        LocalDateTime l1= DateUtils.strToDateTime(timestamp,"yyyyMMddHHmmss");
//        LocalDateTime l2=LocalDateTime.now().minusSeconds(-60);
//        LocalDateTime l3=l2.minusSeconds(120);
//        System.out.println(">>"+l2+">>"+l3+">>>>>>"+l1.compareTo(l2));

    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, String> genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = Base64.encode(publicKey.getEncoded());
        // 得到私钥字符串
        String privateKeyString = Base64.encode((privateKey.getEncoded()));
        // 将公钥和私钥保存到Map
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("publicKey", publicKeyString);
        keyMap.put("privateKey", privateKeyString);
        return keyMap;
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String encrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decode(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encode(cipher.doFinal(str.getBytes("UTF-8")));
        return outStr;
    }

    /**
     * RSA公钥加密
     * @param str 待加密字符
     * @return
     * @throws Exception
     */
    public static String encrypt(String str) throws Exception{
        return encrypt(str,PUBLIC_KEY_DEFAULT);
    }
    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String decrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decode(str);
        //base64编码的私钥
        byte[] decoded = Base64.decode(privateKey);
        RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }

    /**
     * 密码解密
     * @param str
     * @return
     * @throws Exception
     */
    public static String decrypt(String str) throws Exception{
        return decrypt(str,PRIVATE_KEY_DEFAULT);
    }
}
