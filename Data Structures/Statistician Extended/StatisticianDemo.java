public class StatisticianDemo {
    public static void main(String[] args) { 

        // Creating Statistician objects for testing. 
        Statistician a = new Statistician(); 
        a.nextNumber(2.0);
        a.nextNumber(-10.0); 
        a.nextNumber(5.0); 

        Statistician c = new Statistician(); 
        c.nextNumber(-10.0); 
        c.nextNumber(-10.0); 
        c.nextNumber(-100.0); 

        // Empty Statistician for testing. 
        Statistician s1 = new Statistician(); 
        Statistician s2 = new Statistician(); 


        // Testing for adding empty Statisticians
        Statistician addTest = Statistician.add(s1, s2); 
        System.out.println("Adding two empty Statisticians s1 and s2");
        System.out.println("Length: Expected = 0 | Actual = " + addTest.length());
        System.out.println("Sum: Expected = 0 | Actual = " + addTest.sum());
        System.out.println("Is Mean NaN? " + Double.isNaN(addTest.mean()));
        System.out.println("Is Maximum NaN? " + Double.isNaN(addTest.maximum()));
        System.out.println("Is Minimum NaN? " + Double.isNaN(addTest.minimum()));
        System.out.println("Is Last Number NaN? " + Double.isNaN(addTest.lastNumber()));
        
        
        // Testing when one Statistician is empty 
        addTest = Statistician.add(a, s2); 
        // Expected Output: all statistics should be from Statistician a 
        System.out.println("\nAdding a non-empty Statistician with an empty one");
        System.out.println(
            "Length: Expected = 3 | Actual = " + addTest.length() + "\n"
            + "Sum: Expected = -3.0 | Actual = " + addTest.sum() + "\n"
            + "Mean: Expected = -1.0 | Actual = " + addTest.mean() + "\n"
            + "Maximum: Expected = 5.0 | Actual = " + addTest.maximum() + "\n"
            + "Minimum: Expected = -10.0 | Actual = " + addTest.minimum() + "\n" 
            + "Last Number: Expected = 5.0 | Actual = " + addTest.lastNumber()
        );

        addTest = Statistician.add(s1, c); 
        System.out.println("\nAdding an empty Statistician with a non-empty one");
        // Expected Output: All statistics should follow from Statistician c 
        System.out.println(
            "Length: Expected = 3 | Actual = " + addTest.length() + "\n"
            + "Sum: Expected = -120.0 | Actual = " + addTest.sum() + "\n"
            + "Mean: Expected = -40.0 | Actual = " + addTest.mean() + "\n"
            + "Maximum: Expected = -10.0 | Actual = " + addTest.maximum() + "\n"
            + "Minimum: Expected = -100.0 | Actual = " + addTest.minimum() + "\n" 
            + "Last Number: Expected = -100.0 | Actual = " + addTest.lastNumber()
        );

        // Testing when both Statisticians are not empty
        addTest = Statistician.add(a, c); 
        // Expected Output: Statistics will be a new result calculated based on statistics of both sequences. 
        System.out.println("\nAdding two non-empty Statisticians together");
        System.out.println(
            "Length: Expected = 6 | Actual = " + addTest.length() + "\n"
            + "Sum: Expected = -123.0 | Actual = " + addTest.sum() + "\n"
            + "Mean: Expected = " + ((a.sum() + c.sum()) / 6) + " | Actual = " + addTest.mean() + "\n" 
            + "Maximum: Expected = " + (Double.max(a.maximum(), c.maximum())) + " | Actual = " + addTest.maximum() + "\n"
            + "Minimum: Expected = " + (Double.min(a.minimum(), c.minimum())) + " | Actual = " + addTest.minimum() + "\n" 
            + "Last Number: Expected = " + c.lastNumber() + " | Actual = " + addTest.lastNumber()
        );

        // Test to ensure that Statistician instance still works when feeding another number and calling methods. 
        System.out.println("\nEnsuring that nextNumber and calling methods will update statistics.");
        addTest = Statistician.add(s1, s2); 
        addTest.nextNumber(5.0); 
        addTest.nextNumber(15.0); 
        addTest.nextNumber(-65.0);

        System.out.println("Length: Expected = 3 | Actual = " + addTest.length());
        System.out.println("Last Number: Expected = -65.0 | Actual = " + addTest.lastNumber());
        System.out.println("Sum: Expected = -45.0 | Actual = " + addTest.sum());
        System.out.println("Mean: Expected = -15.0 | Actual = " + addTest.mean());
        System.out.println("Maximum: Expected = 15.0 | Actual = " + addTest.maximum());
        System.out.println("Minimum: Expected = -65.0 | Actual = " + addTest.minimum());

        // Boundary Testing 
        System.out.println("\nBoundary Testing: ");
        Statistician nullStatistician = null; 
        // addTest = Statistician.add(a, nullStatistician); // Will get a Null Pointer Exception  

        /*
           In this section, I temporarily set the private variable length to public to play with value
           
           Statistician maxLength = new Statistician(); 
           maxLength.length = Integer.MAX_VALUE; 
           addTest = Statistician.add(maxLength, a); 
           System.out.println("Length: " + addTest.length()); // Will result in an Arithmetic Overflow
        */
        
        // Arbitrarily Large Positive Numbers
        // a.nextNumber(Double.MAX_VALUE); 
        // c.nextNumber(Double.MAX_VALUE); 

        // addTest = Statistician.add(a, c); 
        // System.out.println("Maximum: " + addTest.maximum()); 
        // System.out.println("Sum: " + addTest.sum()); // Adding arbitrarily large numbers can result in positive infinity
        // System.out.println("Mean: " + addTest.mean()); // Finding the mean based where the sum is infinity will also result in positive infinity

        // Arbitrarily Large Negative Numbers
        // a.nextNumber(-Double.MAX_VALUE); 
        // c.nextNumber(-Double.MAX_VALUE); 

        // addTest = Statistician.add(a, c); 
        // System.out.println("Sum: " + addTest.sum()); // Adding arbitrarily large negative numbers can result in negative infinity
        // System.out.println("Mean: " + addTest.mean()); // This means that the mean can also result in negative infinity ^. 

        // Testing Maximum and Minimum
        // a.nextNumber(Double.MAX_VALUE + Double.MAX_VALUE); // to make this result in positive infinity
        // c.nextNumber(-Double.MAX_VALUE + -Double.MAX_VALUE); // to make this result in negative infinity

        // addTest = Statistician.add(a, c); 
        // System.out.println("Maximum: " + addTest.maximum()); // can result in positive infinity for arbitrarily large positive values
        // System.out.println("Minimum: " + addTest.minimum()); // can result in negative infinity for arbitrarily large negative values
        
    }
} 
