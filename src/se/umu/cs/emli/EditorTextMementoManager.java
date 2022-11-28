package se.umu.cs.emli;
import java.util.Stack;
/**
 * Caretaker class for editorTextMementos.
 * Keeps a stack of Memento-objects from EditorText-class (Originator) memento-class.
 * When originator wants to travel back to last saved state, caretaker fetches and returns the
 * topmost memento from the stack.
 * @author Emmy Lindgren, id19eln.
 * Date: 2022-11-25
 */
public class EditorTextMementoManager {
    private final Stack<EditorText.EditorTextMemento> mementoStack;
    public EditorTextMementoManager(){
        mementoStack = new Stack<>();
    }
    public void save(EditorText.EditorTextMemento memento){
        if(hasMemento()){
           if(mementoStack.peek().equals(memento)){
               return;
           }
        }
        mementoStack.push(memento);
    }
    public EditorText.EditorTextMemento restore(){
        return mementoStack.pop();
    }
    public boolean hasMemento(){
        return !mementoStack.isEmpty();
    }
}