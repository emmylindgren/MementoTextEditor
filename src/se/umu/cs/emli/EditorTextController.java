package se.umu.cs.emli;

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
        text.restore(mementoManager.restore());
    }

    private void saveEditor(){
        mementoManager.save(text.makeMemento());
    }
}
