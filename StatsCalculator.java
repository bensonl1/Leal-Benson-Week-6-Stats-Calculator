/** 
*Class that provides methods for calculating various things on an array of doubles.
*This class calculates max, min, median, sum, first quartile, third quartile, and five number summary of thet data.
*Also provides methods for printing orignal data and five number summary
*/

import java.util.Arrays;
public class StatsCalculator
  {
    private double[] values;
    private double[] sortedValues;
    /** 
    *Constructs a StatsCalculator object with an array length of 20.
    */
    
    public StatsCalculator()
    {
      this.values = new double[20];
    }
    /** 
    *Constructs a StatsCalculator object with given array of doubles.
    *@param values, the area of doubles to be used for calculations
    */
    
    public StatsCalculator(double[] values)
    {
      this.values = values;
    }
    /** 
    *Sorts data in order going up in sortedValues array.
    */
    
    public void sortData()
    {
      sortedValues = values.clone();
      Arrays.sort(sortedValues);
    }
    /** 
    *Calculates and returns maximum value in values[].
    *@return the maximum  value in values[].
    */
    
    public double calculateMax()
    {
      double max = values[0];
      for(int i = 1; i < values.length; i++)
        {
          if(values[i] > max)
          {
            max = values[i];
          }
        }
      return max;
    }
    /** 
    *Calculates and returns minimum value in values[].
    *@return the minimum value in values[].
    */
    
    public double calculateMin()
    {
      double min = values[0];
      for(int i = 1; i < values.length; i++)
        {
          if(values[i] < min)
          {
            min = values[i];
          }
        }
      return min;
    }
    /** 
    *Calculates and returns the median value in ascending order using values[].
    *@return the median value of values[].
    */
    
    public double calculateMedian()
    {
      double median = 0;
      sortData();
      int mid = sortedValues.length / 2;
      if((sortedValues.length) % 2 == 1)
      {
      median = sortedValues[mid];
      }
      if((sortedValues.length) % 2 == 0)
      {
        median = ((sortedValues[mid - 1] + sortedValues[mid]) / 2.0);
      }
      return median;
    }
    /** 
    *Calculates and returns the sum of values[].
    *@return the sum of all values in values[].
    */
    
    public double calculateSum()
    {
      double sum = 0;
      for(int i = 0; i < values.length; i++)
        {
          sum += values[i];
        }
      return sum;
    }
    /** 
    *Calculates and returns mean of all values in values[].
    *@return mean of values[].
    */
    
    public double calculateMean()
    {
      double sum = 0; 
      double mean = 0;
      for(int i = 0; i < values.length; i++)
        {
          sum += values[i];
        }
      mean = sum / values.length;
      return mean;
    }
    /** 
    *Calculates and returns first quartile of values[].
    *@return first quartile of values[].
    */
    
    public double calculateFirstQuartile()
    {
      sortData();
      int mid = sortedValues.length / 2;
      double[] lowerHalf = new double[mid];
      for(int i = 0; i < mid; i++)
        {
          lowerHalf[i] = sortedValues[i];
        }
      return new StatsCalculator(lowerHalf).calculateMedian();
    }
    /** 
    *Calculates and returns third quartile of values[].
    *@return the third quartile of values[].
    */
    
    public double calculateThirdQuartile()
    {
      sortData();
      int mid = sortedValues.length / 2;
      double[] upperHalf;
      if(sortedValues.length % 2 == 0)
      {
        upperHalf = new double[mid];
        for(int i = 0; i < mid; i++)
          {
            upperHalf[i] = sortedValues[mid + i];
          }
      }
      else
      {
        upperHalf = new double[mid];
        for(int i = 0; i < mid; i++)
          {
            upperHalf[i] = sortedValues[mid + 1 + i];
          }
      }
      return new StatsCalculator(upperHalf).calculateMedian();
    }
    /**
    *Prints unsorted values[] array.
    */
    
    public void print()
    {
      System.out.print("Your data is: ");
      for(double value : values)
      {
        System.out.print(value + " ");
      }
      System.out.println();
    }
    /**
    *Prints sorted values[] array.
    */
    
    public void printSorted()
    {
      System.out.print("Your sorted data is: ");
      for(double sortedValue: sortedValues)
      {
        System.out.print(sortedValue + " ");
      }
      System.out.println();
    }
    /**
    *Prints five number summary of values[]. 
    */
    
    public void printFiveNumberSummary()
    {
      System.out.println("Your five number summary is: ");
      System.out.println("\tMinimum: " + calculateMin());
      System.out.println("\tFirst Quartile: " + calculateFirstQuartile());
      System.out.println("\tMedian: " + calculateMedian());
      System.out.println("\tThird Quartile: " + calculateThirdQuartile());
      System.out.print("\tMaximum: " + calculateMax());
    }
  }