
/**
 * Student
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * - name : String
 * - phoneNum : String 
 * - email : String
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * + Student()
 * + Student(name : String, phoneNum : String, email : String) 
 * + setName(name : String) : void
 * + setPhoneNum(phoneNum : String) : void
 * + setEmail(email : String) : void 
 * + getName() : String
 * + getPhoneNum() : String
 * + getEmail() : String
 * + toString() : String
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 *                                                                            ^
 *                                                                            |                           
 * Undergraduate                                                                                                                Graduate
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * - major : String                                                                                                             - fieldOfStudy : String
 * - genEdCredits : int                                                                                                         - numOfCredits : int
 * - majorCredits : int                                                                       
 * -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * + Undergraduate()                                                                                                            + Graduate() 
 * + Undergraduate(n : String, pN : String, e : String ,major : String, genEdCredits : int, majorCredits : int)                 + Graduate(n : String, pNum : String, e : String, fieldOfStudy : String, numOfCredits : int)
 * + setMajor(major : String) : void                                                                                            + setField(fieldOfStudy : String) : void
 * + setgenEdCredits(genEdCredits : int) : void                                                                                 + setNumCreds(numOfCredits : int) : void
 * + setMajorCredits(majorCredits : int) : void                                                                                 + getField() : String
 * + getMajor() : String                                                                                                        + getNumCreds() : int
 * + getGenEdCreds() : int                                                                                                      + toString() : String
 * + getMajorCreds() : int
 * + toString() : String
 */
public class Student {
    private String name, phoneNum, email; 
    
    /**
     * Student - no arg constructor that creates a blank student profile 
     */
    public Student() {
        name = phoneNum = email = "unknown"; 
    }

    /**
     * Student - creates a student profile with the arguments for name, phone number, and email
     * and sets the variables to their respective arguments. 
     * @param name - the Student's name
     * @param phoneNum - the Student's phone number
     * @param email - the Student's email
     */
    public Student(String name, String phoneNum, String email) {
        this.name = name; 
        this.phoneNum = phoneNum; 
        this.email = email; 
    }
    
    /**
     * setName - will set the person's name to whatever the user inputs. 
     * @param name - students name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setEmail - will set the student's email to whatever the user inputs
     * @param email - student's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * setPhoneNum - will set the student's phone number to whatever the user inputs 
     * @param phoneNum - the student's phone number
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    /**
     * getName - returns the student's name
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * getPhoneNum - returns the student's phone number
     * @return the student's phone number
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * getEmail - returns the student's email
     * @return the student's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * toString() - outputs the student's record and information
     * @return - the student's record and information. 
     */
    public String toString() {
        return "Student Record\n" + "Name: " + name 
        + "\nEmail: " + email + "\nPhone Number: " + phoneNum; 
    }
}
