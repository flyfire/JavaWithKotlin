package com.solarexsoft.javawithkotlin.deviceid;

import java.util.Scanner;

/*
 * Created by Solarex on 2022/12/23 17:13
 */
public class DeviceId2Mac {
    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
            'F'};

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

    public static String deviceId2Mac(String deviceId) {
        Long longDeviceId = Long.parseLong(deviceId);
        String hexDeviceId = Long.toString(longDeviceId, 16);
        byte[] bD = ByteUtil.hexToBytes(hexDeviceId);
        byte[] reversedData = new byte[bD.length];
        int index = 0;
        for (int i = bD.length - 1; i >= 0; i--) {
            reversedData[index] = bD[i];
            index++;
        }
        String reversedStr = bytesToHex(reversedData);
        return reversedStr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input deviceid: ");
        String deviceId = scanner.nextLine();
        System.out.println("your input is: " + deviceId + ",transforming...");
        String mac = deviceId2Mac(deviceId);
        System.out.println("mac address: " + mac);
    }
}
