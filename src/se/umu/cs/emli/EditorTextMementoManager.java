package se.umu.cs.emli;
import java.util.Stack;

public class EditorTextMementoManager {
    private Stack<EditorText.EditorTextMemento> mementoStack;

    public EditorTextMementoManager(){
        mementoStack = new Stack<>();
    }
    public void save(EditorText.EditorTextMemento memento){
        mementoStack.push(memento);
    }
    public EditorText.EditorTextMemento restore(){
        return mementoStack.pop();
    }
    public boolean hasMemento(){
        return !mementoStack.isEmpty();
    }
}