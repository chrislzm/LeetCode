/**
 * Tests a method with int[] array input and int[] array output.
 * Loads the test data from a file.
 * 
 * Please see NOTE comments and update respective code as needed. 
 */
package com.chrisleung.leetcode.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.chrisleung.leetcode.solutions.*;

@RunWith(Parameterized.class)
public class Test_IntArrayInput_IntArrayOutput {
	
	/* NOTE: Modify path and filename here as needed */
	static private final String TEST_DATA_RELATIVE_PATH = "data/Problem_066_Plus_One.txt";
	
    static private int testCaseNum = 0;
    private static Scanner in = null;
    
    /* NOTE: Modify these fields as needed */
    private int[] fInput;
    private int[] fExpected;
    
    @Parameters(name = "Test Case #{index}")
    public static Collection<Object[]> data() {
    	in = new Scanner(Test_IntArrayInput_IntArrayOutput.class.getResourceAsStream(TEST_DATA_RELATIVE_PATH));
    	ArrayList<Object[]> testCases = new ArrayList<>();
    	while(in.hasNext()) {
    		/* NOTE: Modify file input format as needed */
			// Read test case and solution
			String inputString = in.next();
			String expectedString = in.next();
			// Expect array in format [a,b,c] -- remove outer "[]" square brackets
			inputString = inputString.substring(1, inputString.length()-1);
			expectedString = expectedString.substring(1, expectedString.length()-1);
			// Convert to String array
			String[] inputStringArray = inputString.split(",");
			String[] expectedStringArray = expectedString.split(",");
			// Convert String arrays to integer arrays
			int[] input = stringToIntArray(inputStringArray);
			int[] expected = stringToIntArray(expectedStringArray);
			int[][] testCase = new int[2][];
			testCase[0] = input;
			testCase[1] = expected;
			testCases.add(testCase);
    	}
    	in.close();
    	return testCases;
    }

    /* NOTE: Modify the constructor and field assignment as needed */
    public Test_IntArrayInput_IntArrayOutput(int[] input, int[] expected) {
    	fInput = input;
    	fExpected = expected;
    }
    
	@Test
	public void test() {
		/* NOTE: Modify the two following lines as needed */
		Problem_066_Plus_One solution = new Problem_066_Plus_One();
		int[] result  = solution.plusOne(fInput);
		
		String inputString = Arrays.toString(fInput);
		String expectedString = Arrays.toString(fExpected);
		String resultString = Arrays.toString(result);
		boolean passed = expectedString.equals(resultString);
		System.out.println(String.format("Test Case #%s  Passed: %s  Input: %s  Output Expected: %s  Output Actual: %s ",testCaseNum,passed,inputString,expectedString,resultString));
		testCaseNum++;
		assertArrayEquals(fExpected,result);
	}
	
	public static int[] stringToIntArray(String[] sArr) {
		int[] iArr = new int[sArr.length];
		for(int i=0; i<sArr.length; i++) {
			iArr[i] = Integer.parseInt(sArr[i]);
		}
		return iArr;
	}

}
