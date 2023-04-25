package hexlet.code.schemas;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NumberSchema extends BaseSchema {
    private boolean isPositive = false;
    private List<Map<String, Integer>> ranges = new ArrayList<>();

    public NumberSchema required() {
        super.required();
        return this;
    }

    public NumberSchema positive() {
        isPositive = true;
        return this;
    }

    public NumberSchema range(@NotNull Integer a, @NotNull Integer b) {
        Integer left;
        Integer right;
        if (a > b) {
            left = b;
            right = a;
        } else {
            left = a;
            right = b;
        }
        ranges.add(Map.of("left", left, "right", right));
        return this;
    }

    public boolean isValid(Object incoming) {
        if (incoming == null) {
            return  !required;
        }

        if (!(incoming instanceof Integer)) {
            return false;
        }

        Integer number = (Integer) incoming;
        if (isPositive && number < 1) {
            return false;
        }

        return inAnyRange(number);
    }

    private boolean inAnyRange(Integer number) {
        for (Map<String, Integer> borders : ranges) {
            if (number >= borders.get("left") && number <= borders.get("right")) {
                return true;
            }
        }
        return ranges.size() == 0;
    }
}
