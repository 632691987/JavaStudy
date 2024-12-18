package jdk21.key;

import javax.crypto.Cipher;
import javax.crypto.DecapsulateException;
import javax.crypto.KEM;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;

public class Receiver {

    public SecretKey getKey(KEM.Encapsulated encapsulated, PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeyException, DecapsulateException {
        final var kem = KEM.getInstance("DHKEM");
        final var decapsulator = kem.newDecapsulator(privateKey);
        return decapsulator.decapsulate(encapsulated.encapsulation());
    }

    public String decryptMessage(byte[] encryptedMessage, SecretKey key) throws Exception {
        // 将通用的 SecretKey 转换为 AES 专用的 SecretKey
        SecretKey aesKey = new SecretKeySpec(key.getEncoded(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedMessage);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }
}
