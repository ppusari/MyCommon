package com.ppusari.java.etc.xroshot.xroshot.auth;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.awt.*;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.ppusari.java.etc.xroshot.codec.Base64;

 
public class MCSAuth {

	public static byte[] encrypto1(byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        md.update(bytes);
        byte[] hashBytes = md.digest();
        printHEX(hashBytes);
        //System.out.println();
        byte[] derivedKey = CryptDeriveKey(hashBytes, "SHA1", 24);
        return derivedKey;
    }
 
	public static byte[] CryptDeriveKey(byte[] hBaseData, String hashAlgorithm, int requiredLength) {
        int keyLength = hBaseData.length;
        byte[] derivedKey = new byte[requiredLength];
        if(keyLength >= requiredLength) {
            for(int i = 0; i < requiredLength; i++) {
                derivedKey[i] = hBaseData[i];
            }
            return derivedKey;
        }
        byte[] buff1 = new byte[64];
        byte[] buff2 = new byte[64];
        Arrays.fill(buff1, (byte) 0x36);
        Arrays.fill(buff2, (byte) 0x5C);
        for(int i = 0; i < keyLength; i++) {
            buff1[i] ^= hBaseData[i];
            buff2[i] ^= hBaseData[i];
        }
        try {
            MessageDigest md = MessageDigest.getInstance(hashAlgorithm);
            md.reset();
            // use the named algorithm to hash those buffers
            byte[] result1 = md.digest(buff1);
            md.reset();
            byte[] result2 = md.digest(buff2);
            for(int i = 0; i < requiredLength; i++) {
                if(i < result1.length) {
                    derivedKey[i] = result1[i];
                }
                else {
                    derivedKey[i] = result2[i - result1.length];
                }
            }
        }
        catch(NoSuchAlgorithmException nsae) { }
        return derivedKey;
    }
	
	public static void printHEX(byte[] ba)
	{
	 byte c ;
	 for (int i =0;i<ba.length ; i++)
	 {
	  c = ba[i];
	  //System.out.format("%02X", c);
	 }
	}

	public static String encrypto2(byte[] data1, byte[] data2) throws Exception {
        byte[] enc1 = encrypto1(data2);
        SecretKeySpec sks = new SecretKeySpec(enc1, 0, 16, "AES");
        byte[] iv = new byte[16];
        IvParameterSpec ivps = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, sks, ivps);
        byte[] enc2 = cipher.doFinal(data1);
        
        printHEX(enc1);
        //System.out.println();
        printHEX(enc2);
        //System.out.println();
       
        String enc3 = Base64.encodeBytes(enc2);

        return new String(enc3);
    }
	
	public static String decrypto2(String data, byte[] key) throws Exception {
        byte[] encKey = encrypto1(key);
        
        byte[] decData = Base64.decode(data);
        
        printHEX(decData);
        //System.out.println();
        
        SecretKeySpec sks = new SecretKeySpec(encKey, 0, 16, "AES");
        byte[] iv = new byte[16];
        IvParameterSpec ivps = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, sks, ivps);
        byte[] dec1 = cipher.doFinal(decData);
        
        printHEX(encKey);
        //System.out.println();
        printHEX(dec1);
        //System.out.println();
       
        return new String(dec1);
    }
	
//	/**
//	 * @param args
//	 * @throws Exception 
//	 */
//	public static void main(String[] args) throws Exception {
//		// TODO Auto-generated method stub
//
//		//encrypt
//		String bufkey = "1koqCRaNlI5rbvKIsRz85FXJIYeQlrAtzODdgmSiU0NWyIGR1N4t2Ts8ifdXv9zuRh4YluE8RM1T3I8Mabb9Odl4r5uTXWSovCyHZE0vBPNDrQXodARh4S9gpHtW272Z";
//		String buf = "serviceprovidertest|test|serviceprovidertest|20120424134935|onetimekey";
//		String token = encrypto2(buf.getBytes(), bufkey.getBytes());
//		System.out.println(token);
//		
//		//decrypt
//		//token = "uxCDUX5PUk0c9TORing4ZUpIuxok3xNJUIxBO4aWIByyBdyA2cvLU+rJaq5N6BzSdKMF3hoR9M3oBUazvNTFw1cwS9GQC1ahUfUrS0b4+54=";
//		//bufkey = "ontimescretkey";
//		String dec = decrypto2(token, bufkey.getBytes());
//		System.out.println(dec);
//		return;
//	}
	
	public String makeCryptograph_EUC_KR(String data, String authKeyValue){
		String token = "";
		
		try {			
			token = encrypto2(data.getBytes("EUC-KR"), authKeyValue.getBytes());	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return token;
	}
	
	public String makeCryptograph(String data, String authKeyValue){
		
		String token = "";
		
		try {			
			token = encrypto2(data.getBytes(), authKeyValue.getBytes());	
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		return token;
	} 
 
}