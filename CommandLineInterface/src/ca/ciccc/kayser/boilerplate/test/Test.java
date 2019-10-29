package ca.ciccc.kayser.boilerplate.test;

import java.math.BigDecimal;

import boilerplate.BasicMath;
import ca.ciccc.kayser.boilerplate.Console;
import ca.ciccc.kayser.boilerplate.Debug;

public class Test {

	public static void Test_Console_RunAll() {

		Test_Console_NewLine();
		Test_Console_Print();
		Test_Console_PrintLn();
		Test_Console_repeatChar();
		test_Console_repeatStr();
	}

	public static void Test_MathRunAll(boolean onlyFail) {
		test_MathAdd(onlyFail);
		test_MathSub(onlyFail);
		test_MathMul(onlyFail);
		test_MathDiv(onlyFail);
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

	public static void test_Console_repeatStr() {
		for (int i = 0; i < 10; i++) {
			Debug.logInfo("Test_Console_repeatStr() - Test " + i + " will print " + i);
			Console.repeatStr(i, "\tTest: " + i);
		}

	}

	public static void test_MathAdd(boolean onlyFail) {
		test_MathAddInt(onlyFail);
		test_MathAddFloat(onlyFail);
		test_MathAddDouble(onlyFail);
	}

	public static void test_MathSub(boolean onlyFail) {
		test_MathSubInt(onlyFail);
		test_MathSubFloat(onlyFail);
		test_MathSubDouble(onlyFail);
	}

	public static void test_MathMul(boolean onlyFail) {
		test_MathMulInt(onlyFail);
		test_MathMulFloat(onlyFail);
		test_MathMulDouble(onlyFail);
	}

	public static void test_MathDiv(boolean onlyFail) {
		test_MathDivInt(onlyFail);
		test_MathDivFloat(onlyFail);
		test_MathDivDouble(onlyFail);
	}

	/* ------ DOUBLE --------- */

	public static void test_MathAddDouble(boolean onlyFail) {
//		// theory is = we set two values, a and b
//		float float_a = (float) 1.5;
//		float float_b = (float) 1.5;
//
//		// get java to add them together and get a result
//		float float_result = float_a + float_b; // result will be 2

		int max_num = 100;
		// lets choose an upper bounds for the test,
		// so that our program doesn't take FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// creating decimals
				BigDecimal fA = new BigDecimal(numA);
				BigDecimal fB = new BigDecimal(numB);

				// lets get java to calculate the result first,
				double float_result = fA.add(fB).doubleValue();
				// now lets compare it to our BasicMath.Add method
				if (float_result == BasicMath.add(fA.doubleValue(), fB.doubleValue())) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Add: " + fA.doubleValue() + " + " + fB.doubleValue() + " = " + float_result
								+ " - PASS");
				} else {
					Debug.logInfo("Add: " + fA.doubleValue() + " + " + fB.doubleValue() + " = " + float_result
							+ " - FAIL <<<<<<<<<  ");
				}
			}
		}
		
		Debug.logInfo("test_MathAddDouble finish");

	}

	public static void test_MathSubDouble(boolean onlyFail) {
		double double_result = 0;
		int max_num = 100;
		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				
				BigDecimal fA = new BigDecimal(numA);
				BigDecimal fB = new BigDecimal(numB);

				// lets get java to calculate the result first,
				double_result = fA.subtract(fB).doubleValue();
				// now lets compare it to our BasicMath.Sub method
				if (double_result == BasicMath.sub(fA.doubleValue(), fB.doubleValue())) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Sub: " + fA.doubleValue() + " - " + fB.doubleValue() + " = " + double_result
								+ " - PASS");
				} else {
					Debug.logInfo("Sub: " + fA.doubleValue() + " - " + fB.doubleValue() + " = " + double_result
							+ " - FAIL <<<<<<<<<  ");
				}
			}
		}
		
		Debug.logInfo("test_MathSubDouble finish");

	}

	public static void test_MathMulDouble(boolean onlyFail) {
		double double_result = 0;
		int max_num = 100;
		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				
				BigDecimal fA = new BigDecimal(numA);
				BigDecimal fB = new BigDecimal(numB);

				// lets get java to calculate the result first,
				double_result = fA.multiply(fB).doubleValue();
				// now lets compare it to our BasicMath.Sub method
				if (double_result == BasicMath.mul(fA.doubleValue(), fB.doubleValue())) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Mul: " + fA.doubleValue() + " - " + fB.doubleValue() + " = " + double_result
								+ " - PASS");
				} else {
					Debug.logInfo("Mul: " + fA.doubleValue() + " - " + fB.doubleValue() + " = " + double_result
							+ " - FAIL <<<<<<<<<  ");
				}
			}
		}
		
		Debug.logInfo("test_MathMulDouble finish");

	}

	public static void test_MathDivDouble(boolean onlyFail) {
		double double_result = 0;
		int max_num = 100;

		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 1; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 1; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				BigDecimal fA = new BigDecimal(numA);
				BigDecimal fB = new BigDecimal(numB);
				try {

					double_result = fA.divide(fB).doubleValue();

					// now lets compare it to our BasicMath.Sub method
					if (double_result == BasicMath.div(fA.doubleValue(), fB.doubleValue())) {
						// we have a match, PASS
						if (!onlyFail)
							Debug.logInfo("Div: " + fA.doubleValue() + " / " + fB.doubleValue() + " = " + double_result
									+ " - PASS");
					} else {
						Debug.logInfo("Div: " + fA.doubleValue() + " / " + fB.doubleValue() + " = " + double_result
								+ " - FAIL <<<<<<<<<  ");
					}
				} catch (Exception e) {
					Debug.logInfo("Double Div " + fA.doubleValue() +" / " + fB.doubleValue() + " - " + e.getMessage());
				}
			}
		}
		
		Debug.logInfo("test_MathDivDouble finish");
	}

	/* ------ FLOAT ---------- */

	public static void test_MathAddFloat(boolean onlyFail) {
//		// theory is = we set two values, a and b
//		float float_a = (float) 1.5;
//		float float_b = (float) 1.5;
//
//		// get java to add them together and get a result
//		float float_result = float_a + float_b; // result will be 2

		int max_num = 100;
		// lets choose an upper bounds for the test,
		// so that our program doesn't take FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// creating decimals
				BigDecimal fA = new BigDecimal(numA / 10);
				BigDecimal fB = new BigDecimal(numB / 10);

				// lets get java to calculate the result first,
				float float_result = fA.add(fB).floatValue();
				// now lets compare it to our BasicMath.Add method
				if (float_result == BasicMath.add(fA.floatValue(), fB.floatValue())) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo(
								"Add: " + fA.floatValue() + " + " + fB.floatValue() + " = " + float_result + " - PASS");
				} else {
					Debug.logInfo("Add: " + fA.floatValue() + " + " + fB.floatValue() + " = " + float_result
							+ " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathAddFloat finish");
	}

	public static void test_MathSubFloat(boolean onlyFail) {
		float float_result = 0;
		int max_num = 100;
		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// creating decimals
				BigDecimal fA = new BigDecimal(numA / 10);
				BigDecimal fB = new BigDecimal(numB / 10);

				// lets get java to calculate the result first,
				float_result = fA.subtract(fB).floatValue();
				// now lets compare it to our BasicMath.Sub method
				if (float_result == BasicMath.sub(fA.floatValue(), fB.floatValue())) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo(
								"Sub: " + fA.floatValue() + " - " + fB.floatValue() + " = " + float_result + " - PASS");
				} else {
					Debug.logInfo("Sub: " + fA.floatValue() + " - " + fB.floatValue() + " = " + float_result
							+ " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathSubFloat finish");
	}

	public static void test_MathMulFloat(boolean onlyFail) {
		float float_result = 0;
		int max_num = 100;
		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				float_result = numA * numB;
				// now lets compare it to our BasicMath.Sub method
				if (float_result == BasicMath.mul(numB, numA)) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Mul: " + numB + " * " + numA + " = " + float_result + " - PASS");
				} else {
					Debug.logInfo("Mul: " + numB + " * " + numA + " = " + float_result + " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathMulFloat finish");
	}

	public static void test_MathDivFloat(boolean onlyFail) {
		float float_result = 0;
		int max_num = 100;

		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 1; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 1; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				BigDecimal fA = new BigDecimal(numA / 10);
				BigDecimal fB = new BigDecimal(numB / 10);
				try {

					float_result = fA.divide(fB).floatValue();

					// now lets compare it to our BasicMath.Sub method
					if (float_result == BasicMath.div(fA.floatValue(), fB.floatValue())) {
						// we have a match, PASS
						if (!onlyFail)
							Debug.logInfo(
									"Float Div: " + fA.floatValue() + " / " + fB.floatValue() + " = " + float_result + " - PASS");
					} else {
						Debug.logInfo("Float Div: " + fA.floatValue() + " / " + fB.floatValue() + " = " + float_result
								+ " - FAIL <<<<<<<<<  ");
					}
				} catch (Exception e) {
					Debug.logInfo("Float Div " + fA.floatValue() +" / " + fB.floatValue() +" - " + e.getMessage());
				}
			}
		}
		Debug.logInfo("test_MathDivFloat finish");
	}

	/* ------- INT ------- */

	public static void test_MathAddInt(boolean onlyFail) {
		// theory is = we set two values, a and b
		int int_a = 1;
		int int_b = 1;

		// get java to add them together and get a result
		int int_result = int_a + int_b; // result will be 2

		// then compare that result with the result returned from out own method in
		// BasicMath.java
		if (BasicMath.add(int_a, int_b) == int_result) {
			// if we are a math, then the test was a success! our method is good!
		} else {
			// we have a difference of opinion, our calculation doesn't match that of
			// java's! - something must be wrong!
		}

		int max_num = 100;
		// lets choose an upper bounds for the test,
		// so that our program doesn't take FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA + numB;
				// now lets compare it to our BasicMath.Add method
				if (int_result == BasicMath.add(numA, numB)) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Add: " + numA + " + " + numB + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Add: " + numA + " + " + numB + " = " + int_result + " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathAddInt finish");
	}

	public static void test_MathSubInt(boolean onlyFail) {
		int int_result = 0;
		int max_num = 100;
		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA - numB;
				// now lets compare it to our BasicMath.Sub method
				if (int_result == BasicMath.sub(numA, numB)) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Sub: " + numA + " - " + numB + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Sub: " + numA + " - " + numB + " = " + int_result + " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathSubInt finish");
	}

	public static void test_MathMulInt(boolean onlyFail) {
		int int_result = 0;
		int max_num = 100;
		// lets choose an upper bounds for the test, so that our program doesn't take
		// FOREVER

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 0; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 0; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA * numB;
				// now lets compare it to our BasicMath.Sub method
				if (int_result == BasicMath.mul(numB, numA) == true) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Mul: " + numB + " * " + numA + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Mul: " + numB + " * " + numA + " = " + int_result + " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathMulInt finish");
	}

	public static void test_MathDivInt(boolean onlyFail) {
		int int_result = 0;
		int max_num = 100;

		// lets test for ints

		// lets create a loop that will choose a number for A - starting from 0 and
		// going to 100
		for (int numA = 1; numA < max_num; numA++) {
			// lets create a loop that will choose a number for B - starting from 0 and
			// going to 1000
			for (int numB = 1; numB < max_num; numB++) {
				// lets get java to calculate the result first,
				int_result = numA / numB;
				// now lets compare it to our BasicMath.Sub method
				if (int_result == BasicMath.div(numA, numB) == true) {
					// we have a match, PASS
					if (!onlyFail)
						Debug.logInfo("Div: " + numA + " * " + numB + " = " + int_result + " - PASS");
				} else {
					Debug.logInfo("Div: " + numA + " * " + numB + " = " + int_result + " - FAIL <<<<<<<<<  ");
				}
			}
		}
		Debug.logInfo("test_MathDivInt finish");
	}

}
