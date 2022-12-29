package com.iqvia.bhc.tab.utils;

import java.io.UnsupportedEncodingException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.util.Base64Utils;

public class MD5Utils {
	
	/**Determine encrypt algorithm MD5*/
	private static final String ALGORITHM_MD5 = "MD5";
	/**UTF-8 Encoding*/
	private static final String UTF_8 = "UTF-8";

	/**
	 * MD5 64bit Encrypt Methods.
	 * @param readyEncryptStr ready encrypt string
	 * @return String encrypt result string
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 * */
	public static final String MD5_64bit(String readyEncryptStr) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
//		return new String(md.digest(readyEncryptStr.getBytes(UTF_8)), UTF_8);
		return Base64Utils.encodeToString(md.digest(readyEncryptStr.getBytes(UTF_8)));
	}
}
