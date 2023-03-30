/**
 * Publication
 * Abstract class to help with creating and outputting information based on the type of publication
 */

public abstract class Publication {
    // Fields 
    private String title, ISBN; 

    // Constructor 
    public Publication(String type, String title, String ISBN) {
        this.title = title; 
        this.ISBN = ISBN; 
    }

    /**
     * setTitle - sets the title of a publication
     * @param title of the publication
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * getTitle - returns the title of publication
     * @return title of the publication
     */
    public String getTitle() {
        return title;
    }

    /**
     * setISBN - sets the ISBN of a publication
     * @param ISBN of publication
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * getISBN - returns the ISBN of the publication
     * @return ISBN of publication
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * show - an abstract method to help with outputting information for publications
     */
    public abstract void show(); 
}