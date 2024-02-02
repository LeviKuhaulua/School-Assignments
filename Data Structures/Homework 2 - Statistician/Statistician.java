// File: Statistician.java
// This is an assignment for students to complete after reading Chapter 2 of
// "Data Structures and Other Objects Using Java" by Michael Main.

// Check with your instructor to see whether you should put this class in
// a package. At the moment, it is declared as part of edu.colorado.homework:

/******************************************************************************
* This class is a homework assignment;									       
* A {@code Statistician} keeps track of statistics about a sequence of
* double numbers.
*
* <b>Note:</b>
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* <b>Outline of Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/homework/Statistician.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/homework/Statistician.java
*   </A>
*
* @author Levi Kuhaulua (<A HREF=MAILTO:levi.kuhaulua@outlook.com>levi.kuhaulua@outlook.com</A>)
* @version 21.0.1  
******************************************************************************/
public class Statistician
{   

   private int length; 
   private double minNum, maxNum, lastNum; 
   private double sum, mean; 
   /**
   * Initialize a new Statistician.  
   * <b>Postcondition:</b>
   *   This Statistician is newly initialized and has not yet been given any 
   *   numbers.
   **/   
   public Statistician( )
   {
      // Sum and Length of '0' is useful information to user. 
      this.length = 0; 
      this.sum = 0; 

      this.minNum = Double.NaN; 
      this.maxNum = Double.NaN; 
      this.lastNum = Double.NaN; 
      this.mean = Double.NaN;       
   }           
   
   /**
   * Give a new number to this Statistician. 
   * @param number
   *   the new number that is being given the this Statistician
   * <b>Postcondition:</b>
   *   The specified number has been given to this Statistician and
   *   it will be included in any subsequent statistics.
   **/
   public void nextNumber(double number)
   {
      length++; 
   }

   /**
   * Determine how many numbers have been given to this Statistician.
   * @return
   *   the count of how many numbers have been given to this Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   Giving a Statistician more than
   *   <CODE>Integer.MAX_VALUE</CODE> numbers, will
   *   cause failure with an arithmetic overflow.
   **/ 
   public int length( ){
      return length;
   }
   
   
   /**
   * Determine the largest number that has been given 
   * to this Statistician.
   * @return
   *   the largest number that has been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   **/ 
   public double maximum( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Determine the arithmetic average of all the numbers that have been given 
   * to this Statistician.
   * @return
   *   the arithmetic mean of all the number that have been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If this Statistician has been given more than
   *   <CODE>Integer.MAX_VALUE</CODE> numbers, then this method fails
   *   because of arithmetic overflow.
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   *   If <CODE>sum()</CODE> exceeds the bounds of double numbers, then the 
   *   answer from this method may be 
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE>.
   **/ 
   public double mean( )
   {
      // The student's code will replace this return statement:
      return 0;
   }


   /**
   * Determine the smallest number that has been given 
   * to this Statistician.
   * @return
   *   the smallest number that has been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If <CODE>length()</CODE> is zero, then the answer from this method
   *   is <CODE>Double.NaN</CODE>.
   **/ 
   public double minimum( )
   {
      // The student's code will replace this return statement:
      return 0;
   }




   /**
   * Determine the sum of all the numbers that have been given to this 
   * Statistician.
   * @return
   *   the sum of all the number that have been given to this 
   *   Statistician
   *   since it was initialized or reinitialized.
   * <b>Note:</b>
   *   If the sum exceeds the bounds of double numbers, then the answer
   *   from this method may be 
   *   <CODE>Double.POSITIVE_INFINITY</CODE> or
   *   <CODE>Double.NEGATIVE_INFINITY</CODE>.
   **/ 
   public double sum( )
   {
      // The student's code will replace this return statement:
      return 0;
   }

   /**
    * Return the last number given to this {@code Statistician} 
    * @return
    */
   public double lastNumber( ) {

      return 0; 

   }

      
}