package com.solarexsoft.javawithkotlin.deviceid;


public class ByteUtil {
	private static final char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	public static String bytesToHex(byte[] bytes) {
		return bytesToHex(bytes, 0, bytes.length);
	}

	public static String bytesToHex(byte[] bytes, int start, int end) {
		char[] buf = new char[(end - start) * 2];
		int index = 0;
		for (int i = start; i < end; i++) {
			byte b = bytes[i];
			buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
			buf[index++] = HEX_CHAR[b & 0xf];
		}
		return new String(buf);
	}

	public static byte[] hexToBytes(String hex) {
		byte[] data = new byte[hex.length() / 2];
		int i = 0;
		while (hex.length() > 0) {
			data[i] = Integer.valueOf(hex.substring(0, 2), 16).byteValue();
			hex = hex.substring(2, hex.length());
			i++;
		}
		return data;
	}

	public static int byteToInteger(byte data) {
		return Integer.parseInt(bytesToHex(new byte[] { data }), 16);
	}

	public static int getTowByteInt(byte byteHigh, byte byteLow) {
		int high = ByteUtil.byteToInteger(byteHigh);
		int low = ByteUtil.byteToInteger(byteLow);
		return (high << 8 | low & 0xFF);
	}

	public static byte[] unsignedShortToByte(int s) {
		byte[] targets = new byte[2];
		targets[0] = (byte) (s >> 8 & 0xFF);
		targets[1] = (byte) (s & 0xFF);
		return targets;
	}

	public static String getCheckSum(String data) {
		int total = 0;
		int len = data.length();
		int num = 0;
		while (num < len) {
			String s = data.substring(num, num + 2);
			total += Integer.parseInt(s, 16);
			num = num + 2;
		}
		int mod = total % 256;
		String hex = Integer.toHexString(mod);
		len = hex.length();
		if (len < 2) {
			hex = "0" + hex;
		}
		return hex.toUpperCase();
	}

	public static byte[] convertToASCII(String string) {
		char[] ch = string.toCharArray();
		byte[] tmp = new byte[ch.length];
		for (int i = 0; i < ch.length; i++) {
			tmp[i] = (byte) Integer.valueOf(ch[i]).intValue();
		}
		return tmp;
	}

	public static String asciiToString(String value) {
		StringBuffer sbu = new StringBuffer();
		String[] chars = value.split(",");
		for (int i = 0; i < chars.length; i++) {
			sbu.append((char) Integer.parseInt(chars[i]));
		}
		return sbu.toString();
	}

}
