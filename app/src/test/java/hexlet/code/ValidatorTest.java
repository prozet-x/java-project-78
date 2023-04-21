package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatorTest {
    @Test
    public void stringSchemaTest() {
        Validator v = new Validator();
        StringSchema s = v.string();

        assertTrue(s.isValid(null));
        assertTrue(s.isValid(""));

        s.required();
        assertFalse(s.isValid(null));
        assertFalse(s.isValid(""));

        s.minLength(3);
        assertTrue(s.isValid("123"));
        assertFalse(s.isValid("12"));

        s.contains("llo");
        assertFalse(s.isValid("I want to sleep"));
        assertTrue(s.isValid("I want a marshmello"));

        s.contains("beer");
        assertFalse(s.isValid("I want to sleep and to drink some beer"));
        assertTrue(s.isValid("I want a marshmello and beer"));
    }
}