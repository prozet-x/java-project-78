package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private int sizeof = -1;
    private Map<String, BaseSchema> shape;

    public MapSchema required() {
        super.required();
        return this;
    }

    public MapSchema sizeof(int size) {
        sizeof = size;
        return this;
    }

    public void shape(Map<String, BaseSchema> map) {
        shape = new HashMap<>(map);
    }

    @Override
    public boolean isValid(Object incoming) {
        if (incoming == null) {
            return !required;
        }

        if (!(incoming instanceof Map)) {
            return false;
        }

        if (shape != null) {
            return shapeValidation(incoming);
        }

        Map map = (Map) incoming;
        return sizeof == -1 || sizeof == map.size();
    }

    private boolean shapeValidation(Object incoming) {
        //Map<String, Object> map = (Map<String, Object>) incoming;
        Map map = (Map) incoming;

        for (Map.Entry<String, BaseSchema> nameAndSchema : shape.entrySet()) {
            String keyFromShape = nameAndSchema.getKey();
            BaseSchema schemaFromShape = nameAndSchema.getValue();

            if (!map.containsKey(keyFromShape) && schemaFromShape.isRequired()) {
                return false;
            }
            if (!schemaFromShape.isValid(map.get(keyFromShape))) {
                return false;
            }
        }
        return true;
    }
}
