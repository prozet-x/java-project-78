package hexlet.code.schemas;

import java.util.HashSet;
import java.util.Set;

public final class StringSchema extends BaseSchema {
    private int minLength = 0;
    private Set<String> contains = new HashSet<>();

    public StringSchema required() {
        super.makeRequired();
        return this;
    }

    public StringSchema minLength(int minimumLength) {
        minLength = minimumLength;
        return this;
    }
    public StringSchema contains(String str) {
        contains.add(str);
        return this;
    }

    @Override
    public boolean isValid(Object incoming) {
        if (incoming == null) {
            return !required && minLength == 0 && contains.size() == 0;
        }

        if (!(incoming instanceof String)) {
            return false;
        }

        String string = (String) incoming;

        if (required && string.isEmpty()) {
            return false;
        }

        return string.length() >= minLength && containsAll(string);
    }

    private boolean containsAll(String string) {
        for (String str : contains) {
            if (!string.contains(str)) {
                return false;
            }
        }
        return true;
    }
}
