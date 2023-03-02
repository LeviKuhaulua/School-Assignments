
/* 
 * Graduate
 * ----------------------------------------------------------------------------------------------
 * - fieldOfStudy : String
 * - numOfCredits : int
 * ----------------------------------------------------------------------------------------------
 * + Graduate() 
 * + Graduate(n : String, pNum : String, e : String, fieldOfStudy : String, numOfCredits : int)
 * + setField(fieldOfStudy : String) : void
 * + setNumCreds(numOfCredits : int) : void
 * + getField() : String
 * + getNumCreds() : int
 * + toString() : String
 *  
*/
public class Graduate extends Student {
    private String fieldOfStudy; 
    private int numOfCredits; 
    
    /**
     * Graduate() - no arg constructor that creates a blank Graduate student profile
     */
    public Graduate() {
        super(); 
        fieldOfStudy = "unknown"; 
        numOfCredits = 0; 
    }

    /**
     * 
     * @param n - student's name
     * @param pNum - student's phone number
     * @param e - student's email
     * @param fieldOfStudy - Graduate Student's field of study
     * @param numOfCredits - Amount of credits needed for Graduate. 
     */
    public Graduate(String n, String pNum, String e, String fieldOfStudy, int numOfCredits) {
        super(n, pNum, e); 
        this.fieldOfStudy = fieldOfStudy; 
        this.numOfCredits = numOfCredits; 
    }

    /**
     * setField - sets the graduate student's field of study
     * @param fieldOfStudy - Graduate's field of study
     */
    public void setField(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    /**
     * setNumOfCredits - sets the number of credits for the student's field of study
     * @param numOfCredits - number of credits required for student to graduate
     */
    public void setNumOfCredits(int numOfCredits) {
        this.numOfCredits = numOfCredits;
    }

    /**
     * getField - returns the field of study for the graduate
     * @return Graduate's field of study
     */
    public String getField() {
        return fieldOfStudy;
    }

    /**
     * getNumOfCredits - returns the student's number of credits needed to graduate 
     * @return number of credits for student to graduate
     */
    public int getNumOfCredits() {
        return numOfCredits;
    }

    /**
     * toString - outputs the student's information
     * @returns Graduate Student's profile
     */
    @Override
    public String toString() {
        return super.toString() + "\nField of Study" + fieldOfStudy
        + "\nCredits Needed to Graduate: " + numOfCredits;
    }
}
