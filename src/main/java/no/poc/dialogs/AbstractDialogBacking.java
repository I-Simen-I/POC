package no.poc.dialogs;

public abstract class AbstractDialogBacking {
    private String title;
    private Boolean inizialized;

    public void initializeDialog() {
        validateInternalVariables();

        if (!inizialized) {
            load();
        }
    }

    public abstract void setInizializedCriteria();

    public abstract void load();

    public void save() {
        saveChanges();
        resetDialog();
    }

    public void close() {
        resetDialog();
    }

    public abstract void resetDialog();

    public abstract void saveChanges();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void validateInternalVariables() {
        if (title == null) {
            throw new UnsupportedOperationException("Tittel er ikke definert");
        } else if (inizialized == null) {
            throw new UnsupportedOperationException("Inizialized er ikke definert");
        }
    }
}
