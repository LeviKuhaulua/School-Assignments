

public class StatisticianDemo {
    public static void main(String[] args) {

        /*
        * COMMENT OUT OTHER SECTIONS WHEN TRYING TO DEBUG CODE. 
        */

        
        /* LENGTH TESTING*/
        
        // Statistician lenStatistician = new Statistician(); 

        // System.out.println(lenStatistician.length()); // Expected Output: 0 

        // lenStatistician.nextNumber(1.1); 

        // System.out.println(lenStatistician.length()); // Expected Output: Length should increment

        /* END OF LENGTH TESTING */

        /* LAST NUMBER TESTING */
       
        // Statistician lastNumStatistician = new Statistician(); 

        // System.out.println(lastNumStatistician.lastNumber()); // Expected Output: Double.NaN
        
        // lastNumStatistician.nextNumber(10.22); 

        // System.out.println(lastNumStatistician.lastNumber()); // Expected Output: 10.22

        // lastNumStatistician.nextNumber(-0.2222); 
        // System.out.println(lastNumStatistician.lastNumber()); // Expected Output: -0.2222. 

        // lastNumStatistician.nextNumber(1.02); 
        // lastNumStatistician.nextNumber(5.87); 
        // lastNumStatistician.nextNumber(-1.22); 
        // System.out.println(lastNumStatistician.lastNumber()); // Expected Output: -1.22


        /* END OF LAST NUMBER TESTING */

        /* SUM TESTING */
        // Statistician sumStatistician = new Statistician(); 

        // System.out.println(sumStatistician.sum()); // Expected Output: 0; 

        // sumStatistician.nextNumber(10.0); 
        // System.out.println(sumStatistician.sum()); // Expected Output: 10
        
        // sumStatistician.nextNumber(5.0); 
        // sumStatistician.nextNumber(2.0);
        // System.out.println(sumStatistician.sum()); // Expected Output: 17.0

        // sumStatistician.nextNumber(-9.0); 
        // System.out.println(sumStatistician.sum()); // Expected Output: 8.0 

        // sumStatistician = new Statistician(); 
        // System.out.println(sumStatistician.sum());
        /* END OF SUM TESTING */

        /* MAXIMUM NUMBER TESTING */

        // Statistician maxStatistician = new Statistician(); 

        // System.out.println(maxStatistician.maximum()); // Expected Output: Double.NaN

        // maxStatistician.nextNumber(10.0); 

        // System.out.println(maxStatistician.maximum()); // Expected output: 10.0; 

        // maxStatistician.nextNumber(5.0); 
        // System.out.println(maxStatistician.maximum()); // Expected Output: 10.0; 
        // maxStatistician.nextNumber(100.0); 
        // maxStatistician.nextNumber(-100.0); 
        // maxStatistician.nextNumber(-90.99); 
        // System.out.println(maxStatistician.maximum()); // Expected Output: 100.0;

        // double max = maxStatistician.maximum(); 
        // maxStatistician.nextNumber(10.1);
        // maxStatistician.maximum(); 
        

        /* END OF MAX NUMBER TESTING */
        
        /* MIN NUMBER TESTING */
        // Statistician minStatistician = new Statistician(); 

        // System.out.println(minStatistician.minimum()); // Expected Output: Double.NaN

        // minStatistician.nextNumber(1.0); 
        // System.out.println(minStatistician.minimum()); // Expected Output: 1.0

        // minStatistician.nextNumber(10.0);
        // System.out.println(minStatistician.minimum()); // Expected Output: 1.0

        // minStatistician.nextNumber(10.0);
        // minStatistician.nextNumber(-10.0);
        // minStatistician.nextNumber(-100.1);

        // System.out.println(minStatistician.minimum()); // Expected Output: -100.1
        /* END OF MIN NUMBER TESTING */

        /* MEAN TESTING */

        // Statistician meanStatistician = new Statistician(); 

        // System.out.println(meanStatistician.mean());

        // meanStatistician.nextNumber(10.0); 

        // System.out.println(meanStatistician.mean()); // Expected Output: 10.0

        // meanStatistician.nextNumber(5.0); 
        // meanStatistician.nextNumber(5.0); 
        // meanStatistician.nextNumber(4.0); 
        // System.out.println(meanStatistician.mean()); // Expected Output: 6.0

        // meanStatistician.nextNumber(-1.0); 
        // meanStatistician.nextNumber(-46.0);
        // meanStatistician.nextNumber(-12.0);
        // System.out.println(meanStatistician.mean()); // Expected Output: -5.0

        /* END OF MEAN TESTING */

        /* BOUNDARY TESTING */
        Statistician checkBoundary = new Statistician(); 
        // checkBoundary.nextNumber(Double.NaN); 
        // System.out.println(checkBoundary.lastNumber());

        // Temporarily set length to public to adjust value. 
        // checkBoundary.length = Integer.MAX_VALUE; // Simulating when we have the max amount of double numbers in the sequence (Integer.MAX_VALUE)
        // System.out.println(checkBoundary.length());
        checkBoundary.nextNumber(10.0); 

        System.out.println(checkBoundary.length()); // Adding one more number to simulate overflow. 
        System.out.println(checkBoundary.lastNumber());
        checkBoundary.nextNumber(13.0); 
        System.out.println(checkBoundary.lastNumber());

        checkBoundary.nextNumber(Double.MAX_VALUE + Double.MAX_VALUE); // Checking for some arbitrarily large number.
        System.out.println(checkBoundary.lastNumber());

        checkBoundary.nextNumber(-Double.MAX_VALUE + -Double.MAX_VALUE); // Checking for some arbitrarily minimum number. 
        System.out.println(checkBoundary.lastNumber());
        
        
        /* END OF BOUNDARY TESTING */
    }
}