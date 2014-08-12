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
public class MockAESCipher implements IAESCipher {

	@Override
	public String getEncodedSecretKey(SecretKey secretKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecretKey getDecodedSecretKey(String secretKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encrypt(String rawText, SecretKey secretKey1)
			throws InvalidKeyException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		return "KRjM58F06DL1Oq2gFdUhjDX9ZbzLxPIF7ZIAy/P6w74=";
	}

	@Override
	public String decrypt(String encryptedText, SecretKey secretKey1)
			throws InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException {
		// TODO Auto-generated method stub
		return "alsgh@1716";
	}

	@Override
	public String getSecretKeyIssue() throws NoSuchAlgorithmException,
			InvalidKeySpecException {
		// TODO Auto-generated method stub
		return "46sZHabuHBoOIQkqyVowIA==";
	}

}
