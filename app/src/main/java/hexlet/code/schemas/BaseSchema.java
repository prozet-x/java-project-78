package hexlet.code.schemas;

public abstract class BaseSchema {
    protected boolean required = false;

    protected final void makeRequired() {
        required = true;
    }

    public final boolean isRequired() {
        return required;
    }

    public abstract boolean isValid(Object incoming);
}
