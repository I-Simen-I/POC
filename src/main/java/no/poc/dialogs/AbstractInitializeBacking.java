package no.poc.dialogs;

public abstract class AbstractInitializeBacking extends AbstractBean {
    public void initialize() {
        if (!initialized()) {
            load();
        }
    }

    public abstract boolean initialized();

    public abstract void load();
}
