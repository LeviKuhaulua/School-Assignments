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

        createTxtFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Created Text File");
            }

        });

        openTxtFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Opening Text File");
            }
        });

        saveTxtFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving File");
            }
        });

        saveTxtFileAs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Saving this file as...");
            }
        }); 

        exitMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textEditor.this.dispose(); // terminating the application
            }
        });
         
        this.setVisible(true); 
    }

    /**
     * configureScrollPane is a private method to configure the text editor contents which is the scroll pane and 
     */
    private void configureScrollPane() {
        textFileContents = new JTextArea(); // Initializing text area 
        textFileContents.setLineWrap(false); // not allowing line wrap when user adds or edits texts - helps allow scroll bars 
        textFileContents.setFont(new Font("Monospace", Font.PLAIN, 14)); 
        textFileScrollPane = new JScrollPane(textFileContents); // add text area to the scroll pane 
        this.setContentPane(textFileScrollPane); // setting the whole frame to be the text editor 
    }

    /**
     * setUpMenu is a private method that will configure the menu bar, menu, and menu items for the program 
     */
    private void setUpMenu() {
        final int shortcutKeyMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx(); 
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
}