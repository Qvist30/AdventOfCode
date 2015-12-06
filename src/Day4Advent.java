

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4Advent {
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static String string = "yzbqklnj";
	public static void main(String args[]) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("MD5");
		for(int i=0;i<Integer.MAX_VALUE; i++) {
			String appendedString = string + String.valueOf(i);
			if("00000".equals(bytesToHex(digest.digest(appendedString.getBytes())))) {
				System.out.println(i);
				break;
			}
		}
		
	}
	
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for ( int j = 0; j < 3; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars).substring(0, 5);
	}
}
