package hexlet.code.schemas;

public abstract class BaseSchema {
    protected boolean required = false;

    protected BaseSchema required() {
        required = true;
        return this;
    }

    public final boolean isRequired() {
        return required;
    }

    public abstract boolean isValid(Object incoming);
}
