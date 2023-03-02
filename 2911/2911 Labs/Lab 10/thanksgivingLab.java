/*
 * @Author: Levi Kuhaulua
 * @Date: 11/04/2022
 * 
 * Assignment: Thanksgiving Arrays 
 * 
 * Algorithm: 
 * Create two arrays that contain: 
 * - 5 favorite Thanksgiving Foods 
 * - The cost of those food items 
 * Creating the following methods: 
 * - One called printFood that outputs the food items
 * - One called printAll that outputs both the food and the cost of them
 * - Value returning method totalCost that returns the total cost of all the products 
 * - Value returning method averageCost that returns the average cost of the products
 * - Value returning method randomFoodItem that returns a randomly selected food item
 */
import java.util.*; 


public class thanksgivingLab {
    public static void main(String[] args) {
        // arrays for the Thanksgiving food items and their respective costs
        String[] foods = {"Turkey", "Mashed Potatoes", "Green Beans", "Yams", "Pumpkin Pie"};
        double[] costs = {28.99,8.75, 9.98, 13.25, 10.89};
        double costAll = totalCost(costs); // setting the total cost of the products
        
        
        printFood(foods); // output all the food options
        System.out.println("--"); // seperator
        printAll(foods, costs); // output all the foods and the cost of them
        System.out.println("Total Cost of Products:  $" + costAll); // output the total cost
        System.out.printf("Average Cost of Products:  $%.2f\n", averageCost(costs, costAll)); // output the average cost
        System.out.println("Randomly Selected Food: " + randomFoodItem(foods)); // output a randomly selected food
        // will find the cheapest and most expensive food option and output them
        findMin(costs, foods);
        findMax(costs, foods);

    }

    /**
     * printFood - void method that takes in the food items within an array and outputs them. 
     * @param foodArray - the array of the food items 
     */
    public static void printFood(String[] foodArray) {
        System.out.println("Thanksgiving Foods: ");
        for (int i = 0; i < foodArray.length; i++) {
            System.out.println(foodArray[i]);
        }
    }

    /**
     * printAll - void method that outputs the food items and their respective costs. 
     * @param foodArray - the array that contains the food items
     * @param costArray - the array that contains the cost of those food items
     */
    public static void printAll(String[] foodArray, double[] costArray) {
        System.out.println("Thanksgiving Foods and their Cost: ");
        for(int i = 0; i < foodArray.length && i < costArray.length; i++) {
            System.out.printf("%-20s%.2f\n", foodArray[i], costArray[i]);
        }
    }

    /**
     * totalCost - Takes in the cost array and then finds the total cost of the products and returns it. 
     * @param costArray - the array that contains the cost of the products
     * @return total - the total cost of the all the products; 
     */
    public static double totalCost(double[] costArray) {
        double total = 0.0; // accumulator 
        for(int i = 0; i < costArray.length; i++) {
            total += costArray[i];
        }
        return total;
    }
    /**
     * averageCost - will find the average cost of all the products 
     * @param costArray - the array that contains the cost of the products
     * @param totalCost - the total cost of all the products
     * @return average cost which is the total cost divided by the array lenght of costArray. 
     */
    public static double averageCost(double[] costArray, double totalCost) {
        return (totalCost/costArray.length); 
    }

    /**
     * randomFoodItem - will randomly select a food item in the array
     * @param foodArray - the array that contains all the food items
     * @return A randomly selected food item in the array. 
     */
    public static String randomFoodItem(String[] foodArray) {
        Random randNum = new Random(); 
        int foodItem = randNum.nextInt(foodArray.length); 
        return foodArray[foodItem];
    }
    /**
     * findMin - comparing the food prices and then outputting the cheapest food (not the price)
     * @param costArray - the array containing all the costs for the respective food items
     * @param foodArray - the array containing all the food products within an array
     */
    public static void findMin(double[] costArray, String[] foodArray) {
        double lowest = costArray[0]; 
        int count = 0; 
        for(int i = 0; i < costArray.length; i++) {
            if (lowest > costArray[i]) {
                lowest = costArray[i]; 
                count = i;
            }
        }
        
        System.out.println("Cheapest Food: " + foodArray[count]);
    }

    /**
     * findMax - compare each food item and then output the most expensive food (not the price)
     * @param costArray - the array containing all the costs of the food items
     * @param foodArray - the array containing all the food products
     */
    public static void findMax(double[] costArray, String[] foodArray) {
        double highest = costArray[0]; 
        int count = 0; 
        for (int i = 0; i < costArray.length; i++) {
            if (highest < costArray[i]) {
                highest = costArray[i]; 
                count = i;
            }
        }
        System.out.println("Most Expensive Food: " + foodArray[count]);
    }
}
