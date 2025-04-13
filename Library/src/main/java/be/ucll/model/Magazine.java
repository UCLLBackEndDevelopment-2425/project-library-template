package be.ucll.model;

public class Magazine extends Publication {
    private String editor;
    private String issn;

    public Magazine(String title, String editor, String issn, int publicationYear, int availableCopies) {
        super(title, publicationYear, availableCopies);
        setEditor(editor);
        setISSN(issn);
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        if (editor == null || editor.trim().isEmpty()) {
            throw new RuntimeException("Editor is required");
        }
        this.editor = editor;
    }

    public String getISSN() {
        return issn;
    }

    public void setISSN(String issn) {
        if (issn == null || issn.trim().isEmpty()) {
            throw new RuntimeException("ISSN is required");
        }
        this.issn = issn;
    }
}