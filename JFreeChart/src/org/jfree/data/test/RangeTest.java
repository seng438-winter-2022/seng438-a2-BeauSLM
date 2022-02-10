package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

	/*By testing Highest, Lowest, and 0 for each boundary of a range, 
		it is safe to assume if the tests are successful Range.java is applicable for any 
			(Double, Double) Range. */
    //getLowerBound Test - Josh
    @Test //Highest Lower Boundary that can be attained  (non-infinite)
    public void testHighestLowerBound() {
    	Range uppestBoundRange = new Range(Double.longBitsToDouble(0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The lower bound of (Double.longBitsToDouble(0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL) "
    			+ " should be equal to Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL),
    			uppestBoundRange.getLowerBound(), .0000000001d ); 
    }
    
    //getLowerBound Test - Josh
    @Test //Lowest Lower Boundary that can be attained (non-infinite)
    public void testLowestLowerBound() {
    	Range lowestBoundRange = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), 0);
    	assertEquals("The lower bound of (Double.longBitsToDouble(-0x7fefffffffffffffL), 0) should be equal to Double.longBitsToDouble(-0x7fefffffffffffffL)",
    			Double.longBitsToDouble(-0x7fefffffffffffffL), lowestBoundRange.getLowerBound(), .0000000001d);
    }
    
    //getLowerBound Test - Josh
    @Test //A median number (0) that serves as the lower bound of a range 
    public void testMedianLowerBound() {
    	Range medianBoundRange = new Range(0, 1);
    	assertEquals("The lower bound od (0, 1) should be 0", 0, medianBoundRange.getLowerBound(), .0000000001d); 
    }
    
	/*By testing Highest, Lowest, and 0 for each boundary of a range, 
	it is safe to assume if the tests are successful Range.java is applicable for any 
		(Double, Double) Range. */
    //getUpperBound Test - Josh
    @Test //Highest Upper Boundary that is possible (non-infinite)
    public void testHighestUpperBound() {
    	Range uppestBoundRange = new Range(0, Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The lower bound of (0, Double.longBitsToDouble(0x7fefffffffffffffL) "
    			+ " should be equal to Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL),
    			uppestBoundRange.getUpperBound(), .0000000001d ); 
    }
    
    //getUpperBound Test - Josh
    @Test //Lowest Upper Boundary that is possible (non-infinite)
    public void testLowestUpperBound() {
    	Range lowestBoundRange = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(-0x7fefffffffffffffL));
    	assertEquals("The lower bound of (Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(-0x7fefffffffffffffL)) should be equal to Double.longBitsToDouble(-0x7fefffffffffffffL)",
    			Double.longBitsToDouble(-0x7fefffffffffffffL), lowestBoundRange.getUpperBound(), .0000000001d);
    }
    
    //getUpperBound Test - Josh
    @Test //A median value (0) to be the upper bound of a range
    public void testMedianUpperBound() {
    	Range medianBoundRange = new Range(0, 1);
    	assertEquals("The lower bound of (0, 1) should be 1", 1, medianBoundRange.getUpperBound(), .0000000001d); 
    }
    
    
    /*
     * Testing max, min, and illegal ranges will provide a basis for the method to prove its functionality
     * is as expected based on the JavaDocs
     */
    //getLength Test - Josh
    @Test //This test creates a Range that is greater than the largest rational double and if Range.java does not check for 
    		//Ranges out of the scope of a Double this test will fail. 
    public void testLargestImpossibleLength() {
    	Range longestNotPossibleLength = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The length of the range (Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL))"
    			+ "will be equal to 2 X(Double.longBitsToDouble(0x7fefffffffffffffL))", (2 * Double.longBitsToDouble(0x7fefffffffffffffL)), 
    				longestNotPossibleLength.getLength(), .0000000001d);
    }
    
    //getLength Test - Josh
    @Test //Largest length that is  possible using Double values
    public void testLargestPossibleLength() {
    	Range longestPossibleLength = new Range(0, Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The length of the range (0, Double.longBitsToDouble(0x7fefffffffffffffL)), will be equal to "
    		+ "Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL), 
    			longestPossibleLength.getLength(), .0000000001d); 
    }
    
    //Haniya
    @Test //getLength test for median length value
	public void medianLengthValueShouldBeTwoHundred() {
        Range exampleRange = new Range(-100, 100);
		assertEquals("The length between the range of -100 and 100 should be 200",200,
				exampleRange.getLength(), .000000001d);
	}
    
    //Haniya
    @Test //getLength test for smallest length value
    public void smallestLengthValueShouldBeZero() {
        Range exampleRange = new Range(0, 0);
        assertEquals("The length between 0 and 0 should be 0",
        0, exampleRange.getLength(), .000000001d);
    }
    
   
<<<<<<< HEAD
    
    /*
     * Testing 0, positive, and negative shifts with random values will provide a basis if shifting is done correctly
     * Using NULL delta values expects an exception to be thrown
     */
    //Shift Test
    @Test //negative shift correctly changes the Lower bound 
    public void NegativeShiftValueLowerBoundCheck() {
=======
    //Shift Test - Apostolos
    @Test
    public void negativeShiftValueLowerBoundCheck() {
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    	Range shiftRange = new Range(-2, 2);
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of -2.5 should be -4.5", -4.5, shiftRange.getLowerBound(), 0.1);
    }
    

    
<<<<<<< HEAD
    //Shift Test
    @Test //negative shift correctly changes the upper bound 
=======
    //Shift Test - Apostolos
    @Test
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    public void negativeShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The uppper bound of -2 and 2 after shift of -2.5 should be -0.5", -0.5, shiftRange.getUpperBound(), 0.1);
    }

<<<<<<< HEAD
    //Shift Test
    @Test //positive shift correctly changes the lower bound 
=======
    //Shift Test -Apostolos
    @Test
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    public void positiveShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 2.0 should be 0", 0, shiftRange.getLowerBound(), 0.1);
    }

<<<<<<< HEAD
    //Shift Test
    @Test //positive shift correctly changes the upper bound 
=======
    //Shift Test - Apostolos
    @Test
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    public void positiveShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 2 should be 4.0", 4.0, shiftRange.getUpperBound(), 0.1);
    }
    
<<<<<<< HEAD
    //Shift Test
    @Test //shifting with delta value 0 will not change the range bounds
=======
    //Shift Test - Apostolos
    @Test
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    public void zeroShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 0.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 0 should be -2.0", -2.0, shiftRange.getLowerBound(), 0.1);
    }

<<<<<<< HEAD
    //Shift Test
    @Test //shifting with delta = 0 will not change the range bounds
=======
    //Shift Test - Apostolos
    @Test
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    public void zeroShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 0.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 0 should be 2.0", 2.0, shiftRange.getUpperBound(), 0.1);
    }
    
<<<<<<< HEAD
    //Shift Test
    @Test(expected = IllegalArgumentException.class) //delta == null should throw an exception
=======
    //Shift Test - Apostolos
    @Test(expected = IllegalArgumentException.class)
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    public void nullRangeShiftCheck() {
    	Range shiftRange = null;
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    }
    
<<<<<<< HEAD
    
    
    /*toString test - simple functionality of this method merits less testing, so the conversion of a positive and negative double 
    	is all that  is needed */
    @Test //test that the toString method properly converts a double to a string and formats as described
    public void toStringCheck() {
=======
    //Shift Test - Apostolos
    @Test
    public void naximumPositiveShiftUpperBoundaryCheck() {
    	Range shiftRange = new Range (-1, 0);
    	double delta = Double.longBitsToDouble(0x7fefffffffffffffL);
    	Range.shift(shiftRange, delta);
    	assertEquals("Expected Upper Bound is the largest possible double", Double.longBitsToDouble(0x7fefffffffffffffL), shiftRange.getUpperBound(), .0000000001d);
    }
    
    //toString test -Apostolos
    @Test public void toStringCheck() {
>>>>>>> dbaad4ed3813d242942899a04e3765096e24d377
    	Range testRange = new Range(-5.0, 5.0);
    	assertEquals("Expected toString result was not met. ", "Range[-5.0,5.0]",testRange.toString());
    }
    
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
