import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.io.*; 

/**
 * @Author: Levi Kuhaulua
 * @Date: 4/29/2023
 * @Assignment: Programming Assignment 5
 * 
 * GUI application that acts as a simple text editor. Allows users to create, open, edit, and save files. 
 */

public class KuhauluaLevi5 extends JFrame {
    private JScrollPane textFileScrollPane; // Scroll pane to show contents of text files
    private JTextArea textFileContents; // to put text file content or have user create text file  
    // Menu components 
    private JMenuBar fileToolMenu; 
    private JMenu fileMenu; 
    private JMenuItem createTxtFile, openTxtFile, saveTxtFile, saveTxtFileAs, exitMenu; 
    private JFileChooser fileChooser; // for performing actions for files. 
    private File chosenFile; 

    private final String title = " - CSCI 2912 Editor"; // Title will end with " - CSCI 2912 Editor" 

    public KuhauluaLevi5() {
        // Configuring the frame 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(new Dimension(500, 500)); // Initial size of GUI 
        this.setLocationRelativeTo(null); // Make GUI centered to user's screen 
        this.setLayout(new FlowLayout()); 
        this.setTitle("Untitled".concat(title)); // Initial title of GUI 
        this.setResizable(true); // allow text editor to be resized 

        // Configure the components 
        configureScrollPane(); 
        setUpMenu(); 
        // Event action for when user clicks on 'new' menu item 
        createTxtFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFileContents.setText(null); // set the text area to empty 
                KuhauluaLevi5.this.setTitle("Untitled".concat(title)); // set title to default: "Untitled - CSCI 2912 Editor". 
            }

        });

        // Handling action when user clicks on 'Open' menu item
        openTxtFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(); // Initializing the file chooser
                try {
                    if (fileChooser.showOpenDialog(openTxtFile) == JFileChooser.APPROVE_OPTION) {
                        KuhauluaLevi5.this.setTitle(fileChooser.getSelectedFile().getName().concat(title)); // Updating title for text editor
                    }
                    
                    chosenFile = fileChooser.getSelectedFile().getAbsoluteFile();
                    
                    // Setting the file contents to the text area 
                     
                    FileInputStream fileInput = new FileInputStream(chosenFile); 
                    ByteArrayOutputStream fileContents = new ByteArrayOutputStream();
                    byte[] fileContentsBytes = new byte[(int) chosenFile.length()]; 
                    fileInput.read(fileContentsBytes); // taking all the characters in the file and adding them to a byte array 
                    fileContents.write(fileContentsBytes, 0, fileContentsBytes.length); // writing the bytes into an output stream 
                    textFileContents.setText(fileContents.toString()); // turning each byte into the string equivalent 
                    
                    // closing the contents 
                    fileInput.close(); 
                    fileContents.close(); 
                    
                } catch (IOException someIOException) { // catching any errors with opening the files 
                    JOptionPane.showMessageDialog(null, someIOException.getStackTrace(), "Error Opening File", JOptionPane.ERROR_MESSAGE, null); // error dialog for user
                }
            }
        });

        saveTxtFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser = new JFileChooser(); 
                try {
                    if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                        chosenFile = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
                    }

                    

                    PrintWriter savingFile = new PrintWriter(chosenFile); 
                    savingFile.write(textFileContents.getText()); 
                    savingFile.flush(); 
                    savingFile.close(); 
                } catch (IOException errorSavingFile) {
                    JOptionPane.showMessageDialog(null, errorSavingFile.getStackTrace(), "Error Saving File",JOptionPane.ERROR_MESSAGE, null); 
                }

                KuhauluaLevi5.this.setTitle(chosenFile.getName().concat(title)); 
            }
        });

        // Event handling for menu option 'save as...'
        saveTxtFileAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFileAs(); 
            }
        });

        // Exit Menu will terminate the application if user selects exit in file menu 
        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KuhauluaLevi5.this.dispose(); // terminating the application
            }
        });
         
        this.setVisible(true); 
    }

    /**
     * configureScrollPane is a private method to configure the text editor contents which is the scroll pane and 
     */
    private void configureScrollPane() {
        textFileContents = new JTextArea(); // Initializing text area 
        textFileContents.setMargin(new Insets(5, 5, 5, 5)); // margins for text area
        textFileContents.setLineWrap(false); // not allowing line wrap when user adds or edits texts - helps allow scroll bars 
        textFileContents.setFont(new Font("Monospace", Font.PLAIN, 14)); 
        textFileScrollPane = new JScrollPane(textFileContents); // add text area to the scroll pane 
        this.setContentPane(textFileScrollPane); // setting the whole frame to be the text editor 
    }

    /**
     * setUpMenu is a private method that will configure the menu bar, menu, and menu items for the program 
     */
    private void setUpMenu() {
        final int shortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(); // Get the default mask key 
        // Creating Menu 
        fileToolMenu = new JMenuBar(); 

        // Creating Menu and Menu Items 
        fileMenu = new JMenu("File"); 
        createTxtFile = new JMenuItem("New"); 
        openTxtFile = new JMenuItem("Open"); 
        saveTxtFile = new JMenuItem("Save"); 
        saveTxtFileAs = new JMenuItem("Save As..."); 
        exitMenu = new JMenuItem("Exit"); 
        
        // Setting Mnemonic keys for each file menu 
        fileMenu.setMnemonic(KeyEvent.VK_F); // Alt+f for file
        createTxtFile.setMnemonic(KeyEvent.VK_N); // n for new 
        openTxtFile.setMnemonic(KeyEvent.VK_O); // o for open 
        saveTxtFile.setMnemonic(KeyEvent.VK_S); // s for save
        saveTxtFileAs.setMnemonic(KeyEvent.VK_A); // a for save as
        exitMenu.setMnemonic(KeyEvent.VK_X); // x for exit 

        // Setting Accelerator for each menu item 
        createTxtFile.setAccelerator(KeyStroke.getKeyStroke('N', shortcutKeyMask)); // Ctrl+N for new
        openTxtFile.setAccelerator(KeyStroke.getKeyStroke('O', shortcutKeyMask)); // Ctrl+O for open
        saveTxtFile.setAccelerator(KeyStroke.getKeyStroke('S', shortcutKeyMask)); // Ctrl+S for save
        saveTxtFileAs.setAccelerator(KeyStroke.getKeyStroke('S', shortcutKeyMask + KeyEvent.SHIFT_DOWN_MASK)); // Ctrl+Shift+S for save as

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

    private void saveFileAs() {
        fileChooser = new JFileChooser(); 
        try {
            // If successful in choosing a file to save then get file 
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                chosenFile = new File(fileChooser.getSelectedFile().getAbsolutePath()); 
            } 

            
            
            // Creating a Print Writer to write to the file 
            PrintWriter savingFile = new PrintWriter(chosenFile); 
            savingFile.write(textFileContents.getText()); // writing the changes to the file 
            savingFile.close(); // closing the print writer 
        } catch (IOException errorSavingFileAs) {
            JOptionPane.showMessageDialog(null, errorSavingFileAs.getStackTrace(), "Error Saving File", JOptionPane.ERROR_MESSAGE, null); 
        }
                
        KuhauluaLevi5.this.setTitle(chosenFile.getName().concat(title)); // set the title to what the user named it. 
    }
}