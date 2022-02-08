package org.jfree.data.test;
import org.jfree.data.Range;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
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
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

}
