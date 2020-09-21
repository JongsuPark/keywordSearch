package com.kakao.map.search.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {

	private static final String salt = "tempSalt43259";
	
	public static String encrypt(String source) {
		byte[] a = source.getBytes();
		byte[] b = salt.getBytes();
		byte[] before = new byte[a.length + b.length];
		System.arraycopy(a, 0, before, 0, a.length);
		System.arraycopy(b, 0, before, a.length, b.length);
		String result = "";		
		
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			
			md.update(before);
		    byte[] hash = md.digest();
		    
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			
			result = hexString.toString();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

	    return result;
	}
}
