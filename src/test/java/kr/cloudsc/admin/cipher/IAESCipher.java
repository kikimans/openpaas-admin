package kr.cloudsc.admin.cipher;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

/*
 * Copyright jyes.co.kr.
 * All rights reserved
 * This software is the confidential and proprietary information
 * of jyes.co.kr. ("Confidential Information")
 */
public interface IAESCipher {
	String getEncodedSecretKey(SecretKey secretKey);
	SecretKey getDecodedSecretKey(String secretKey);
	String encrypt(String rawText, SecretKey secretKey1) throws InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException;
	String decrypt(String encryptedText, SecretKey secretKey1) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException;
	
	String getSecretKeyIssue() throws NoSuchAlgorithmException, InvalidKeySpecException;
}
