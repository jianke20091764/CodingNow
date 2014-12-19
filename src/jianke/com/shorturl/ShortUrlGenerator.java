/*
 * 
 * 
 * */

package jianke.com.shorturl;

import java.security.MessageDigest;
import java.util.Random;
import java.util.Scanner;

public class ShortUrlGenerator {

	public final static String MD_KEY = "jianke";

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		String sLongUrl = "";
		while (cin.hasNext()) {
			sLongUrl = cin.next();
			System.out.println("长链接:" + sLongUrl);
			String[] aResult = shortUrl(sLongUrl);
			for (int i = 0; i < aResult.length; i++) {
				System.out.println("[" + i + "]:" + aResult[i]);
			}
			Random random = new Random();
			int j = random.nextInt(4); // 产成4以内随机数
			System.out.println("短链接:" + aResult[j]);// 随机取一个作为短链
		}
	}

	public static String[] shortUrl(String url) {
		String[] chars = new String[] { "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
				"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };

		String hex = md5ByHex(MD_KEY + url);

		String[] resUrl = new String[4];
		for (int i = 0; i < 4; i++) {

			// 把加密字符按照 8 位一组 16 进制与 0x3FFFFFFF 进行位与运算
			String sTempSubString = hex.substring(i * 8, i * 8 + 8), outChars = "";
			long lHexLong = 0x3FFFFFFF & Long.parseLong(sTempSubString, 16), index;
			for (int j = 0; j < 6; j++) {
				index = 0x0000003D & lHexLong;
				outChars += chars[(int) index];
				lHexLong = lHexLong >> 5;
			}

			resUrl[i] = outChars;
		}
		return resUrl;
	}

	/**
	 * MD5加密(32位大写)
	 * 
	 */
	public static String md5ByHex(String src) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] b = src.getBytes();
			md.reset();
			md.update(b);
			byte[] hash = md.digest();
			String hs = "", stmp = "";
			for (int i = 0; i < hash.length; i++) {
				stmp = Integer.toHexString(hash[i] & 0xFF);
				if (stmp.length() == 1)
					hs = hs + "0" + stmp;
				else {
					hs = hs + stmp;
				}
			}

			System.out.println(hs.toLowerCase());
			return hs.toUpperCase();
		} catch (Exception e) {
			return "";
		}
	}

}
