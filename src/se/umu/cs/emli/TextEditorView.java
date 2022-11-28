package se.umu.cs.emli;
import se.umu.cs.apjava.JETextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
/**
 * View-class for TextEditor.
 * Contains a textfield and two buttons, one for saving state and one for restoring.
 * @author Emmy Lindgren, id19eln.
 * Date: 2022-11-28
 */
public class TextEditorView {
    private JButton saveButton;
    private JButton restoreButton;
    public TextEditorView(EditorText text){

        JFrame frame = new JFrame("Text editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));

        frame.add(new JETextArea(text),BorderLayout.CENTER);
        frame.add(makeButtonPanel(), BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    private JPanel makeButtonPanel(){
        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save");
        restoreButton = new JButton("Restore");

        buttonPanel.add(saveButton);
        buttonPanel.add(restoreButton);
        return buttonPanel;
    }

    public void setSaveButtonListener(ActionListener actionListener){
        saveButton.addActionListener(actionListener);
    }

    public void setRestoreButtonListener(ActionListener actionListener){
        restoreButton.addActionListener(actionListener);
    }
}
