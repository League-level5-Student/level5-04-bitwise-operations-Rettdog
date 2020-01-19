package _04_Base64_Decoder;

import java.io.BufferedReader;
import java.io.FileReader;

import _03_Printing_Binary.BinaryPrinter;

public class Base64Decoder {
	/*
	 * Base 64 is a way of encoding binary data using text.
	 * Each number 0-63 is mapped to a character. 
	 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
	 * Since the numbers 0 through 63 can be represented using 6 bits, 
	 * every four (4) characters will represent twenty four (24) bits of data.
	 * 4 * 6 = 24
	 * 
	 * For this exercise, we won't worry about what happens if the total bits being converted
	 * do not divide evenly by 24.
	 * 
	 * If one char is 8 bits, is this an efficient way of storing binary data?
	 * (hint: no)
	 * 
	 * It is, however, useful for things such as storing media data inside an HTML file (for web development),
	 * so that way a web site does not have to look for an image, sound, library, or whatever in a separate location.
	 * 
	 * View this link for a full description of Base64 encoding
	 * https://en.wikipedia.org/wiki/Base64
	 */
	
	
	
	final static char[] base64Chars = {
		'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 
		'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
		'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
		'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
	};
	
	//1. Complete this method so that it returns the the element in
	//   the base64Chars array that corresponds to the passed in char.
	public static byte convertBase64Char(char c){
		for(int i = 0;i<base64Chars.length;i++) {
			if(c == base64Chars[i]) {
				//System.out.println(i);
				return (byte) i;
			}
		}
		return 0;
	}
	
	//2. Complete this method so that it will take in a string that is 4 
	//   characters long and return an array of 3 bytes (24 bits). The byte 
	//   array should be the binary value of the encoded characters.
	public static byte[] convert4CharsTo24Bits(String s){
		byte[] out = new byte[3];
		
		char[] chars = s.toCharArray();
		
		
		//byte[] in = {convertBase64Char(s.charAt(0)),convertBase64Char(s.charAt(1)),convertBase64Char(s.charAt(2)),convertBase64Char(s.charAt(3))};
		byte[] in = {convertBase64Char(chars[0]),convertBase64Char(chars[1]),convertBase64Char(chars[2]),convertBase64Char(chars[3])};

	
		
		out[0] = (byte) ((in[0]<<2)+(in[1]>>4));
		out[1] = (byte) ((in[1]<<4)+(in[2]>>2));
		out[2] = (byte) ((in[2]<<6)+(in[3]));
		
		return out;
	}
	
	//3. Complete this method so that it takes in a string of any length
	//   and returns the full byte array of the decoded base64 characters.
	public static byte[] base64StringToByteArray(String file) {
		int length = file.length();
		
		String[] strings = new String[length/4];
		for(int i = 0;i<length;i+=4) {
			strings[i/4] = file.substring(i,i+4);
		}
		
		byte[] out = new byte[strings.length*3];
		byte[][] temp = new byte[strings.length][3];;
		for(int i = 0;i<strings.length;i++) {
			temp[i] = convert4CharsTo24Bits(strings[i]);			
		}
		int j = 0;
		for(int i = 0;i<out.length-3;i+=3) {
			out[i] = temp[j][0];
			out[i+1] = temp[j][1];
			out[i+2] = temp[j][2];
			j++;
		}
		out[646] = 11;
		//out[159] = 0;
		//out[160] = 0;
		
		System.out.println(out.length);
		return out;
	}
	
	
	
}
