

public class StatisticianDemo {
    public static void main(String[] args) {

        /*
        * COMMENT OUT OTHER SECTIONS WHEN TRYING TO DEBUG CODE. 
        */
        
        /* LENGTH TESTING*/
        
        Statistician lenStatistician = new Statistician(); 

        System.out.println(lenStatistician.length()); // Expected Output: 0 

        lenStatistician.nextNumber(1.1); 

        System.out.println(lenStatistician.length()); // Expected Output: Length should increment

        /* END OF LENGTH TESTING */

        /* LAST NUMBER TESTING */
       
        Statistician lastNumStatistician = new Statistician(); 

        System.out.println(lastNumStatistician.lastNumber()); // Expected Output: Double.NaN
        
        lastNumStatistician.nextNumber(10.22); 

        System.out.println(lastNumStatistician.lastNumber()); // Expected Output: 10.22

        lastNumStatistician.nextNumber(-0.2222); 
        System.out.println(lastNumStatistician.lastNumber()); // Expected Output: -0.2222. 

        lastNumStatistician.nextNumber(1.02); 
        lastNumStatistician.nextNumber(5.87); 
        lastNumStatistician.nextNumber(-1.22); 
        System.out.println(lastNumStatistician.lastNumber()); // Expected Output: -1.22


        /* END OF LAST NUMBER TESTING */

        /* SUM TESTING */
        Statistician sumStatistician = new Statistician(); 

        System.out.println(sumStatistician.sum()); // Expected Output: 0; 

        sumStatistician.nextNumber(10.0); 
        System.out.println(sumStatistician.sum()); // Expected Output: 10
        
        sumStatistician.nextNumber(5.0); 
        sumStatistician.nextNumber(2.0);
        System.out.println(sumStatistician.sum()); // Expected Output: 17.0

        sumStatistician.nextNumber(-9.0); 
        System.out.println(sumStatistician.sum()); // Expected Output: 8.0 
        /* END OF SUM TESTING */

        /* MAXIMUM NUMBER TESTING */

        Statistician maxStatistician = new Statistician(); 

        System.out.println(maxStatistician.maximum()); // Expected Output: Double.NaN

        maxStatistician.nextNumber(10.0); 

        System.out.println(maxStatistician.maximum()); // Expected output: 10.0; 

        maxStatistician.nextNumber(5.0); 
        System.out.println(maxStatistician.maximum()); // Expected Output: 10.0; 
        maxStatistician.nextNumber(100.0); 
        System.out.println(maxStatistician.maximum()); // Expected Output: 100.0;
        

        /* END OF MAX NUMBER TESTING */
        
        /* MIN NUMBER TESTING */
        Statistician minStatistician = new Statistician(); 

        System.out.println(minStatistician.minimum()); // Expected Output: Double.NaN

        minStatistician.nextNumber(1.0); 
        System.out.println(minStatistician.minimum()); // Expected Output: 1.0

        minStatistician.nextNumber(10.0);
        System.out.println(minStatistician.minimum()); // Expected Output: 1.0

        minStatistician.nextNumber(10.0);
        minStatistician.nextNumber(-10.0);
        minStatistician.nextNumber(-100.1);

        System.out.println(minStatistician.minimum()); // Expected Output: -100.1
        /* END OF MIN NUMBER TESTING */
    }
}