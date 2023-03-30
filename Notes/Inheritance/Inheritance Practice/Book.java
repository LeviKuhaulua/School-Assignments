/**
 * Book Class 
 * Inherits from Publication Class and implements the Publisher interface
 *
 * Meant to help with getting or changing information for publications that are books. 
 */
public class Book extends Publication implements Publisher {
    // Fields 
    private String author, publisher, date; 

    // Constructor 
    public Book(String type, String title, String ISBN, String author, String publisher, String date) {
        super(type, title, ISBN); 
        this.author = author; 
        this.publisher = publisher; 
        this.date = date; 
    }

    /**
     * getAuthor - will return the author of a book 
     * @return returns the author of a book 
     */
    public String getAuthor() {
        return author;
    }

    /**
     * getDate - will return the date of a book 
     * @return returns the date of the book 
     */
    public String getDate() {
        return date;
    }

    /**
     * getPublisher - returns the publisher of a book 
     * @return returns the publisher of a book 
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * setAuthor - sets the author of a book 
     * @param Author of the book 
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * setDate - sets the date the book was published
     * @param the date book was published 
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * setPublisher - sets the publisher of the book 
     * @param publisher of the book 
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * show() outputs the information of a book. 
     */
    @Override
    public void show() {
        System.out.println(
            "Title: " + super.getTitle() 
            + "\nISBN: " + super.getISBN() 
            + "\nPublisher: " + publisher
            + "\nAuthor: " + author
            + "\nDate: " + date
        );

    }
}