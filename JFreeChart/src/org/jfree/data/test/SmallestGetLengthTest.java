package org.jfree.data.test;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class SmallestGetLengthTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(0, 0);
    }


    @Test
    public void smallestLengthValueShouldBeZero() {
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
