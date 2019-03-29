import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo extends JPanel implements ActionListener {

  protected JEditorPane editorPane;
  protected JButton button_t2s;
  protected JButton button_s2t;

  private final static String newline = "\n";

  TranscriberDemo speech2Text;
  synthesisTest text2Speech;

  public TextDemo() {

    super(new GridBagLayout());

    try{
        speech2Text = new TranscriberDemo();
    }catch( Exception e)
    {
        System.out.println("Exception:"+e);
    }

    text2Speech = new synthesisTest();
    button_t2s = new JButton("Text To Speech");
    button_s2t = new JButton("Speech To Text");
    editorPane = new JEditorPane();

    JScrollPane scrollPane = new JScrollPane(editorPane);

    //Add Components to this panel.
    GridBagConstraints c = new GridBagConstraints();

    c.gridheight = 1;
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.insets = new Insets(5,5,2,5);
    c.fill = GridBagConstraints.BOTH;
    c.gridy = 0;
    c.weightx = 1;
    c.weighty = 1;
    add(scrollPane, c);

    GridBagConstraints c_button = new GridBagConstraints();
    c_button.insets = new Insets(2, 5, 5, 2);
    c_button.fill = GridBagConstraints.BOTH;
    c_button.weightx = 1;
    c_button.weighty = 0.1;

    c_button.insets = new Insets(2, 2, 5, 2);
    c_button.gridx = 0;
    c_button.gridy = 1;
    c_button.gridwidth = 1;
    c_button.gridheight = 1;
    add(button_t2s, c_button);

    c_button.gridx = 1;
    c_button.gridy = 1;
    c_button.gridwidth = 1;
    c_button.gridheight = 1;
    add(button_s2t, c_button);

    button_t2s.addActionListener(this);
    button_t2s.setActionCommand("text2speech");

    button_s2t.addActionListener(this);
    button_s2t.setActionCommand("speech2text");
    //add(button, c);
  }

  public void actionPerformed(ActionEvent evt) {

    //System.out.println(evt.getActionCommand());

    if (evt.getActionCommand().equals("text2speech")) {
      String text = editorPane.getText();
      text2Speech.read(text);
    }
    else if (evt.getActionCommand().equals("speech2text")) {
      String text = speech2Text.SpeechToText();
      editorPane.setText(editorPane.getText() + " " + text);
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
