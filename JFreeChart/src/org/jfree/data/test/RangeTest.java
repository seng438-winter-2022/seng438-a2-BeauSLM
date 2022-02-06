package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;



    @Before
    public void setUp() throws Exception { 
    	exampleRange = new Range(-1, 1);
    }

    //Shift Tests Starts
    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    
    @Test
    public void NegativeShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of -2.5 should be -4.5", -4.5, shiftRange.getLowerBound(), 0.1);
    }

    @Test
    public void negativeShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = -2.5;
    	Range.shift(shiftRange, delta);
    	assertEquals("The uppper bound of -2 and 2 after shift of -2.5 should be -0.5", -0.5, shiftRange.getUpperBound(), 0.1);
    }

    @Test
    public void positiveShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 2.0 should be 0", 0, shiftRange.getLowerBound(), 0.1);
    }

    @Test
    public void positiveShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 2 should be 4.0", 4.0, shiftRange.getUpperBound(), 0.1);
    }
    

    @Test
    public void zeroShiftValueLowerBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 0.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The lower bound of -2 and 2 after shift of 0 should be -2.0", -2.0, shiftRange.getLowerBound(), 0.1);
    }

    @Test
    public void zeroShiftValueUpperBoundCheck() {
    	Range shiftRange = new Range(-2, 2);
    	double delta = 0.0;
    	Range.shift(shiftRange, delta);
    	assertEquals("The upper bound of -2 and 2 after shift of 0 should be 2.0", 2.0, shiftRange.getUpperBound(), 0.1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void nullRangeShiftCheck() {
    	Range shiftRange = null;
    	double delta = 2.0;
    	Range.shift(shiftRange, delta);
    }
    //Shift Tests end
    
    //toString test
    @Test public void toStringCheck() {
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