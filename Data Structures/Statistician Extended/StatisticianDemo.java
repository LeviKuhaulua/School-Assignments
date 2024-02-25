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
        
    }
}