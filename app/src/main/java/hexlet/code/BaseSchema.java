package hexlet.code;

public abstract class BaseSchema {
    protected boolean required = false;
    public BaseSchema required() {
        required = true;
        return this;
    }

    public boolean isRequired() {
        return required;
    }

    public abstract boolean isValid(Object incoming);
}
