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
    } 
}