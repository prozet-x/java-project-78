package hexlet.code;

import java.util.Map;

public class MapSchema extends BaseSchema {
    private int sizeof = -1;

    public MapSchema sizeof(int size) {
        sizeof = size;
        return this;
    }

    public boolean isValid(Object incoming) {
        if (incoming == null) {
            return !required;
        }

        if (!(incoming instanceof Map)) {
            return false;
        }

        Map map = (Map) incoming;
        return sizeof == -1 || sizeof == map.size();
    }
}
