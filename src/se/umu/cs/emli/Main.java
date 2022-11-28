package se.umu.cs.emli;
import javax.swing.*;
/**
 * Main class for TextEditor with memento.
 * @author Emmy Lindgren, id19eln.
 * Date: 2022-11-21
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditorTextController::new);
    }
}