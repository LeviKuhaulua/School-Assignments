public class demo {
    public static void main(String[] args) {
        // List of publications 
        Publication[] publicationList = new Publication[5]; 
        publicationList[0] = new Book("Book", "Friday the 14th", "A-0010", "Jason Norway", "Crystal Lake Inc.", "04/14/1998"); 
        publicationList[1] = new Textbook("Textbook", "Math for Dummies", "A-0012", "Mr. Bean", "Math Help", "10/16/2021", 11);
        publicationList[2] = new Magazine("Magazine", "CookingxKenshin", "A-0014", "Shogun Studios", "01/15/2003", "Slice of Life"); 
        publicationList[3] = new Magazine("Magazine", "Ecosystems of the Amazon", "A-0016", "National Geographic", "01/20/2003", "Informational");
        publicationList[4] = new Book("Book", "The Alchemist", "A-0018", "Paulo Coelho", "Alchemical Inc.", "05/16/2007");

        // Outputting information of each publication
        for (int i = 0; i < publicationList.length; i++) {
            System.out.println("Publication: " + (i + 1));
            publicationList[i].show(); 
            System.out.println();
        }

        // Change publisher for all books 
        for (int i = 0; i < publicationList.length; i++) {
            // Implementing interface for each element in array 
            Publisher changePublisher = (Publisher) publicationList[i]; 
            changePublisher.setPublisher("IEEE"); 
            System.out.println(changePublisher.getPublisher());
        }
        
        
    }
}