
/**
 * FreezingAndBoiling
 * --------------------------------------
 * -temp : double
 * --------------------------------------
 * + FreezingAndBoiling()
 * + FreezingAndBoiling(temp : double) 
 * + setTemp(temp : double) : void
 * + getTemp() : double
 * + isEthylFreezing() : boolean
 * + isEthylBoiling() : boolean
 * + isOxygenFreezing() : boolean
 * + isOxygenBoiling() : boolean
 * + isWaterFreezing() : boolean
 * + isWaterBoiling() : boolean
 * + toString() : String
 */




public class FreezingAndBoiling {
    private double temp; // theoretical temperature of a substance

    /**
     * FreezingAndBoiling - no arg constructor that sets the temperature to 0.0
     */
    public FreezingAndBoiling() {
        temp = 0.0;
    }

    /**
     * FreezingAndBoiling - a constructor with parameter temperature and sets the value of temp to that parameter. 
     * @param temperature - the temperature of a substance
     */
    public FreezingAndBoiling(double temperature) {
        this.temp = temperature;
    }

    /**
     * setTemp - will set the temperature of a substance.
     * @param temp - temperature of a substance
     */
    public void setTemp(double temp) {
        this.temp = temp;
    }

    /**
     * getTemp - will return the temperature of the object
     * @return temp - the temperature of a substance
     */
    public double getTemp() {
        return temp;
    }

    /**
     * isEthylFreezing - will check to see if the temperature will make Ethyl Alcohol freeze
     * @return will return true/false depending if it has met the condition or not
     */
    public boolean isEthylFreezing() {
        if(temp <= -173) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isEthylBoiling - will check to see if the temperature will make Ethyl Alcohol boil.
     * @return will return true/false depending if it has met the condition or not
     */
    public boolean isEthylBoiling() {
        if (temp >= 172) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isOxygenFreezing - will check to see if the temperature will make Oxygen freeze.
     * @return will return true/false depending if it has met the condition or not
     */
    public boolean isOxygenFreezing() {
        if (temp <= -362) {
            return true; 
        }
        else {
            return false; 
        }
    }

    /**
     * isOxygenBoiling - will check to see if the temperature will make Oxygen boil.
     * @return will return true/false depending if it has met the condition or not
     */
    public boolean isOxygenBoiling() {
        if (temp >= 306) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isWaterFreezing - will check to see if the temperature will make Water freeze.
     * @return will return true/false depending if it has met the condition or not
     */
    public boolean isWaterFreezing() {
        if (temp <= 32) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * isWaterBoiling - will check to see if the temperature will make Water boil.
     * @return will return true/false depending if it has met the condition or not
     */
    public boolean isWaterBoiling() {
        if (temp >= 212) {
            return true; 
        }
        else {
            return false;
        }
    }
    
    /**
     * toString - will output a statement on if substance is used or not
     * @return a statement on which substances are going to be freezing/boiling. 
     */
    public String toString() {
        return "These substances will boil/freeze";
    }
}
