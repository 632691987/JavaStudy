package jdk21.key;

import javax.crypto.DecapsulateException;
import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class ReceiverTry {

    public static void main(String[] args) throws Exception {
        // 生成密钥对
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("X25519");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        var publicKey = keyPair.getPublic();
        var privateKey = keyPair.getPrivate();

        // 模拟 Sender 封装密钥并加密消息
        Sender sender = new Sender();
        var encapsulated = sender.getEncapsulated(publicKey);
        SecretKey senderKey = encapsulated.key();
        String message = "Hello, this is a secure message!";
        byte[] encryptedMessage = sender.encryptMessage(message, senderKey);
        System.out.println("Encrypted Message: " + new String(encryptedMessage));

        // 模拟 Receiver 解封装密钥并解密消息
        Receiver receiver = new Receiver();
        SecretKey receiverKey = receiver.getKey(encapsulated, privateKey);
        String decryptedMessage = receiver.decryptMessage(encryptedMessage, receiverKey);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }

}