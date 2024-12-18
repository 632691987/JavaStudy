package jdk21.key;

import javax.crypto.Cipher;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

public class Sender {

    public KEM.Encapsulated getEncapsulated(PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException {
        final var kem = KEM.getInstance("DHKEM");
        final var encapsulator = kem.newEncapsulator(publicKey);
        return encapsulator.encapsulate();
    }

    public byte[] encryptMessage(String message, SecretKey key) throws Exception {
        // 将通用的 SecretKey 转换为 AES 专用的 SecretKey
        SecretKey aesKey = new SecretKeySpec(key.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
    }
}
