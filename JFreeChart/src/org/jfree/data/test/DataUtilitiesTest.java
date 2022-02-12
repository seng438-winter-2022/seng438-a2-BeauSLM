package org.jfree.data.test;

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

	
	// we don't have anything in the setUp classes as we don't have static sample data or data that was reused throughout this test class
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
	
    @Before
    public void setUp() throws Exception {
    }
    
    //By: Haniya
    //equal(double[][] a, double[][]b) method
    //Equivalence test (legal value) with equals 2 double arrays that are equal
    //Expected outcome: true
    @Test  
   public void checkEqualArrays() {
    	double a[][] = {{5, 2, 3, 4,}, {2, 1, -5, 1}, {-7,-100, 0}};
    	double b[][] = {{5, 2, 3, 4,}, {2, 1, -5, 1}, {-7,-100, 0}};
    	boolean actualResutl = DataUtilities.equal(a, b);
    	Assert.assertTrue("Expected result is True", actualResutl);
    }
    
    //By: Apostolos
    //equal(double[][] a, double[][]b) method
    //Equivalence test (legal value) with equals 2 double arrays that are unequal
    //Expected outcome: false
     @Test  
    public void checkNotEqualArrays() {
         double a[][] = {{1, 8, -2, 5}, {1, 16, 13, 2}, {13, -7, 8, 4}};
         double b[][] = {{1, 8, -2, 5}, {1, 7, 13, 2}, {13, -7, 8, 4}};
         boolean actualResult = DataUtilities.equal(a, b);
         Assert.assertFalse("Expected result is False", actualResult);
     }
    
    //By: Haniya
    //equal(double[][] a, double[][]b) method
    //Boundary test with equals; 2 double arrays that are null
    //Expected outcome: true
    @Test  
    public void checkNullArrays() {
         double a[][] = null;
         double b[][] = null;
         boolean actualResult = DataUtilities.equal(a, b);
         Assert.assertTrue("Expected result is True", actualResult);
     }
    
    //By: Haniya
    //equal(double[][] a, double[][]b) method
    //Boundary test with equals; 1 null double array and one not-null double array
    //Expected outcome: false
    @Test  
    public void checkNullWithNotNullArrays() {
         double a[][] = null;
         double b[][] = {{1, 8, -2, 5}, {1, 7, 13, 2}, {13, -7, 8, 4}};
         boolean actualResult = DataUtilities.equal(a, b);
         Assert.assertFalse("Expected result is False", actualResult);
     }
    
    //By: Beau
    //calculateColumnTotal(Values2D data, int column) method
    //Equivalence test using mocking (legal value); calculating column total for two columns
    //Expected outcome: 10.0
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
    
    //By: Apostolos
    //calculateRowTotal(Values2D data, int row) method
    //Equivalence test using mocking (legal value); calculating row total for two rows
    //Expected outcome: 10.0
    @Test 
    public void calculateRowTotalForTwoValues() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(7.5));
                one(values).getValue(0, 1);
                will(returnValue(2.5));
            }
        });
        // exercise 
        double result = DataUtilities.calculateRowTotal(values, 0);
        // verify
        assertEquals(result, 10.0, .000000001d);
        // tear-down: NONE in this test method
    }
    
    //By: Beau
    //calculateColumnTotal(Values2D data, int column, int[] ValidRows) method
    //Equivalence test using mocking (legal value); calculating row total for two specific rows
    //Expected outcome: 10.0
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
    
    //By: Apostolos
    //calculateRowTotal(Values2D data, int row) method
    //Equivalence test using mocking (legal value); calculating row total using two negative values
    //Expected outcome: -30.0
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
    
    
    //By: Beau
    //calculateRowTotal(Values2D data, int row, int[] validCols) method
    //Equivalence test using mocking (legal value); calculating row total for two specific rows
    //Expected outcome: 10.0
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
    
    //By: Apostolos
    //calculateRowTotal(Values2D data, int row, int[] validCols) method
    //Equivalence test using mocking (illegal value); calculating row total with null arrays
    //Expected outcome: Exception is thrown
    @Test(expected=Exception.class) //null array should throw an exception
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
    
	
    //By: Josh
    //calculateColumnTotal(Values2D data, int column, int[] ValidRows) method
    //Equivalence test using mocking (illegal value); passing in null arrays for calculating column total
    //Expected outcome: Exception is thrown
    @Test(expected=Exception.class) //null array should throw an exception 
    public void calculateColumnNullRowsArray() {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(72));
                one(values).getValue(1, 0);
                will(returnValue(1));
                one(values).getValue(2, 0);
                will(returnValue(5));
            }
        });
        int []arr = null;
        double result = DataUtilities.calculateColumnTotal(values, 0, arr);
        // no teardown
    }
	
    //By: Haniya
    //createNumberArray2D(double [][]) : Number [][] method
    //Equivalence test (illegal value); passing in a null object to turn into a 2D Number array
    //Expected outcome: Exception is thrown
    @Test
	public void nullObjectTo2DArrayTest() {
		boolean testPassed = false;
		
		try {
			DataUtilities.createNumberArray2D(null);
		} catch (Exception e) {
			//exception was thrown
			testPassed = true;
		} finally {
			assertEquals("Method should throw exception.", true, testPassed);
		}
	}
    
    //Number is a serialized object we test. Holds any type of numbers you wish to pass. (Abstract -> java lang Interface)
    //By: Haniya
    //createNumberArray2D(double [][]) : Number [][] method
    //Boundary testing with least number of possible elements; passing in an empty 2D double array to turn into a Number array
    //Expected outcome: an empty Number array
    @Test
	public void empty2DArrayTest() {
		double [][] test = {};
		Number [][] expected = {};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the empty, expected Number 2D Array", expected, actual);
	}
   
    //By: Haniya
    //createNumberArray2D(double [][]) : Number [][] method
    //Boundary testing with most number of decimal places allowed in a 2D Number array (17); passing in a 2D double array with more than 17 decimal places
    //Expected outcome: a Number array that cuts off extra decimal places
    @Test
	public void moreThan17DecimalPlaces2DArrayTest() {
    	//Last 2 digits get chopped - can't be stored.
		double [][] test = {{15.1234567890123456789}}; 
		Number [][] expected = {{15.12345678901234567}}; //last two decimal places are cut off
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected Number 2D Array with more than"
				+ "17 decimal places", expected, actual);
	}
	
    //By: Haniya
    //createNumberArray2D(double [][]) : Number [][] method
    //Equivalence test (legal value); passing in a 2D double array with 1 row and 10 columns
    //Expected outcome: a converted Number array
    @Test
	public void tenByOne2DArrayTest() {
		double [][] test = {{15.78282},{-15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282}};
		Number [][] expected = {{15.78282},{-15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282},{15.78282}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected ten by one Number 2D Array"
	, expected, actual);
	}
    
    //By: Haniya
    //createNumberArray2D(double [][]) : Number [][] method
    //Equivalence test (legal value); passing in a 2D double array with 10 rows and 1 column
    //Expected outcome: a converted Number array
    @Test
	public void oneByTen2DArrayTest() {
    	
		double [][] test = {{15.78282,-15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282}};
		Number [][] expected = {{15.78282,-15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282,15.78282}};
		Number [][] actual = DataUtilities.createNumberArray2D(test);
		assertArrayEquals("The Number 2D array produce by DataUtilities does not match the expected one by ten Number 2D Array"
	, expected, actual);
	}
    
    //By: Beau
    //calculateRowTotal(Values2D data, int row) method
    //Equivalence test using mocking (illegal value); calculating row total for three values
    //Expected outcome: 12.5
    @Test //calc row total for three values 
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
    
    //By: Beau
    //calculateColumnTotal(Values2D data, int column) method
    //Equivalence test using mocking (illegal value); calculating column total for three values
    //Expected outcome: 12.5
    @Test //calculate col total for three values 
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


    //By: Apostolos
    //calculateColumnTotal(Values2D data, int column) method
    //Equivalence test using mocking (illegal value); calculating column total for two negative values
    //Expected outcome: -83.5
	@Test //column total with negative values 
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
	
	    @After
    public void tearDown() throws Exception {
    }

	@AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
