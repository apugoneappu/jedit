import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo extends JPanel implements ActionListener {

  protected JEditorPane editorPane;
  protected JButton button_t2s;
  protected JButton button_s2t;
  private final static String newline = "\n";
  synthesisTest speech2Text;

  public TextDemo() {

    super(new GridBagLayout());

    speech2Text = new synthesisTest();
    button_t2s = new JButton("Text To Speech");
    button_s2t = new JButton("Speech To Text");
    editorPane = new JEditorPane();

    JScrollPane scrollPane = new JScrollPane(editorPane);

    //Add Components to this panel.
    GridBagConstraints c = new GridBagConstraints();
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.insets = new Insets(5,5,2,5);
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 1.0;
    c.weighty = 0.9;
    add(scrollPane, c);

    c.gridwidth = GridBagConstraints.REMAINDER;
    c.insets = new Insets(2,5,5,5);
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0.5;
    c.weighty = 0.1;
    add(button_t2s, c);

    c.gridwidth = GridBagConstraints.REMAINDER;
    c.insets = new Insets(2,5,5,5);
    c.fill = GridBagConstraints.BOTH;
    c.weightx = 0.5;
    c.weighty = 0.1;
    add(button_s2t, c);

    button_t2s.addActionListener(this);
    //add(button, c);
  }

  public void actionPerformed(ActionEvent evt) {
    String text = editorPane.getText();
    speech2Text.read(text);
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
    
    recognitionTest recognize = new recognitionTest();
    
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }
    });
  }
}
