/**
 * Textbook class 
 * Textbook inherits the Book class
 * 
 * Helps with changing and getting information for textbooks
 */
public class Textbook extends Book {
    // Field 
    private int grade; // What grade textbook is meant for.

    // Constructor
    public Textbook (String type, String title, String ISBN, String author, String publisher, String date, int grade) {
        super(type, title, ISBN, author, publisher, date); 
        this.grade = grade; 
    }

    /**
     * setGrade will set the grade of the textbook (high school, elementary, university)
     * @param grade
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }

    /**
     * getGrade will return the grade that textbook is meant for 
     * @return grade of textbook 
     */
    public int getGrade() {
        return grade;
    }

    /**
     * show() method will output information of the textbook 
     */
    @Override 
    public void show() {
        System.out.println(
            "Title: " + super.getTitle()
            + "\nISBN: " + super.getISBN()
            + "\nPublisher: " + super.getPublisher()
            + "\nAuthor: " + super.getAuthor()
            + "\nDate: " + super.getDate()
            + "\nGrade: " + grade
        );
    }
}
