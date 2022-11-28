package se.umu.cs.emli;
/**
 * Controller-class for TextEditor.
 * Inflates view and sets up listeners.
 * @author Emmy Lindgren, id19eln.
 * Date: 2022-11-28
 */
public class EditorTextController {
    TextEditorView view;
    EditorText text;
    EditorTextMementoManager mementoManager;
    public EditorTextController(){
        text = new EditorText();
        view = new TextEditorView(text);
        mementoManager = new EditorTextMementoManager();
        setUpListeners();
    }
    private void setUpListeners(){
        view.setSaveButtonListener(e -> saveEditor());
        view.setRestoreButtonListener(e -> restoreEditor());
    }
    private void restoreEditor(){
        if(mementoManager.hasMemento()) text.restore(mementoManager.restore());
    }
    private void saveEditor(){
        mementoManager.save(text.makeMemento());
    }
}
