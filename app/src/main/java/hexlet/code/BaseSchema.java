package hexlet.code;

public class BaseSchema {
    protected boolean required = false;
    public BaseSchema required() {
        required = true;
        return this;
    }
}
