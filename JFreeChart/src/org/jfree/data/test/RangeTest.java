package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {

	//variables
	private Range uppestBoundRange;
	private Range lowestBoundRange;
	private Range medianBoundRange;
	private Range uppestBoundRange2;
	private Range lowestBoundRange2;
	private Range longestNotPossibleLength;
	private Range longestPossibleLength;
	private Range exampleRange;
	private Range testRange;
	private Range shiftRange;
	private Range shiftRange2;
	private Range shiftRange3;
	private Range shiftRange4;
	private Range shiftRange5;
	private Range shiftRange6;
	private Range shiftRange7;
	private Range shiftRange8;

    private Range exampleRange2;
	
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	
	@Before
    public void setUp() throws Exception { 
		uppestBoundRange = new Range(Double.longBitsToDouble(0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL));
		lowestBoundRange = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), 0);
		medianBoundRange = new Range(0, 1);
		uppestBoundRange2 = new Range(0, Double.longBitsToDouble(0x7fefffffffffffffL));
		lowestBoundRange2 = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(-0x7fefffffffffffffL));
		longestNotPossibleLength = new Range(Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL));
		longestPossibleLength = new Range(0, Double.longBitsToDouble(0x7fefffffffffffffL));
		testRange = new Range(-5.0, 5.0);
		exampleRange = new Range(-100, 100);
		exampleRange2 = new Range(0, 0);
    	shiftRange = new Range(-2, 2);
    	shiftRange2 = new Range(-2, 2);
    	shiftRange3 = new Range(-2, 2);
    	shiftRange4 = new Range(-2, 2);
    	shiftRange5 = new Range(-2, 2);
    	shiftRange6 = new Range(-2, 2);
    	shiftRange7 = null;
    	shiftRange8 = new Range (-1, 0);
	
	}
	
    //getLowerBound Test - Josh
    @Test
    public void testHighestLowerBound() {
    	assertEquals("The lower bound of (Double.longBitsToDouble(0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL) "
    			+ " should be equal to Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL),
    			uppestBoundRange.getLowerBound(), .0000000001d ); 
    }
    
    //getLowerBound Test - Josh
    @Test
    public void testLowestLowerBound() {
    	assertEquals("The lower bound of (Double.longBitsToDouble(-0x7fefffffffffffffL), 0) should be equal to Double.longBitsToDouble(-0x7fefffffffffffffL)",
    			Double.longBitsToDouble(-0x7fefffffffffffffL), lowestBoundRange.getLowerBound(), .0000000001d);
    }
    
    //getLowerBound Test - Josh
    @Test
    public void testMedianLowerBound() {
    	assertEquals("The lower bound od (0, 1) should be 0", 0, medianBoundRange.getLowerBound(), .0000000001d); 
    }
    
    //getUpperBound Test - Josh
    @Test
    public void testHighestUpperBound() {
    	assertEquals("The lower bound of (0, Double.longBitsToDouble(0x7fefffffffffffffL) "
    			+ " should be equal to Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL),
    			uppestBoundRange2.getUpperBound(), .0000000001d ); 
    }
    
    //getUpperBound Test - Josh
    @Test
    public void testLowestUpperBound() {
    	assertEquals("The lower bound of (Double.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(-0x7fefffffffffffffL)) should be equal to Double.longBitsToDouble(-0x7fefffffffffffffL)",
    			Double.longBitsToDouble(-0x7fefffffffffffffL), lowestBoundRange2.getUpperBound(), .0000000001d);
    }
    
    //getUpperBound Test - Josh
    @Test
    public void testMedianUpperBound() {
    	assertEquals("The lower bound of (0, 1) should be 1", 1, medianBoundRange.getUpperBound(), .0000000001d); 
    }
    
    //getLength Test - Josh
    @Test
    public void testLargestImpossibleLength() {
    	assertEquals("The length of the range (Doble.longBitsToDouble(-0x7fefffffffffffffL), Double.longBitsToDouble(0x7fefffffffffffffL))"
    			+ "will be equal to 2 X(Double.longBitsToDouble(0x7fefffffffffffffL))", (2 * Double.longBitsToDouble(0x7fefffffffffffffL)), 
    				longestNotPossibleLength.getLength(), .0000000001d);
    }
    
    //getLength Test - Josh
    @Test
    public void testLargestPossibleLength() {
    	assertEquals("The length of the range (0, Double.longBitsToDouble(0x7fefffffffffffffL)), will be equal to "
    		+ "Double.longBitsToDouble(0x7fefffffffffffffL)", Double.longBitsToDouble(0x7fefffffffffffffL), 
    			longestPossibleLength.getLength(), .0000000001d); 
    }
    
   
    //Shift Test - Apostolos
    @Test
    public void negativeShiftValueLowerBoundCheck() {
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of -2.5 should be -4.5", -4.5, shiftRange.getLowerBound(), 0.1);
    }
    

    
    //Shift Test - Apostolos
    @Test
    public void negativeShiftValueUpperBoundCheck() {
    	double delta = -2.5;
    	Range.shift(shiftRange2, delta);
    	assertEquals("The uppper bound of -2 and 2 after shift of -2.5 should be -0.5", -0.5, shiftRange2.getUpperBound(), 0.1);
    }

    //Shift Test -Apostolos
    @Test
    public void positiveShiftValueLowerBoundCheck() {
    	double delta = 2.0;
    	Range.shift(shiftRange3, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 2.0 should be 0", 0, shiftRange3.getLowerBound(), 0.1);
    }

    //Shift Test - Apostolos
    @Test
    public void positiveShiftValueUpperBoundCheck() {
    	double delta = 2.0;
    	Range.shift(shiftRange4, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 2 should be 4.0", 4.0, shiftRange4.getUpperBound(), 0.1);
    }
    
    //Shift Test - Apostolos
    @Test
    public void zeroShiftValueLowerBoundCheck() {
    	double delta = 0.0;
    	Range.shift(shiftRange5, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 0 should be -2.0", -2.0, shiftRange5.getLowerBound(), 0.1);
    }

    //Shift Test - Apostolos
    @Test
    public void zeroShiftValueUpperBoundCheck() {
    	double delta = 0.0;
    	Range.shift(shiftRange6, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 0 should be 2.0", 2.0, shiftRange6.getUpperBound(), 0.1);
    }
    
    //Shift Test - Apostolos
    @Test(expected = IllegalArgumentException.class)
    public void nullRangeShiftCheck() {
    	double delta = 2.0;
    	Range.shift(shiftRange7, delta);
    }
    
    //Shift Test - Apostolos
    @Test
    public void maximumPositiveShiftUpperBoundaryCheck() {
    	double delta = Double.longBitsToDouble(0x7fefffffffffffffL);
    	Range.shift(shiftRange8, delta);
    	assertEquals("Expected Upper Bound is the largest possible double", Double.longBitsToDouble(0x7fefffffffffffffL), shiftRange8.getUpperBound(), .0000000001d);
    }
    
    //toString test -Apostolos
    @Test public void toStringCheck() {
    	assertEquals("Expected toString result was not met. ", "Range[-5.0,5.0]",testRange.toString());
    }
    
    //Haniya
    //getLength test for median length value
    @Test
	public void medianLengthValueShouldBeTwoHundred() {
		assertEquals("The length between the range of -100 and 100 should be 200",200,
				exampleRange.getLength(), .000000001d);
	}
    
    //Haniya
    //getLength test for smallest length value
    @Test
    public void smallestLengthValueShouldBeZero() {
        assertEquals("The length between 0 and 0 should be 0",
        0, exampleRange2.getLength(), .000000001d);
    }
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
