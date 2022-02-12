**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#: 3                        |   |
|------------------------------------|---|
| Student Names:                 |   |
|  Haniya Ahmed                  |   |
|   Apostolos Scondrianis     |   |
|  Beau McCartney               |   |
|  Josh Vanderstoop             |   |

# 1 Introduction

The objective of this lab is to develop an understanding of the fundamentals of automated unit testing. In this lab, the testing tool used will be the JUint framework and will assist in developing automated test code in JUint [4] from requirements retrieved from Javadoc [2] and work with mock objects for the JFreeChart [3] system. The overall experience will lead to familiarization with the JUnit framework and navigating Javadocs, unit test generation based on the requirements of the DataUtilities.java and Range.java classes specified in Javadocs, and execution of several tests and the collection of their results. We will select at least 5 methods from each of the aforementioned classes and develop a unit test strategy to execute tests for each of the selected methods. Our report discusses these details below.

# 2 Detailed description of unit test strategy

Upon reading the requirements for each of the methods from the classes that are to be tested, we decided on black-box testing as our method of testing. First, equivalence classes will be determined for each domain. Most often, this will simply involve partitioning values into legal and illegal tests. Next, we will use boundary values for the return values, this often results in testing the maximum and minimum values for the data types that are returned by each method. Following the two maximum and minimum tests, a test will be conducted to prove that the method is presumably functional for any values between the minimum and maximum - nominal values. If a value is specified to be the maximum number available (i.e. a boundary) there will be additional robustness testing just outside of the boundary to ensure the boundaries are held. For many of these tests, there will be very few illegal test values, considering the broad spectrum of values that methods can receive. Methods that contain parameter inputs, for example the method calculateColumnTotal(Values2D data, int column), will require extra tests that ensure the inputs are congruent with each other and if a parameter is out of bounds the application will not continue to calculate results. There can also be worst case testing where more than one parameter or variable has an extreme value.

In our lab, we employed equivalence testing and boundary testing as outlined in Section 3 of our report. We also have documented comments in our code, along with pseudo code in our submitted GitHub link. 

# 3 Test cases developed

We were asked to develop test cases for two classes. Range and DataUtilities classes of the package org.jfree.data. More comments have been added to our repository code. For Range we chose 5 out of 15 methods and for DataUtilities we chose 6 out 9 methods as specified below:

DataUtilities :
Class : DataUtilitiesTest
equal(double[][] a, double[][] b)
checkEqualArrays()
	Value Testing
checkNotEqualArrays()
	Value Testing
checkNullArrays()
	Boundary Testing
checkNullWithNotNullArrays()
	Boundary Testing

calculateColumnTotal(Values2D data, int column)
calculateColumnTotalForTwoValues()
	Mock Testing/Value Testing
caclulateColumnTotalForThreeValues()
	Mock Testing/Value Testing
calculateColumnTotalForThreeNegativeValues()
	Mock Testing/Value Testing

calculateColumnTotal(Values2D data, int column, int[] ValidRows)
calculateColumnTotalForTwoValidRows()
	Mock Testing/Value Testing
calculateColumnNullRowsArray()
	Illegal Testing

calculateRowTotal(Values2D data, int row)
calculateRowTotalForTwoValues()
	Mock Testing/Value Testing
calculateRowTotalForThreeValues()
	Mock Testing/Value Testing
calculateRowTotalForTwoNegativeValues()
	Mock Testing/Value Testing

calculateRowTotal(Values2D data, int row, int[] validCols)
calculateRowTotalForTwoValidColumns()
	Mock Testing/Value Testing
calculateRowTotalNullArray()
Illegal Testing


createNumberArray2D(double [][]) : Number [][]
nullObjectTo2DArrayTest()
Illegal Testing
empty2DArrayTest()
Boundary Testing (minimum number of elements)
moreThan17DecimalPlaces2DArrayTest()
				Boundary Testing (maximum number of decimal places)
tenByOne2DArrayTest()
Value Testing
oneByTen2DArrayTest()
Value Testing
. 
Class : Range
RangeTest
  getLowerBound() 
testMedianLowerBound()
	Average Number
testLowestLowerBound()
	Boundary Testing
testHighestLowerBound()
	Boundary Testing
 getUpperBound() 
testMedianUpperBound()
	Average Number
testLowestUpperBound()
	Boundary Testing
testHighestUpperBound()
	Boundary Testing
 getLength() 
smallestLengthValueShouldBeZero()
	Boundary Testing
testLargestImpossibleLength()
	Illegal Testing Number out of Bounds
testLargestPossibleLength()
	Boundary Testing
medianLengthValueShouldBeTwoHundred()
	Averagel Value Testing
 shift(Range base, double delta)
negativeShiftValueLowerBoundCheck()
	Value Testing
negativeShiftValueUpperBoundCheck()
	Value Testing
nullRangeShiftCheck()
	Illegal Testing
positiveShiftValueLowerBoundCheck()
	Value Testing
positiveShiftValueUpperBoundCheck()
	Value Testing
zeroShiftValueLowerBoundCheck()
	Boundary Testing
zeroShiftValueUpperBoundCheck()
	Boundary Testing
maximumPositiveShiftUpperBoundaryCheck()
Boundary Testing 
toString()
toStringCheck() 
Value Check


# 4 How the team work/effort was divided and managed

The team came together in the beginning of the lab to determine a unit test strategy, selected the methods that we would test, the tests we would make, and then partitioned these to each member. We did some pair-testing where JavaDoc requirements got confusing, and assisted each other through resources and communicated via chat and voice calls. We regrouped each day and had meetings to discuss where we were at and if anybody needed help and ensured that our names were commented above all our test methods. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

There were quite a few difficulties encountered when completing this lab, as it had a greater learning curve due to familiarization with new software tools and environments. Creating a JUnit test on Eclipse took some getting used to, and then getting used to the assert statement and how to fully comprehend the JavaDoc requirements also required some time for familiarization. The greatest challenge was when we tried implementing mock objects in our tests, where we realized that there was a missing library: hamcrest-library-1.3.jar. Thankfully, working as a team and consulting with one another helped overcome these challenges with time. We eventually became comfortable with the unit testing environment, JavaDoc, and Eclipse and also pinpointed the missing library. This allowed for more relaxed and faster testing. 


# 6 Comments/feedback on the lab itself

Haniya: There were definitely quite a few frustrating challenges with this lab, especially with the introduction of new environments and tools; however, I’m glad we were able to overcome them and become more comfortable and confident with unit testing. It was difficult working with only the requirements of each method rather than the code, but with time, I began gaining a better understanding of involved interfaces and how the method worked without needing to look at the code. 

Josh: This assignment helped to develop my understanding of Black box testing strategies as well as provide a basis for Mock Testing. Creating tests using only the requirements provided within the javadoc was more engaging, as I had to imagine the boundaries of each method rather than already know them. Again, the beginning of the assignment outline was precise to develop our understanding of the tools being used. This assignment was better structured to help our group quickly understand the expectations for our final submission. 

Apostolos : For our second assignment, we encountered a few less challenges than the previous one. We were more organized as a group as we took lessons from the first assignment. We had multiple meetings and made sure everyone was on the same page as we progressed on the assignment. Mocking itself wasn’t as challenging as we thought, and it was well explained on the lab handout and during classes by the professor. The only challenging thing was missing dependencies and it took a while to solve that. Once we figured that out, we quickly rebounded and completed the tasks presented in the assignment.

Beau: The main challenge I encountered in this lab was finding out that a .jar was missing from the github artifacts folder. Once I realized a dependency was missing, actually finding the jar was fairly trivial. I learned how to make .jar files part of the project so other people can close it, open the folder in eclipse, and run tests right away without adding any jars to the library themselves.
