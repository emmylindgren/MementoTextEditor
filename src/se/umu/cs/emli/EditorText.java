package se.umu.cs.emli;

import se.umu.cs.apjava.EditorTextChangeListener;
import se.umu.cs.apjava.EditorTextInterface;

import java.util.ArrayList;

public class EditorText implements EditorTextInterface {
    private String text;
    private int cursorPosition;
    private int selectionEnd;
    private final ArrayList<EditorTextChangeListener> listeners;

    public EditorText() {
        listeners = new ArrayList<>();
    }

    @Override
    public String getText() {
        return this.text;
    }

    @Override
    public void setText(String text) {
        //Uppdatera lyssnare här?
        this.text = text;
    }

    @Override
    public void setCursorPosition(int cursorPosition, int selectionEnd) {
        //Uppdatera lyssnare här?
        this.cursorPosition = cursorPosition;
        this.selectionEnd = selectionEnd;
    }

    @Override
    public int getCursorPosition() {
        return cursorPosition;
    }

    @Override
    public int getSelectionEndPosition() {
        return selectionEnd;
    }

    @Override
    public void addChangeListener(EditorTextChangeListener listener) {
        this.listeners.add(listener);
    }

    @Override
    public void removeChangeListener(EditorTextChangeListener editorTextChangeListener) {
        this.listeners.remove(editorTextChangeListener);
    }
}
