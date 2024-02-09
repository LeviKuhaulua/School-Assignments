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
   
   public int length; 
   private double minNum, maxNum, lastNum; 
   private double sum, mean; 
   
   /**
   * Initialize a new Statistician Instance
   * @postcondition 
   * An empty Statistician that can take in a sequence of numbers. 
   * 
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
    * Feed a new number to the Statistician sequence. 
    * @param number
    *   the new number that is being given to this Statistician. 
    * @precondition 
    *   the new number being fed is a valid number that can be converted to a {@code Double} and is not {@code Double.NaN}
    * @postcondition
    *   The number has been included into the sequence and is also included in subsequent statistics about sequence.
    **/
   public void nextNumber(double number){ 

      if (Double.isNaN(number)) {
         throw new IllegalArgumentException(
            "Must be a number. Not NaN"
         ); 
      } else {
         length++; 
         lastNum = number; 
         sum += lastNum;  
         maxNum = maximum(); 
         minNum = minimum(); 
         mean = mean();   
      }
   }
      
      /**
       * Return the last number given to the Statistician
       * @postcondition 
       *   Return a {@code double} number that represents the last number of the sequence. 
       *   <P>
       *    <B>NOTE</B>: If the length of the sequence exceeds {@code Integer.MAX_VALUE}, 
       *    it will still return the last number of the sequence. Additionally, if the last number in the sequence 
       *    is an arbitrarily large number that exceeds {@code Double.MAX_VALUE} or a number that is arbitrarily less than 
       *    {@code -Double.MAX_VALUE}, then it will return either positive or negative infinity. 
       *   </P>
       * 
       * 
       */
   public double lastNumber(){
         return lastNum; 
   }
      
   /**
   * Determine how many numbers have been given to this Statistician.
   * @postcondition 
   *   Return a {@code Double} number that represents the amount of the numbers in the sequence.
   *   <P><B>NOTE</B>: If you add more than {@code Integer.MAX_VALUE} numbers to the sequence, 
   *   it will go return {@code -Integer.MAX_VALUE} plus the amount of numbers you added.</P> 
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

      if (length == 1) {
         maxNum = lastNum; 
         return maxNum; 
      } else if (length > 1) {
         maxNum = Double.max(maxNum, lastNum); 
         return maxNum; 
      } else { // when length is 0. 
         return maxNum; 
      }
      
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
      if (length == 1) {
         mean = lastNum; 
         return mean; 
      } else if (length > 1) {
         mean = sum / length; 
         return mean; 
      } else { // When length is 0
         return mean; 
      }
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
      if (length == 1) {
         minNum = lastNum; 
         return minNum; 
      } else if (length > 1) {
         minNum = Double.min(minNum, lastNum); 
         return minNum; 
      } else { // When length is 0. 
         return minNum; 
      }
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
   public double sum()
   { 
      return (length == 0) ? 0 : sum; 
   }


      
}