package com.randal.aviana;

public class ByteUtils {
    private ByteUtils(){}

    public static int byte2int_16bit(final byte[] bytes) {
        int a = (bytes[0] & 0xff) << 8;
        int b = (bytes[1] & 0xff);
        return a | b;
    }

    public static int byte2int_32bit(final byte[] bytes) {
        int a = (bytes[0] & 0xff) << 24;
        int b = (bytes[1] & 0xff) << 16;
        int c = (bytes[2] & 0xff) << 8;
        int d = (bytes[3] & 0xff);
        return a | b | c | d;
    }

    public static byte[] subBytes(final byte[] src, int begin, int count) {
        byte[] bs = new byte[count];
        for (int i = begin; i < begin + count; ++i) {
            bs[i-begin] = src[i];
        }
        return bs;
    }

    public static short HexString2Short(String str) {
        short retVal = -1;
        try {
            str = str.replaceAll("[-\\s.:]", "");
            retVal = Short.parseShort(str, 16);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public static int HexString2Int(String str) {
        int retVal = -1;
        try {
            str = str.replaceAll("[-\\s.:]", "");
            retVal = Integer.parseInt(str, 16);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public static long HexString2Long(String str) {
        long retVal = -1;
        try {
            str = str.replaceAll("[-\\s.:]", "");
            retVal = Long.parseLong(str, 16);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public static String Int2HexString(int n) {
        String retVal = Integer.toHexString(n);
        for (int len = retVal.length(); len < 2; ++len) {
            retVal = "0".concat(retVal);
        }
        return retVal;
    }

    public static String Long2HexString(long n) {
        String retVal = Long.toHexString(n);
        for (int len = retVal.length(); len < 2; ++len) {
            retVal = "0".concat(retVal);
        }
        return retVal;
    }

    public static void printBytes(byte[] bytes) {
        String printArray = "[";
        for (int i = 0; i < bytes.length; ++i) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            hex += " ";
            printArray += hex;
        }
        printArray = printArray.toUpperCase() + "]";
        LogUtils.d(printArray);
    }
}
