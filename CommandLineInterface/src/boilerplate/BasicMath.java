package boilerplate;

import java.math.BigDecimal;

//Assignment 2: Add a Basic Math Library
public class BasicMath {
	public static int add(int a, int b) {
		return a + b;
	}

	public static float add(float a, float b) {
		return a + b;
	}

	public static double add(double a, double b) {
		return a + b;
	}

	public static int sub(int amount, int from) {
		// i can also
		// return amount - from;
		// but here i do a math trick, reverse the sign and reuse my add method
		// return add(from * -1, amount);
		return amount - from;
	}

	public static float sub(float amount, float from) {
		// i can also
		// return amount - from;
		// but here i do a math trick, reverse the sign and reuse my add method
		return add(from * -1, amount);
	}

	public static double sub(double amount, double from) {
		// i can also
		// return amount - from;
		// but here i do a math trick, reverse the sign and reuse my add method
		return add(from * -1, amount);
	}

	public static int mul(int amount, int by) {

		// return amount * by;
		// checking for overflow
		long m = ((long) amount) * ((long) by);
		if (m < Integer.MIN_VALUE || m > Integer.MAX_VALUE) {
			throw new ArithmeticException("overflow int: mul");
		}
		return (int) m;

	}

	public static float mul(float amount, float by) {
		// to have preciosion need to use BigDecimal
		// we can't do this
		//return amount * by; 
		BigDecimal a = new BigDecimal(amount);
		BigDecimal b = new BigDecimal(by);
		
		double m = a.multiply(b).doubleValue();
		if (m < Float.MIN_VALUE || m > Float.MAX_VALUE) {
			throw new ArithmeticException("overflow float: mul");
		}
		return a.multiply(b).floatValue();
	}

	public static double mul(double amount, double by) {
		BigDecimal a = new BigDecimal(amount);
		BigDecimal b = new BigDecimal(by);
		
		return a.multiply(b).floatValue();
	}

	public static int div(int amount, int by) {
		return amount / by;
	}

	public static float div(float amount, float by) {
		// return amount / by;
		BigDecimal a = new BigDecimal(amount);
		BigDecimal b = new BigDecimal(by);
		
		return a.divide(b).floatValue();
	}

	public static double div(double amount, double by) {
		// return amount / by;
		BigDecimal a = new BigDecimal(amount);
		BigDecimal b = new BigDecimal(by);
		
		return a.divide(b).doubleValue();
	}

}
