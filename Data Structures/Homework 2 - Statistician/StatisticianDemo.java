import java.util.Scanner; 
public class StatisticianDemo {
    public static void main(String[] args) {
        // Statistician zeroCapacity = new Statistician(0); // Expected Output: IllegalArgumentException 
        // Statistician negativeCapacity = new Statistician(-1); // Expected Output: NegativeArraySizeException
        // Statistician notEnoughCapacity = new Statistician(Integer.MAX_VALUE); // Expected Output: OutOfMemoryError
        Statistician okayCapacity = new Statistician(15); // Expected Output: Okay
    }
}