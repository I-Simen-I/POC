package no.poc.dialogs;

public abstract class AbstractDialogBacking<T> extends AbstractBean {
    private String dialogTitle;
    private String dialogMessageID;
    private T dialogObject;
    private Boolean dialogInEditMode;

    /**
     * Populerer dialogen med et objekt. Dialogen vil starte med dialogInEditMode = true
     *
     * @param dialogObject objektet som skal brukes i dialogen
     */
    public void initializeDialog(T dialogObject) {
        this.dialogObject = dialogObject;
    }

    public void initialize() {
        validateInternalVariables();

        if (!initialized()) {
            dialogInEditMode = false;
            populateDialogWithDataWhenNotInitialized();
        } else {
            dialogInEditMode = true;
            populateDialogWithDataWhenInitialized();
        }
    }

    public abstract boolean initialized();

    private void validateInternalVariables() {
        if (dialogTitle == null) {
            throw new UnsupportedOperationException("DialogTittel er ikke definert");
        } else if (dialogMessageID == null) {
            throw new UnsupportedOperationException("DialogMessageId er ikke definert");
        }
    }

    abstract void populateDialogWithDataWhenNotInitialized();

    abstract void populateDialogWithDataWhenInitialized();


    public void save() {
        saveChanges();
        resetDialog();
    }

    public abstract void saveChanges();

    public void close() {
        resetDialog();
    }

    public abstract void resetDialog();

    public String getDialogTitle() {
        return dialogTitle;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public Boolean getDialogInEditMode() {
        return dialogInEditMode;
    }
}
