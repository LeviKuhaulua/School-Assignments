

public class StatisticianDemo {
    public static void main(String[] args) {
        
        /* LENGTH TESTING*/
        
        Statistician lenStatistician = new Statistician(); 

        System.out.println(lenStatistician.length()); // Expected Output: 0 

        lenStatistician.nextNumber(1.1); 

        System.out.println(lenStatistician.length()); // Expected Output: Length should increment

        /* END OF LENGTH TESTING */
    }
}