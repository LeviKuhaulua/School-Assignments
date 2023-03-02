
/* 
Undergraduate                                                                                                                
 * --------------------------------------------------------------------------------------------------------------------------
 * - major : String                                                                                                      
 * - genEdCredits : int                                                                                                     
 * - majorCredits : int 
 * -----------------------------------------------------------------------------------------------------------------------------
 * + Undergraduate()                                                                                                            
 * + Undergraduate(n : String, pN : String, e : String ,major : String, genEdCredits : int, majorCredits : int)                 
 * + setMajor(major : String) : void                                                                                            
 * + setgenEdCredits(genEdCredits : int) : void                                                                                 
 * + setMajorCredits(majorCredits : int) : void                                                                                 
 * + getMajor() : String                                                                                                        
 * + getGenEdCreds() : int                                                                                                      
 * + getMajorCreds() : int
 * + toString() : String
*/
public class Undergraduate extends Student{
    private String major; 
    private int genEdCredits, majorCredits;

    /**
     * Undergraduate() - no arg constructor that creates a blank undergrad student profile
     */
    public Undergraduate() {
        super(); 
        major = "unknown"; 
        genEdCredits = majorCredits = 0; 
    }

    /**
     * Undergraduate() - takes in the arguments for an undergrad student's profile plus their major, general education requirements
     * and major credit requirements
     * @param n - student's name
     * @param pN - student's phone number
     * @param e - student's email
     * @param major - student's major
     * @param genEdCredits - student's amount of General Education Credits needed
     * @param majorCredits - student's amount of credits for their major needed
     */
    public Undergraduate(String n, String pN, String e, String major, int genEdCredits, int majorCredits) {
        super(n, pN, e); 
        this.major = major; 
        this.genEdCredits = genEdCredits; 
        this.majorCredits = majorCredits;
    }

    /**
     * setMajor - set the student's major 
     * @param major - student's major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * setGenEdCredits - set the student's general education requirements
     * @param genEdCredits - student's amount of Gen Ed credits needed
     */
    public void setGenEdCredits(int genEdCredits) {
        this.genEdCredits = genEdCredits;
    }
    
    /**
     * setMajorCredits - sets the student's major credits requirements
     * @param majorCredits - the amount of major credits required for the students
     */
    public void setMajorCredits(int majorCredits) {
        this.majorCredits = majorCredits;
    }

    /**
     * getMajor - returns the student's major
     * @return student's major
     */
    public String getMajor() {
        return major;
    }

    /**
     * getGenEdCredits - returns the General Education requirements
     * @return the amount of General Education Credits needed
     */
    public int getGenEdCredits() {
        return genEdCredits;
    }

    /**
     * getMajorCredits - returns the Major Credits needed
     * @return the amount of credits for their major
     */
    public int getMajorCredits() {
        return majorCredits;
    }

    
    @Override
    /**
     * toString() - output the student's profile 
     * @return Undergraduate Student's information
     */
    public String toString() {
        return super.toString() + "\nMajor" + major
        + "\nGeneral Education Requirements: " + genEdCredits + " Credits"
        + "\nMajor Course Credit Requirements: " + majorCredits + " Credits";
    }
}
