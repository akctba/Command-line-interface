package ca.ciccc.kayser.boilerplate.test;

import ca.ciccc.kayser.boilerplate.BasicMath;
import ca.ciccc.kayser.boilerplate.Console;
import ca.ciccc.kayser.boilerplate.Debug;

public class Test {

	public static void Test_Console_RunAll() {

		Test_Console_NewLine();
		Test_Console_Print();
		Test_Console_PrintLn();
		Test_Console_repeatChar();
		Test_Console_repeatStr();
	}

	public static void Test_MathRunAll() {
		Test_MathAdd();
		Test_MathSub();
		Test_MathMul();
		Test_MathDiv();
	}

	public static void Test_Console_NewLine() {
		for (int i = 0; i < 10; i++) {
			Debug.logInfo("Test_Console_NewLine() - Test " + i + " - Printing " + i + " newLines");
			Console.newLine(i);
		}
	}

	public static void Test_Console_Print() {
		for (int i = 0; i < 10; i++) {
			Debug.logInfo("Test_Console_Print() - Test " + i);
			Console.print("\tTest: " + i);
		}
	}

	public static void Test_Console_PrintLn() {
		for (int i = 0; i < 10; i++) {
			Debug.logInfo("Test_Console_PrintLn() - Test " + i);
			Console.println("\tTest: " + i);
		}
	}

	public static void Test_Console_repeatChar() {
		for (int i = 0; i < 10; i++) {
			Debug.logInfo("Test_Console_repeatChar() - Test " + i + " will print via type casting " + i
					+ " to its char equvilent");
			Console.repeatChar(i, (char) i);
		}
	}

	public static void Test_Console_repeatStr() {
		for (int i = 0; i < 10; i++) {
			Debug.logInfo("Test_Console_repeatStr() - Test " + i + " will print " + i);
			Console.repeatStr(i, "\tTest: " + i);
		}

	}

	public static void Test_MathAdd() {
		// theory is = we set two values, a and b
		int int_a = 1;
		int int_b = 1;

		// get java to add them together and get a result
		int int_result = int_a + int_b; // result will be 2

		// then compare that result with the result returned from out own method in BasicMath.java		
		if (BasicMath.add(int_a, int_b) == int_result) {
			// if we are a math, then the test was a success! our method is good!
		} else {
			// we have a difference of opinion, our calculation doesn't match that of
			// java's! - something must be wrong!
		}

		int max_num = 100; // lets choose an upper bounds for the test, so that our program doesn't take
							// FOREVER

		// lets test for ints
		
		// lets create a loop that will choose a number for A - starting from 0 and going to 100	
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA + numB;
				// now lets compare it to our BasicMath.Add method
				if (int_result == BasicMath.add(numA, numB) == true) {
					// we have a match, PASS
					Debug.logInfo("Add: " + numA + " + " + numB + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Add: " + numA + " + " + numB + " = " + int_result + " - FAIL");
				}
			}
		}

	}

	public static void Test_MathSub() {
		int int_result = 0;
		int max_num = 100; 
		// lets choose an upper bounds for the test, so that our program doesn't take
							// FOREVER

		// lets test for ints
		
		// lets create a loop that will choose a number for A - starting from 0 and going to 100	
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA - numB;
				// now lets compare it to our BasicMath.Sub method
				if (int_result == BasicMath.sub(numA, numB) == true) {
					// we have a match, PASS
					Debug.logInfo("Sub: " + numA + " - " + numB + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Sub: " + numA + " - " + numB + " = " + int_result + " - FAIL");
				}
			}
		}

	}

	public static void Test_MathMul() {
		int int_result = 0;
		int max_num = 100; 
		// lets choose an upper bounds for the test, so that our program doesn't take
							// FOREVER

		// lets test for ints
		
		// lets create a loop that will choose a number for A - starting from 0 and going to 100	
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA * numB;
				// now lets compare it to our BasicMath.Sub method
				if (int_result == BasicMath.mul(numB, numA) == true) {
					// we have a match, PASS
					Debug.logInfo("Mul: " + numB + " * " + numA + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Muk: " + numB + " * " + numA + " = " + int_result + " - FAIL");
				}
			}
		}

	}

	public static void Test_MathDiv() {
		int int_result = 0;
		int max_num = 100;

		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints
		
		// lets create a loop that will choose a number for A - starting from 0 and going to 100	
		for (int numA = 1; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 1; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA / numB;
				// now lets compare it to our BasicMath.Sub method
				if (int_result == BasicMath.div(numA, numB) == true) {
					// we have a match, PASS
					Debug.logInfo("Mul: " + numA + " * " + numB + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Muk: " + numA + " * " + numB + " = " + int_result + " - FAIL");
				}
			}
		}

	}

}
