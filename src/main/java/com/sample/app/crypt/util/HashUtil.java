package com.sample.app.crypt.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.sample.app.model.Block;

public class HashUtil {
	private static final char[] HEXDIGITS = "0123456789ABCDEF".toCharArray();

	public static void update(Block block) {

		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		String hashCode = block.getPreviousBlockHashCode();

		Date date = new Date();
		block.setTimeStamp(date.getTime());
		long time = date.getTime();

		String transactionalData = block.getTransactionalData();

		String finalData = hashCode + transactionalData + time;

		messageDigest.update(finalData.getBytes());

		byte[] digest = messageDigest.digest();

		block.setHashCode(toHexString(digest));

	}

	private static String toHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder(bytes.length * 3);
		for (int b : bytes) {
			b &= 0xff;
			sb.append(HEXDIGITS[b >> 4]);
			sb.append(HEXDIGITS[b & 15]);
			// sb.append(' ');
		}
		return sb.toString();
	}

}
