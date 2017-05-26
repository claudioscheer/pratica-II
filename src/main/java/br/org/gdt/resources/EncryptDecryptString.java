/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.gdt.resources;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author Alisson Allebrandt
 */
public class EncryptDecryptString {

    public  String encrypt(String strClearText,String strKey) throws Exception{
    String strData= "";

    try {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
        byte[] encrypted=cipher.doFinal(strClearText.getBytes());
        strData=new String(encrypted);

    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e);
    }
    return strData;
}
    
    
    public  String decrypt(String strEncrypted,String strKey) throws Exception{
    String strData="";

    try {
        SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
        Cipher cipher=Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, skeyspec);
        byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
        strData=new String(decrypted);

    } catch (Exception e) {
        e.printStackTrace();
        throw new Exception(e);
    }
    return strData;
}

}
