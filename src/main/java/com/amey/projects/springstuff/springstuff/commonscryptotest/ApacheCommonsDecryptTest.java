package com.amey.projects.springstuff.springstuff.commonscryptotest;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.crypto.stream.CryptoInputStream;
import org.springframework.stereotype.Service;

@Service
public class ApacheCommonsDecryptTest {

	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("1234567890123456"), "AES");
	final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));
	Properties properties = new Properties();
	final String transform = "AES/CBC/PKCS5Padding";

	// Decryption with CryptoInputStream.

	public String Decrypt(byte[] text) throws Exception {
		InputStream inputStream = new ByteArrayInputStream(text);
		CryptoInputStream cis = new CryptoInputStream(transform, properties, inputStream, key, iv);
		byte[] decryptedData = new byte[1024];
		int decryptedLen = 0;
		int i;
		while ((i = cis.read(decryptedData, decryptedLen, decryptedData.length - decryptedLen)) > -1) {
			decryptedLen += i;
		}
		String decryptedText = new String(decryptedData, 0, decryptedLen, StandardCharsets.UTF_8);
		System.out.println("Decrypted: " + decryptedText);
		return decryptedText;
	}

	private static byte[] getUTF8Bytes(String input) {
		return input.getBytes(StandardCharsets.UTF_8);
	}

}
