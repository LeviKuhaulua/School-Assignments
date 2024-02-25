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
   * Initialize a new Statistician Instance
   * @postcondition 
   *   An empty Statistician that can take in a sequence of numbers. 
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
            "Must be a number."
         ); 
      } else { // Make sure that this only runs if the number is a valid number. 
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
       * @precondition
       *   Statistician must be an empty sequence OR a sequence with only valid numbers. See {@link nextNumber} method 
       * @postcondition 
       *   Return a {@code double} number that represents the last number of the sequence or {@code NaN} if no numbers in sequence. 
       *   <P>
       *    <B>NOTE:</B> If the length of the sequence exceeds {@code Integer.MAX_VALUE}, 
       *    it will still return the last number of the sequence. Additionally, if the last number in the sequence 
       *    is an arbitrarily large number that exceeds {@code Double.MAX_VALUE} or a number that is arbitrarily less than 
       *    {@code -Double.MAX_VALUE}, then it will return either positive or negative infinity. 
       *   </P>
       * 
       */
   public double lastNumber(){
         return lastNum; 
   }
      
   /**
   * Determine how many numbers have been given to this Statistician.
   * @postcondition 
   *   Return a {@code Double} number that represents the amount of the numbers in the sequence. If length is 0 then return {@code 0}.
   *   <P>
   *     <B>NOTE:</B> If you add more than {@code Integer.MAX_VALUE} numbers to the sequence, 
   *     it will return {@code -Integer.MAX_VALUE} plus the amount of numbers you added.
   *   </P> 
   **/ 
   public int length( ){
      return length;
   }
   
   
   /**
   * Determine the largest number that has been given 
   * to this Statistician.
   * @precondition 
   *   Statistician must be an empty sequence OR a sequence with only valid numbers. See {@link nextNumber} method
   * @postcondition 
   *   Return a {@code double} number that represents the largest number in the sequence or {@code NaN} 
   *   if length of the sequence is 0. 
   * 
   *   <P> 
   *     <B>NOTE:</B> If you feed a number that is {@code Double.MAX_VALUE} then that will be the maximum of the sequence UNLESS
   *     you feed {@code Double.POSITIVE_INFINITY} into the sequence. 
   *   </P> 
   **/ 
   public double maximum( )
   {
      if (length == 1) {
         maxNum = lastNum; 
         return maxNum; 
      } else if (length > 1) {
         maxNum = Double.max(maxNum, lastNum); 
         return maxNum; 
      } else { // When length is 0 or when the length is negative (arithmetic overflow) 
         return maxNum; 
      }
      
   }


   /**
   * Determine the arithmetic average of all the numbers that have been given 
   * to this Statistician.
   * @precondition 
   *    Statistician must be an empty sequence OR a sequence with only valid numbers. See {@link nextNumber} method
   * @postcondition 
   *    Return a {@code double} number representing the arithmetic mean of the sequence or {@code NaN} 
   *    if the length of the sequence is 0. 
   * 
   *    <P>
   *      <B>NOTE:</B> If the sum of the sequence is over the bounds for double numbers, then 
   *      the answer will result in {@code Double.POSITIVE_INFINITY} or {@code Double.NEGATIVE_INFINITY}. 
   *      Another thing to take note is that if the length of the sequence exceeds {@code Integer.MAX_VALUE}, 
   *      then that will return the last known valid mean of the sequence. 
   *    </P>
   **/ 
   public double mean( )
   {
      if (length == 1) {
         mean = lastNum; 
         return mean; 
      } else if (length > 1) {
         mean = sum / length; 
         return mean; 
      } else { // When length is 0 or when the length is negative (arithmetic overflow)
         return mean; 
      }
   }


   /**
   * Determine the smallest number that has been given 
   * to this Statistician.
   * @precondition
   *   Statistician must be an empty sequence OR a sequence with only valid numbers. See {@link nextNumber} method
   * @postcondition 
   *   Return a {@code double} number that represents the minimum number of the sequence or {@code NaN} 
   *   if the length of the sequence is 0. 
   * 
   *   <P> 
   *     <B>NOTE:</B> If you feed {@code -Double.MAX_VALUE} then that will remain the minimum number of the sequence UNLESS
   *     the next number fed to the sequence is {@code Double.NEGATIVE_INFINITY}. 
   *   </P> 
   **/ 
   public double minimum( )
   {
      if (length == 1) {
         minNum = lastNum; 
         return minNum; 
      } else if (length > 1) {
         minNum = Double.min(minNum, lastNum); 
         return minNum; 
      } else { // When length is 0 or when the length is negative (arithmetic overflow) 
         return minNum;  
      }
   }




   /**
   * Determine the sum of all the numbers that have been given to this 
   * Statistician.
   * @postcondition 
   *   Return a {@code double} number that represents the sum of the sequence. Otherwise, if
   *   the length of the sequence is 0, then return {@code 0}. 
   *   
   *   <P>
   *     <B>NOTE:</B> If the sum goes over the bounds for double numbers, then it may return {@code Double.POSITIVE_INFINITY}
   *     or {@code Double.NEGATIVE_INFINITY}. 
   *   </P> 
   **/ 
   public double sum()
   { 
      return (length == 0) ? 0 : sum; 
   }

   /**
    * Create a new {@code Statistician} instance that is the result of 
    * adding the sequence of two {@code Statistician} instances. 
    * @precondition 
    *   TODO: TEST AND DEBUG ADD METHOD 
    * @postcondition 
    *    Returns a new Statistician instance that can be fed numbers and provide 
    *    up-to-date statistics of the sequence. 
    */
   public static Statistician add(Statistician s1, Statistician s2) {
      Statistician sumOfSequences = new Statistician(); 

      // When s2 is empty 
      if(s1.length > 0 && s2.length == 0) {
         sumOfSequences.lastNum = s1.lastNum; 
         sumOfSequences.length = s1.length; 
         sumOfSequences.sum = s1.sum; 
         sumOfSequences.mean = sumOfSequences.sum / sumOfSequences.length; 
         sumOfSequences.maxNum = s1.maxNum; 
         sumOfSequences.minNum = s1.minNum; 
         return sumOfSequences; 
      } else if (s2.length > 0 && s1.length == 0) { // When s1 is empty
         sumOfSequences.lastNum = s2.lastNum; 
         sumOfSequences.length = s2.length; 
         sumOfSequences.sum = s2.sum; 
         sumOfSequences.mean = sumOfSequences.sum / sumOfSequences.length; 
         sumOfSequences.maxNum = s2.maxNum; 
         sumOfSequences.minNum = s2.minNum; 
         return sumOfSequences; 
      } else { // The case where both s1 and s2 are empty
         return sumOfSequences; 
      }
   }


      
}