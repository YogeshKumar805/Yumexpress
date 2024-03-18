/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.utill;

import java.util.Base64;

/**
 *
 * @author JASRAJ
 */
public class PasswordEncryption {
    
    public static String getEncryptedPassword(String pwd){
        Base64.Encoder en= Base64.getEncoder();//Base64 Class contain two classes 1.Encoder ,2.Decoder
        String encryptedpwd=en.encodeToString(pwd.getBytes());//getBytes() is the method of String class wich convert the String into Byte array
        return encryptedpwd;
    }
    
    public static String getDecryptedPassword(String pwd){
      Base64.Decoder dec =Base64.getDecoder();
      byte[]arr=dec.decode(pwd.getBytes());
      String decryptedpwd=new String(arr);
      return decryptedpwd;
    }
    
    public static void main(String[] args) {
        System.out.println(getDecryptedPassword("aGVsbG8="));
    }
    
}
