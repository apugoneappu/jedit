import java.awt.GridLayout;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.datatransfer.*;



public class Snippet implements ActionListener {

  String find, replace;
  JButton btnFind;
  JButton btnReplace;
  JButton btnReplaceAll;
  JTextField txtFind; 
  JTextField txtReplace;
  JEditorPane editorPane;

  Snippet(JEditorPane ePane) {

    editorPane = ePane;
    JDialog frDialog = new JDialog();
    frDialog.setLayout(new GridLayout(3,4));

    txtFind = new JTextField();
    txtReplace = new JTextField();
    btnFind = new JButton("Find");
    btnReplace = new JButton("Replace");
    btnReplaceAll = new JButton("Replace All");
    frDialog.add(new JLabel("Find: "));
    frDialog.add(txtFind);
    frDialog.add(new JLabel(""));
    frDialog.add(btnFind);
    frDialog.add(new JLabel("Replace with: "));
    frDialog.add(txtReplace);
    frDialog.add(new JLabel(""));
    frDialog.add(btnReplace);
    frDialog.add(new JLabel(""));
    frDialog.add(new JLabel(""));
    frDialog.add(new JLabel(""));
    frDialog.add(btnReplaceAll);

    frDialog.pack();
    frDialog.setVisible(true);

    btnFind.addActionListener(this);
    btnFind.setActionCommand("find");

  }

  public void actionPerformed(ActionEvent evt) {


    // For text to speech command
    if (evt.getActionCommand().equals("find")) {
      String text = txtFind.getText();
      if (editorPane.getText().contains(text) == true) {
        System.out.println("yo");
      }
      else {
        System.out.println("no");
      }

    }
  }




  public static void show(JFrame frame) {
      frame.setVisible(true);
  }
}
