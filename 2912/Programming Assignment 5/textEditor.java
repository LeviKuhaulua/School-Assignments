import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class textEditor extends JFrame {
    private JScrollPane textFileScrollPane; // Scroll pane to show contents of text files
    private JTextArea textFileContents; // to put text file content or have user create text file  
    // Menu components 
    private JMenuBar fileToolMenu; 
    private JMenu fileMenu; 
    private JMenuItem createTxtFile, openTxtFile, saveTxtFile, saveTxtFileAs, exitMenu; 

    private final String title = " - CSCI 2912 Editor"; // Title will end with " - CSCI 2912 Editor" 

    public textEditor() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(new Dimension(500, 500)); 
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout()); 
        this.setTitle("Untitled".concat(title));
        this.setResizable(true);

        
        configureScrollPane(); 
        setUpMenu(); 
         
        this.setVisible(true); 
    }

    /**
     * configureScrollPane is a private method to configure the text editor contents which is the scroll pane and 
     */
    private void configureScrollPane() {
        textFileContents = new JTextArea(); // Initializing text area 
        textFileContents.setLineWrap(false); // not allowing line wrap when user adds or edits texts - helps allow scroll bars 
        textFileScrollPane = new JScrollPane(textFileContents); // add text area to the scroll pane 
        this.setContentPane(textFileScrollPane); // setting the whole frame to be the text editor 
    }

    /**
     * setUpMenu is a private method that will configure the menu bar, menu, and menu items for the program 
     */
    private void setUpMenu() {
        // Creating Menu 
        fileToolMenu = new JMenuBar(); 

        // Creating Menu and Menu Items 
        fileMenu = new JMenu("File"); 
        createTxtFile = new JMenuItem("New"); 
        openTxtFile = new JMenuItem("Open"); 
        saveTxtFile = new JMenuItem("Save"); 
        saveTxtFileAs = new JMenuItem("Save As..."); 
        exitMenu = new JMenuItem("Exit"); 

        // Adding menu items to the menu bar
        fileMenu.add(createTxtFile); 
        fileMenu.add(openTxtFile); 
        fileMenu.addSeparator(); 
        fileMenu.add(saveTxtFile); 
        fileMenu.add(saveTxtFileAs); 
        fileMenu.addSeparator(); 
        fileMenu.add(exitMenu); 
        fileToolMenu.add(fileMenu); 
       
        // Setting menu bar to the frame 
        this.setJMenuBar(fileToolMenu);
    }    
}