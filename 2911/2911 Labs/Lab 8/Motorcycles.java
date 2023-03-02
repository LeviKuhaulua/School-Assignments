


/* 
Class Diagram
---------------------------------
Motorcyles
---------------------------------
- year: int
- make: String
- speed: int
---------------------------------
+ Motorcycles()
+ Motorcycles(yr: int, brand: String)
+ getYear() : int 
+ getMake() : String
+ getSpeed() : int
+ speedUp() : void
+ slowDown() : void 
+ toString() : String
*/


public class Motorcycles {
    private int year, speed; 
    private String make; 

    /**
     * Constructor 
     * @param yr - the year of the motorcyle
     * @param brand - the brand of the motorcyle
     */
    public Motorcycles(int yr, String brand) {
       year = yr;
       make = brand;
       speed = 0;
    }
    /**
     * Constructor
     * no arg setting the year and speed to 0;
     */
    public Motorcycles() {
        year = 0;
        speed = 0;
        make = "unknown";
    }

    /**
     * getYear - will return the year of the motorcyle (when it was made)
     * @return year - the year of the motorcycle
     */
    public int getYear() {
        return year; 
    }
    /**
     * getSpeed - will return the speed of the motorcyle
     * @return speed - the speed of the motorcycle 
     */
    public int getSpeed() {
        return speed; 
    }
    /**
     * getMake - will return the make or brand of the motorcyle 
     * @return make - the brand of the car
     */
    public String getMake() {
        return make; 
    }

    /**
     * speedUp - void function that will add 5 to the speed
     */
    public void speedUp() {
        speed = speed + 5;
    }

    /**
     * slowDown - a void function that will minus 5 to the speed
     */
    public void slowDown() {
        speed = speed - 5; 
    }
    
    /**
     * toString - output the motorcycles speed in a nice format
     * @return A statement of how fast the year and make of a motorcycle is going in miles per hour. 
    */
    public String toString() {
        return "A " + year + " " + make + " going " + speed + " miles per hour."; 
    }

}
