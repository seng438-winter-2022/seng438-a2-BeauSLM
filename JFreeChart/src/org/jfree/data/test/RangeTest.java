package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

    //getLowerBound Test
    @Test
    public void testHighestLowerBound() {
    	Range uppestBoundRange = new Range(Double.longBitsToDouble(0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The lower bound of (Double.longBitsToDouble(0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL) "
    			+ " should be equal to Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL),
    			uppestBoundRange.getLowerBound(), .0000000001d ); 
    }
    
    //getLowerBound Test
    @Test
    public void testLowestLowerBound() {
    	Range lowestBoundRange = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), 0);
    	assertEquals("The lower bound of (Double.longBitsToDouble(-0x7fefffffffffffffL), 0) should be equal to Double.longBitsToDouble(-0x7fefffffffffffffL)",
    			Double.longBitsToDouble(-0x7fefffffffffffffL), lowestBoundRange.getLowerBound(), .0000000001d);
    }
    
    //getLowerBound Test
    @Test
    public void testMedianLowerBound() {
    	Range medianBoundRange = new Range(0, 1);
    	assertEquals("The lower bound od (0, 1) should be 0", 0, medianBoundRange.getLowerBound(), .0000000001d); 
    }
    
    //getUpperBound Test
    @Test
    public void testHighestUpperBound() {
    	Range uppestBoundRange = new Range(0, Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The lower bound of (0, Double.longBitsToDouble(0x7fefffffffffffffL) "
    			+ " should be equal to Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL),
    			uppestBoundRange.getUpperBound(), .0000000001d ); 
    }
    
    //getUpperBound Test
    @Test
    public void testLowestUpperBound() {
    	Range lowestBoundRange = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(-0x7fefffffffffffffL));
    	assertEquals("The lower bound of (Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(-0x7fefffffffffffffL)) should be equal to Double.longBitsToDouble(-0x7fefffffffffffffL)",
    			Double.longBitsToDouble(-0x7fefffffffffffffL), lowestBoundRange.getUpperBound(), .0000000001d);
    }
    
    //getUpperBound Test
    @Test
    public void testMedianUpperBound() {
    	Range medianBoundRange = new Range(0, 1);
    	assertEquals("The lower bound of (0, 1) should be 1", 1, medianBoundRange.getUpperBound(), .0000000001d); 
    }
    
    //getLength Test
    @Test
    public void testLargestImpossibleLength() {
    	Range longestNotPossibleLength = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The length of the range (Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL))"
    			+ "will be equal to 2 X(Double.longBitsToDouble(0x7fefffffffffffffL))", (2 * Double.longBitsToDouble(0x7fefffffffffffffL)), 
    				longestNotPossibleLength.getLength(), .0000000001d);
    }
    
    //getLength Test
    @Test
    public void testLargestPossibleLength() {
    	Range longestPossibleLength = new Range(0, Double.longBitsToDouble(0x7fefffffffffffffL));
    	assertEquals("The length of the range (0, Double.longBitsToDouble(0x7fefffffffffffffL)), will be equal to "
    		+ "Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL), 
    			longestPossibleLength.getLength(), .0000000001d); 
    }
    
   
    //Shift Test
    @Test
    public void NegativeShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of -2.5 should be -4.5", -4.5, shiftRange.getLowerBound(), 0.1);
    }
    

    
    //Shift Test
    @Test
    public void negativeShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The uppper bound of -2 and 2 after shift of -2.5 should be -0.5", -0.5, shiftRange.getUpperBound(), 0.1);
    }

    //Shift Test
    @Test
    public void positiveShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 2.0 should be 0", 0, shiftRange.getLowerBound(), 0.1);
    }

    //Shift Test
    @Test
    public void positiveShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 2 should be 4.0", 4.0, shiftRange.getUpperBound(), 0.1);
    }
    
    //Shift Test
    @Test
    public void zeroShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 0.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 0 should be -2.0", -2.0, shiftRange.getLowerBound(), 0.1);
    }

    //Shift Test
    @Test
    public void zeroShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 0.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 0 should be 2.0", 2.0, shiftRange.getUpperBound(), 0.1);
    }
    
    //Shift Test
    @Test(expected = IllegalArgumentException.class)
    public void nullRangeShiftCheck() {
    	Range shiftRange = null;
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    }
    
    //toString test
    @Test public void toStringCheck() {
    	Range testRange = new Range(-5.0, 5.0);
    	assertEquals("Expected toString result was not met. ", "Range[-5.0,5.0]",testRange.toString());
    }
    
    //Haniya
    //getLength test for median length value
    @Test
	public void medianLengthValueShouldBeTwoHundred() {
        Range exampleRange = new Range(-100, 100);
		assertEquals("The length between the range of -100 and 100 should be 200",200,
				exampleRange.getLength(), .000000001d);
	}
    
    //Haniya
    //getLength test for smallest length value
    @Test
    public void smallestLengthValueShouldBeZero() {
        Range exampleRange = new Range(0, 0);
        assertEquals("The length between 0 and 0 should be 0",
        0, exampleRange.getLength(), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
