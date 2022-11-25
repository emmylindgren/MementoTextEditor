package se.umu.cs.emli;
import se.umu.cs.apjava.JETextArea;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TextEditorView {
    private JButton saveButton;
    private JButton restoreButton;
    private final EditorText text;

    public TextEditorView(EditorText text){
        this.text = text;

        JFrame frame = new JFrame("Text editor");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));

        frame.add(makeTextPanel(),BorderLayout.CENTER);
        frame.add(makeButtonPanel(), BorderLayout.PAGE_END);

        frame.setVisible(true);
    }

    private JPanel makeTextPanel(){
        JPanel textPanel = new JPanel();

        JETextArea textArea = new JETextArea(this.text);
        textPanel.add(textArea);
        return textPanel;
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
