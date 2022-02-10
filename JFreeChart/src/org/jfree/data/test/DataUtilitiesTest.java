package org.jfree.data.test;
import org.jfree.data.Range;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest {

    @Before
    public void setUp() throws Exception { 

    }
    
    //Test with equals 2 double arrays that are equal
    @Test  
   public void checkEqualArrays() {
    	double a[][] = {{5, 2, 3, 4,}, {2, 1, -5, 1}, {-7,-100, 0}};
    	double b[][] = {{5, 2, 3, 4,}, {2, 1, -5, 1}, {-7,-100, 0}};
    	boolean actualResutl = DataUtilities.equal(a, b);
    	Assert.assertTrue("Expected result is True", actualResutl);
    }
    
    //Test 2 unequal arrays
     @Test  
    public void checkNotEqualArrays() {
         double a[][] = {{1, 8, -2, 5}, {1, 16, 13, 2}, {13, -7, 8, 4}};
         double b[][] = {{1, 8, -2, 5}, {1, 7, 13, 2}, {13, -7, 8, 4}};
         boolean actualResult = DataUtilities.equal(a, b);
         Assert.assertFalse("Expected result is False", actualResult);
     }
    
    //test two null arrays
    @Test  
    public void checkNullArrays() {
         double a[][] = null;
         double b[][] = null;
         boolean actualResult = DataUtilities.equal(a, b);
         Assert.assertTrue("Expected result is True", actualResult);
     }
    
    //test one null array and one not null array
    @Test  
    public void checkNullWithNotNullArrays() {
         double a[][] = null;
         double b[][] = {{1, 8, -2, 5}, {1, 7, 13, 2}, {13, -7, 8, 4}};
         boolean actualResult = DataUtilities.equal(a, b);
         Assert.assertFalse("Expected result is False", actualResult);
     }
    
    @Test
    public void calculateColumnTotalForTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
            }
        });
        // exercise 
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 10.0, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateColumnTotalForThreeNegativeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(-25.5));
                one(values).getValue(1, 0);
                will(returnValue(-53));
                one(values).getValue(2, 0);
                will(returnValue(-5));
            }
        });
        // exercise 
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, -83.5, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateColumnTotalForTwoValidRows() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(2.5));
            }
        });
        // exercise
        int []arr = { 0, 2 };
        double result = DataUtilities.calculateColumnTotal(values, 0, arr);
        // verify
        assertEquals(result, 10.0, .000000001d);
        // tear-down: NONE in this test method
    }

    @Test
    public void calculateRowTotalForTwoNegativeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(-17.5));
                one(values).getValue(0, 1);
                will(returnValue(-12.5));
            }
        });
        // exercise 
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, -30.0, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateRowTotalForTwoValidColumns() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(2.5));
            }
        });
        // exercise
        int []arr = { 0, 2 };
        double result = DataUtilities.calculateRowTotal(values, 0, arr);
        // verify
        assertEquals(result, 10.0, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test(expected=Exception.class)
    public void calculateRowTotalNullArray() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(2.5));
            }
        });
        int []arr = null;
        double result = DataUtilities.calculateRowTotal(values, 0, arr);
        // verify
        //exception expected
    }
    
    
    //passing a null object into createNumberArray2D
    @Test
	public void nullObjectTo2DArrayTest() {
		boolean testPassed = false;
		
		try {
			DataUtilities.createNumberArray2D(null);
		} catch (Exception e) {
			testPassed = true;
		} finally {
			assertEquals("Method should throw exception.", true, testPassed);
		}
	}
    
    //pass an empty doubles array
    @Test
	public void empty2DArrayTest() {
		double [][] test = {};
		Number [][] expected = {};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the empty, expected Number 2D Array", expected, actual);
	}
    
  //testing more than 17 decimal places which a Number class can't handle
    @Test
	public void moreThan17DecimalPlaces2DArrayTest() {
		double [][] test = {{15.1234567890123456789}};
		Number [][] expected = {{15.1234567890123456789}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected Number 2D Array with more than"
				+ "17 decimal places", expected, actual);
	}
    
    //passing a ten by one double array to createNumberArray2D
    @Test
	public void tenByOne2DArrayTest() {
		double [][] test = {{15.78282},{-15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282}};
		Number [][] expected = {{15.78282},{-15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected ten by one Number 2D Array"
	, expected, actual);
	}
    
    //passing a one by ten double array to createNumberArray2D
    @Test
	public void oneByTen2DArrayTest() {
		double [][] test = {{15.78282,-15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282}};
		Number [][] expected = {{15.78282,-15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected one by ten Number 2D Array"
	, expected, actual);
	}
    
    @Test
    public void calculateRowTotalForThreeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
                one(values).getValue(0, 2);
                will(returnValue(2.5));
            }
        });
        // exercise 
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, 12.5, .000000001d);
        // tear-down: NONE in this test method
    }
    
    @Test
    public void calculateColumnTotalForThreeValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(1, 0);
                will(returnValue(2.5));
                one(values).getValue(2, 0);
                will(returnValue(2.5));
            }
        });
        // exercise 
        double result = DataUtilities.calculateColumnTotal(values, 0);
        // verify
        assertEquals(result, 12.5, .000000001d);
        // tear-down: NONE in this test method
    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
