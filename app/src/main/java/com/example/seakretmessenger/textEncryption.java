package com.example.seakretmessenger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import static javax.crypto.Cipher.DECRYPT_MODE;
import static javax.crypto.Cipher.ENCRYPT_MODE;

/*
*
* Encrypts or Decrypts the given message using the specified key
*
* Possible Exceptions:
*   import javax.crypto.IllegalBlockSizeException;
*   import javax.crypto.BadPaddingException;
*   import java.security.InvalidKeyException;
*   import java.security.NoSuchAlgorithmException;
* */


final class textEncryption {

    //Decryption not working
    static byte[] blowFishMessage(String message, boolean encrypt){
        assert message != null;
        int mode = encrypt ? ENCRYPT_MODE : DECRYPT_MODE;
        try{
            KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
            SecretKey sk = kg.generateKey(); //Hack set server and client keys
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(mode, sk);
            return cipher.doFinal(message.getBytes());
        }catch(Exception e){
            System.err.println(e.toString());
        }
        return null; //Fix
    }

    //Destroyed after rebase needs fixed.
    //Returns unaltered string if fails.
    static byte[] hashMD5(String message){
        final String hash = "35454B055CC325EA1AF2126E27707052";
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            byte[] digest = md.digest();
            return digest;
        } catch(NoSuchAlgorithmException e){
            System.err.println(e);
        }
        return null;
    }
}
