package labbook1;

public class Q3 {

	public static void main(String[] args) {
		
		int i = 50;
		byte b = 10;
		short s = 5;
		char a = 'a';
		String str = "Str";
		float f = 5.5f;
		double d = 33.33;
		
		long doubleToLong = (long) d;
		int longToInt = (int) doubleToLong;
		long intToShort = (short) longToInt;
		float shortToByte = (byte) intToShort;
		
		short byteToShort = s;
		int shortToInt = byteToShort;
		long intToLong = shortToInt;
		float longToFloat = intToLong;
		
	
		char ch = 'z';
		int num = 999;
		char chara = (char)num;
		int numch = ((int)ch);

	}
	
}
