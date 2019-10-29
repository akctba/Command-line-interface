package ca.ciccc.kayser.boilerplate;

import java.util.Scanner;

public class Keyboard {

	Scanner scanner = new Scanner(System.in);

	public boolean nextBoolean() {
		return scanner.hasNextBoolean();
	}// Reads a boolean value from the user

	public byte nextByte() {
		return scanner.nextByte();
	} // Reads a byte value from the user

	public double nextDouble() {
		return scanner.nextDouble();
	}// Reads a double value from the user

	public float nextFloat() {
		return scanner.nextFloat();
	}// Reads a float value from the user

	public int nextInt() {
		return scanner.nextInt();
	} // Reads a int value from the user

	public String nextLine() {
		return scanner.nextLine();
	}// Reads a String value from the user

	public long nextLong() {
		return scanner.nextLong();
	}// Reads a long value from the user

	public short nextShort() {
		return scanner.nextShort();
	}// Reads a short value from the user

	public boolean hasNext() {
		return scanner.hasNext();
	} // returns if there is input waiting

}
