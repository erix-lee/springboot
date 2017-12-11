package com.app.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

	public static String getMd5(String mesg) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(mesg.getBytes());
			byte[] b = md.digest();

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				int i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			return buf.toString();
		} catch (NoSuchAlgorithmException e) {
			 e.printStackTrace();
		}

		return null;
	}

	public static byte[] getMd5(byte[] msg) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			 e.printStackTrace();
		}

		md.update(msg);

		byte[] b = md.digest();

		return b;
	}

	public static String buildMd5Stringg(byte[] btInput) {
		try {
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = md[i] & 0xFF;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));
			}
			return sb.toString();
		} catch (Exception e) {
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getMd5("message digest"));
	}
}
