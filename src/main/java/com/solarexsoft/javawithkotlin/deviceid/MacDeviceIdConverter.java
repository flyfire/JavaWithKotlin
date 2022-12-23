package com.solarexsoft.javawithkotlin.deviceid;

/*
 * Created by Solarex on 2022/12/23 16:29
 */
public class MacDeviceIdConverter {
    // deviceId = 41940961927720
    // mac-->28:22:23:24:25:26
    public static String getDeviceId(String mac) {
        String macReplaced = mac.replaceAll(":", "");
        System.out.println("mac replaced: " + macReplaced);
        byte[] data = ByteUtil.hexToBytes(macReplaced);
        String sData = new String(data);
        System.out.println("bytes data: " + sData);
        byte[] reversData = new byte[data.length];
        int index = 0;
        for (int i = data.length - 1; i >= 0; i--) {
            reversData[index] = data[i];
            index++;
        }
        String rData = new String(reversData);
        System.out.println("reversed data: " + rData);
        String toHex = ByteUtil.bytesToHex(reversData);
        System.out.println("to hex: " + toHex);
        String deviceId = String.valueOf(Long.parseLong(toHex, 16));
        return deviceId;
    }

    public static void main(String[] args) {
        String deviceId = getDeviceId("28:22:23:24:25:26");
        System.out.println("deviceId: " + deviceId);
        Long lD = Long.parseLong(deviceId);
        System.out.println("long deviceId: " + lD);
        String sD = Long.toString(lD, 16);
        System.out.println("hex long: " + sD);
        byte[] bD = ByteUtil.hexToBytes(sD);
        String bDStr = new String(bD);
        System.out.println("bdstr: " + bDStr);
        byte[] reversedData = new byte[bD.length];
        int index = 0;
        for (int i = bD.length - 1; i >= 0; i--) {
            reversedData[index] = bD[i];
            index++;
        }
        String reversedDataStr = new String(reversedData);
        System.out.println("reversedDataStr: " + reversedDataStr);
        String hexStr = ByteUtil.bytesToHex(reversedData);
        System.out.println("hex str: " + hexStr);
    }
}
