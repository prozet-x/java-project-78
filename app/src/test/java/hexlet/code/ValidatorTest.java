package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {
    private Validator v = new Validator();
    @Test
    public void stringSchemaTest() {
        StringSchema s = v.string();

        assertTrue(s.isValid(null));
        assertTrue(s.isValid(""));

        s.required();
        assertFalse(s.isValid(null));
        assertFalse(s.isValid(""));

        s.minLength(3);
        assertFalse(s.isValid(2));
        assertTrue(s.isValid("123"));
        assertFalse(s.isValid("12"));

        s.contains("llo");
        assertFalse(s.isValid("I want to sleep"));
        assertTrue(s.isValid("I want a marshmello"));

        s.contains("beer");
        assertFalse(s.isValid("I want to sleep and to drink some beer"));
        assertTrue(s.isValid("I want a marshmello and beer"));
    }

    @Test
    public void testNumberSchema() {
        NumberSchema schema = v.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertTrue(schema.isValid(10));

        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));
    }
}
