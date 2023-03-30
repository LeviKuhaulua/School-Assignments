/**
 * Magazine Class
 * Inherits from Publication class and implements the Publisher interface 
 * 
 * Helps with changing and getting information from magazine type publications
 */
public class Magazine extends Publication implements Publisher {
    // Fields
    private String publisher, date, style; 

    // Constructor
    public Magazine(String type, String title, String ISBN, String publisher, String date, String style) {
        super(type, title, ISBN); 
        this.publisher = publisher; 
        this.date = date; 
        this.style = style; 
    }

    /**
     * setDate will set the date that a magazine was published 
     * @param The date magazine was published
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * setPublisher will set the publisher of a magazine
     * @param publisher of the magazine
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * setStyle will set the style or type of the magazine
     * @param style or type of magazine 
     */
    public void setStyle(String style) {
        this.style = style;
    }

    /**
     * getDate will return the date that magazine was published
     * @return the date magazine was published
     */
    public String getDate() {
        return date;
    }

    /**
     * getPublisher will return the publisher of a magazine
     * @return the publisher of the magazine
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * getStyle will return the style or type of magazine 
     * @return the style/type of magazine
     */
    public String getStyle() {
        return style;
    }

    /**
     * show() will output information on magazine 
     */
    @Override 
    public void show() {
        System.out.println(
            "Title: " + super.getTitle()
            + "\nISBN: " + super.getISBN()
            + "\nPublisher: " + publisher
            + "\nDate: " + date
            + "\nStyle: " + style
        );
    }
}