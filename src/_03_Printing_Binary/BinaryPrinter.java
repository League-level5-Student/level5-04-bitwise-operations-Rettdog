package _03_Printing_Binary;

public class BinaryPrinter {
	static //Complete the methods below so they print the passed in parameter in binary.
	//Use bit shifting and bit masking to print the binary numbers.
	//Do not use the Integer.toBinaryString method!
	//Don't be afraid to use the methods that are already complete to finish the others.
	//Create a main method to test your methods.
	BinaryPrinter bp;
	
	public static void main(String[] args) {
		bp = new BinaryPrinter();
		bp.printLongBinary((long)Long.MAX_VALUE);
	}
	
	public void printByteBinary(byte b) {
		/*
		String out = "";
		byte byt = (byte)0b10000000;
		byte[] testers = {(byte) 0b10000000,0b01000000,0b00100000,0b00010000,0b00001000,0b00000100,0b00000010,0b00000001};
		int length = 8;
		
		for(int i = 0;i<length;i++) {
			if(i==0) {
				System.out.println((testers[i]&b)>>length-i-1);
				out+="1";
			}else {
				
			}
			out+=((testers[i]&b)>>length-i-1);
				System.out.println(out);
		}
		System.out.println((testers[0]&b)>>7);
		System.out.println(out);
		*/
		System.out.print((0b10000000&b)>>7);
		System.out.print((0b01000000&b)>>6);
		System.out.print((0b00100000&b)>>5);
		System.out.print((0b00010000&b)>>4);
		System.out.print((0b00001000&b)>>3);
		System.out.print((0b00000100&b)>>2);
		System.out.print((0b00000010&b)>>1);
		System.out.print((0b00000001&b));
		
	}
	
	public void printShortBinary(short s) {
		//System.out.println(((s&0x00FF)));
		//System.out.println(((s&0xFF00)>>8));
		
		bp.printByteBinary((byte) ((s&0xFF00)>>8));
		bp.printByteBinary((byte) ((s&0x00FF)));
	}
	
	public void printIntBinary(int i) {
		bp.printShortBinary((short) ((i&0xFFFF0000)>>16));
		bp.printShortBinary((short) ((i&0x0000FFFF)));
	}
	
	public void printLongBinary(long l) {
		bp.printIntBinary((int) ((l)>>32));
		bp.printIntBinary((int) ((l&0x00000000FFFFFFFF)));
	}
}
