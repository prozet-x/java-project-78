package hexlet.code;

import java.util.HashSet;
import java.util.Set;

public class StringSchema extends BaseSchema {
    private int minLength = 0;
    private Set<String> contains = new HashSet<>();

    public StringSchema minLength(int minimumLength) {
        minLength = minimumLength;
        return this;
    }
    public StringSchema contains(String str) {
        contains.add(str);
        return this;
    }
    public boolean isValid(Object incoming) {
        if (!(incoming instanceof String || incoming == null)) {
            return false;
        }

        String string = (String) incoming;

        if (required && (string == null || string.isEmpty())) {
            return false;
        }

        if (string != null && string.length() < minLength) {
            return false;
        }

        boolean containsAll = true;
        for (String str : contains) {
            if (!string.contains(str)) {
                containsAll = false;
                break;
            }
        }

        return containsAll;
    }
}
