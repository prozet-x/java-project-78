package hexlet.code;

import java.util.HashSet;
import java.util.Set;

public class StringSchema {
    private boolean required = false;
    private int minLength = 0;
    private Set<String> contains = new HashSet<>();

    public StringSchema required() {
        required = true;
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
    public boolean isValid(String string) {
        if (required && (string == null || string.isEmpty())) {
            return false;
        }

        if (string != null && string.length() < minLength) {
            return false;
        }

        boolean containsAll = true;
        for(String str : contains) {
            if (!string.contains(str)) {
                containsAll = false;
            }
        }

        return string == null || (string != null && containsAll);
    }
}
