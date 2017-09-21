package no.poc.dialogs;

public abstract class AbstractDialogBacking<T> extends AbstractBean {
    private String dialogTitle;
    private T dialogObject;
    private DialogMode dialogMode;
    private boolean validationFailed;

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
            dialogMode = DialogMode.CREATION_MODE;
            populateDialogInCreationMode();
        } else {
            dialogMode = DialogMode.EDIT_MODE;
            populateDialogInEditMode();
        }
    }

    protected abstract boolean initialized();

    private void validateInternalVariables() {
        if (dialogTitle == null) {
            throw new UnsupportedOperationException("DialogTittel er ikke definert");
        }
    }

    protected abstract void populateDialogInCreationMode();

    protected abstract void populateDialogInEditMode();


    public void save() {
        saveChanges();
        if (!validationFailed) {
            resetDialog();
        }
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

    public boolean isDialogInEditMode() {
        return dialogMode.name().equals(DialogMode.EDIT_MODE.name());
    }

    public boolean isDialogInCreationMode() {
        return dialogMode.name().equals(DialogMode.CREATION_MODE.name());
    }

    protected void validationFailed() {
        validationFailed = true;
    }

    protected void validationPassed() {
        validationFailed = false;
    }

    private enum DialogMode {
        CREATION_MODE,
        EDIT_MODE
    }
}
