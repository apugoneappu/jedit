import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.datatransfer.*;

public class TextDemo extends JPanel implements ActionListener {

  protected JEditorPane editorPane;
  protected JButton button_t2s;
  protected JButton button_s2t;
  protected JButton button_open;
  protected JButton button_save;
  protected JButton button_new;
  protected JButton button_stop;
  protected JButton button_paste;

  Clipboard clipboard;


  private final static String newline = "\n";

  TranscriberDemo speech2Text;
  synthesisTest text2Speech;

  public TextDemo() {

    super(new GridBagLayout());

    try {
        speech2Text = new TranscriberDemo();
    }
    catch( Exception e)
    {
        System.out.println("Exception:"+e);
    }

    text2Speech = new synthesisTest();
    
    clipboard = Toolkit.getDefaultToolkit( ).getSystemClipboard( );
    button_t2s = new JButton("Text To Speech");
    button_s2t = new JButton("Speech To Text");
    button_open = new JButton("Open");
    button_save = new JButton("Save");
    button_new = new JButton("New");
    button_stop = new JButton("Stop");
    button_paste = new JButton("Paste");

    editorPane = new JEditorPane();

    JScrollPane scrollPane = new JScrollPane(editorPane);

    //Add Components to this panel.
    GridBagConstraints c = new GridBagConstraints();

    c.gridheight = 1;
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.insets = new Insets(5,5,2,5);
    c.fill = GridBagConstraints.BOTH;
    c.gridy = 1;
    c.weightx = 1;
    c.weighty = 1;
    add(scrollPane, c);

    GridBagConstraints c_button = new GridBagConstraints();
    c_button.insets = new Insets(2, 5, 5, 2);
    c_button.fill = GridBagConstraints.BOTH;
    c_button.weightx = 1;
    c_button.weighty = 0.1;
    c_button.gridwidth = 1;
    c_button.gridheight = 1;

    c_button.gridx = 0;
    c_button.gridy = 2;
    add(button_t2s, c_button);

    c_button.gridx = 1;
    c_button.gridy = 2;
    add(button_s2t, c_button);

    c_button.gridx = 2;
    c_button.gridy = 2;
    add(button_stop, c_button);

    c_button.gridx = 0;
    c_button.gridy = 0;
    add(button_open, c_button);

    c_button.gridx = 1;
    c_button.gridy = 0;
    add(button_save, c_button);

    c_button.gridx = 2;
    c_button.gridy = 0;
    add(button_new, c_button);
    
    c_button.gridx = 0;
    c_button.gridy = 3;
    add(button_paste, c_button);

    button_t2s.addActionListener(this);
    button_t2s.setActionCommand("text2speech");

    button_s2t.addActionListener(this);
    button_s2t.setActionCommand("speech2text");
    
    button_open.addActionListener(this);
    button_open.setActionCommand("open");

    button_save.addActionListener(this);
    button_save.setActionCommand("save");

    button_new.addActionListener(this);
    button_new.setActionCommand("new");

    button_stop.addActionListener(this);
    button_stop.setActionCommand("stop");

    button_paste.addActionListener(this);
    button_paste.setActionCommand("paste");
  }

  public void actionPerformed(ActionEvent evt) {

    //System.out.println(evt.getActionCommand());

    // For text to speech command
    if (evt.getActionCommand().equals("text2speech")) {
      String text = editorPane.getText();
      text2Speech.read(text);
    }

    // For stoping the text to speech conversion
    if (evt.getActionCommand().equals("stop")) {
      text2Speech.stop();
    }

    // For speech to text command    
    if (evt.getActionCommand().equals("speech2text")) {

      if( speech2Text.listening == false)
      {  
        speech2Text.listening = true;
        String text = speech2Text.SpeechToText();
        editorPane.setText(editorPane.getText() + " " + text);
      }
      else
      {
        speech2Text.listening = false;
      }
    }

    // For open command
    if (evt.getActionCommand().equals("open")) {
      
      String filename = "";
      try{
        final JFileChooser fc = new JFileChooser();
        
        // Creates the dialogue box
        int r = fc.showOpenDialog(null); 
        
        // if the user selects a file 
        if (r == JFileChooser.APPROVE_OPTION) 
        { 
            // set the label to the path of the selected file 
            filename = fc.getSelectedFile().getAbsolutePath(); 
        } 

        File file = new File(filename); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String text; 
        while ((text = br.readLine()) != null) 
          editorPane.setText(editorPane.getText() + " \n" + text); 

      }catch(Exception e)
      {
         System.out.println("Exception:"+e);
      }
        
    }

    // For save command
    if (evt.getActionCommand().equals("save")) {

      String str = editorPane.getText(); 
      String filename = "";
      
      try{
        final JFileChooser fc = new JFileChooser();
                
        // Creates the dialogue box
        int r = fc.showSaveDialog(null); 
        
        // if the user selects a file 
        if (r == JFileChooser.APPROVE_OPTION) 
        { 
            // set the label to the path of the selected file 
            filename = fc.getSelectedFile().getAbsolutePath(); 
        }
        // attach a file to FileWriter  
        FileWriter fw = new FileWriter(filename); 
  
        // read character wise from string and write into FileWriter  
        for (int i = 0; i < str.length(); i++) 
            fw.write(str.charAt(i)); 
  
        fw.close(); 

      }catch(Exception e)
      {
         System.out.println("Exception:"+e);
      }
        
    }

    // For new command
    if (evt.getActionCommand().equals("new")) {

      // Before clearing all text prompt to save existing data
      String str = editorPane.getText(); 
      String filename = "";
      
      try{
        final JFileChooser fc = new JFileChooser();
        
        // Creates the dialogue box
        int r = fc.showSaveDialog(null); 
        
        // if the user selects a file 
        if (r == JFileChooser.APPROVE_OPTION) 
        { 
            // set the label to the path of the selected file 
            filename = fc.getSelectedFile().getAbsolutePath(); 
        }
        
        // attach a file to FileWriter  
        FileWriter fw = new FileWriter(filename); 
  
        // read character wise from string and write into FileWriter  
        for (int i = 0; i < str.length(); i++) 
            fw.write(str.charAt(i)); 
  
        fw.close(); 

      }catch(Exception e)
      {
         System.out.println("Exception:"+e);
      }

      str = " ";
      editorPane.setText(str); 
    }
    
    if (evt.getActionCommand().equals("paste")) {

      try {
         Transferable t = clipboard.getContents(null);
         if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
           String text = (String)t.getTransferData(DataFlavor.stringFlavor);
           editorPane.setText(editorPane.getText() + "" + text); 
         }
      }
      catch (UnsupportedFlavorException | IOException ex) {
          System.out.println("");
      }

    }


  }

  /**
   * Create the GUI and show it.  For thread safety,
   * this method should be invoked from the
   * event dispatch thread.
   */
  private static void createAndShowGUI() {
    //Create and set up the window.
    JFrame.setDefaultLookAndFeelDecorated(true);

    JFrame frame = new JFrame("TextDemo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setPreferredSize(new Dimension(800, 500));

    //Add contents to the window.
    frame.getContentPane().add(new TextDemo());

    frame.setIconImage(new ImageIcon("yo.png").getImage());

    //Display the window.
    frame.pack();
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    //Schedule a job for the event dispatch thread:
    //creating and showing this application's GUI.
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
