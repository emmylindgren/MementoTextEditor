package se.umu.cs.emli;
import se.umu.cs.apjava.EditorTextChangeListener;
import se.umu.cs.apjava.EditorTextInterface;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Class to represent the current text in Texteditor. Keeps track of
 * the current text, cursorposition, selected text (if there is any) and the
 * listeners of the model.
 * Originator-class of EditorTextMemento.
 * @author Emmy Lindgren, id19eln.
 * Date: 2022-11-21
 */
public class EditorText implements EditorTextInterface {
    private String text;
    private int cursorPosition;
    private int selectionEnd;
    private ArrayList<EditorTextChangeListener> listeners;

    public EditorText() {
        listeners = new ArrayList<>();
    }
    @Override
    public String getText() {
        return this.text;
    }
    @Override
    public void setText(String text) {
        this.text = text;
    }
    @Override
    public void setCursorPosition(int cursorPosition, int selectionEnd) {
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
    /**
     * @return a EditorTextMemento-object to be stored in caretaker-class (EditorTextMementoManager).
     */
    public EditorTextMemento makeMemento(){
        return new EditorTextMemento(this.text, this.cursorPosition, this.selectionEnd, this.listeners);
    }
    /**
     * Restores the state of the class to some old state.
     * @param memento containing the state of the class it wishes to return to.
     */
    public void restore(EditorTextMemento memento){
        this.text = memento.text;
        this.cursorPosition = memento.cursorPosition;
        this.selectionEnd = memento.selectionEnd;
        this.listeners = memento.listeners;
        updateListeners();
    }
    private void updateListeners(){
        for (EditorTextChangeListener listener:listeners) {
            listener.stateUpdated(this);
        }
    }
    /**
     * Memento-class for EditorText-class.
     * Makes a memento-object of the current state of the originator-class (EditorText).
     */
    public static class EditorTextMemento{
        private final String text;
        private final int cursorPosition;
        private final int selectionEnd;
        private final ArrayList<EditorTextChangeListener> listeners;

        public EditorTextMemento(String text, int cursorPosition, int selectionEnd,
                                 ArrayList<EditorTextChangeListener> listeners){
            this.text = text;
            this.cursorPosition = cursorPosition;
            this.selectionEnd = selectionEnd;
            this.listeners = listeners;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (obj.getClass() != this.getClass()) {
                return false;
            }

            final EditorTextMemento other = (EditorTextMemento) obj;
            if (!Objects.equals(this.text, other.text)) {
                return false;
            }

            if (this.cursorPosition != other.cursorPosition) {
                return false;
            }

            if(this.selectionEnd != other.selectionEnd){
                return false;
            }

            for (EditorTextChangeListener listener:this.listeners) {
                if(!other.listeners.contains(listener)) return false;
            }
            return true;
        }
    }
}
