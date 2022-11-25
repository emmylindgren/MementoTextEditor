package se.umu.cs.emli;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EditorTextController::new);
    }
}