import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 

public class textEditor extends JFrame {
    private JFrame textEditorFrame; // Frame for the text-editor 
    private JScrollPane textFileScrollPane; // Scroll pane to show contents of text files
    private JTextArea textFileContents; // to put text file content or have user create text file 
    // Menu components 
    private JMenuBar fileToolMenu; 
    private JMenu FileMenu; 
    private JMenuItem createTxtFile, openTxtFile, saveTxtFile, saveTxtFileAs, exitMenu; 

    private String title = " - CSCI 2912 Editor"; // Create title to include the 

    public textEditor() {
        textEditorFrame = new JFrame(); 
        textEditorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        textEditorFrame.setSize(new Dimension(600, 600));
        textEditorFrame.setLocationRelativeTo(null); 
        textEditorFrame.setLayout(new GridLayout()); 
        textEditorFrame.setTitle("Untitled".concat(title)); 

        textFileScrollPane = new JScrollPane(); 
        
        textEditorFrame.add(textFileScrollPane); 
        textEditorFrame.setVisible(true); 
    }
}