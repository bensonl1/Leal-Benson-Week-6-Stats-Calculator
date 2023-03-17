/**
*This class runs the StatsCalculator program by taking input and doing calculations.
*/

import java.util.Scanner;
public class StatsCalculatorRunner {
  /**
  *This is the main method of the program, it takes user input to create a custom array and to perform calculations on it
  *@param number of values in the array.
  *@param values in the array.
  **/
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the size of your array: ");
    int arraySize = input.nextInt();
    double[] userArray = new double[arraySize];
    System.out.println("Enter " + arraySize + " values: ");

    for(int i = 0; i < arraySize; i++)
      {
        System.out.print("Value " + (i + 1) + ": ");
        userArray[i] = input.nextDouble();
      }
    System.out.println();
    StatsCalculator customArray = new StatsCalculator(userArray);
    customArray.print();
    customArray.sortData();
    customArray.printSorted();
    customArray.printFiveNumberSummary();
    System.out.println("\nThe mean is " + customArray.calculateMean());
    System.out.println();
    /**
    *Test 1
    */
    
    double[] data = {10.0, 20.0, 5.0, 15.0, 25.0, 30.0, 8.0};
    StatsCalculator myCalculator = new StatsCalculator(data);
    myCalculator.print();
    myCalculator.sortData();
    myCalculator.printSorted();
    myCalculator.printFiveNumberSummary();
    System.out.println("\nThe mean is " + myCalculator.calculateMean());
    System.out.println();
    /**
    *Test 2
    */
    
    double[ ] data2 = {1,2,3,4,5,6};
    StatsCalculator myCalculator2 = new StatsCalculator(data2);
    myCalculator2.print();
    myCalculator2.sortData();
    myCalculator2.printSorted();
    myCalculator2.printFiveNumberSummary();
    System.out.println("\nThe mean is " + myCalculator2.calculateMean());

  }
}