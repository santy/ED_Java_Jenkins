import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NumberUtilsTest {
    @Test
    void testIsEvenForEvenNumber() {
        // 4 es par, se espera true
        assertTrue(NumberUtils.isEven(4), "4 debería considerarse un número par");
    }

    @Test
    void testIsEvenForOddNumber() {
        // 5 es impar, se espera false
        assertFalse(NumberUtils.isEven(5), "5 debería considerarse un número impar");
    }

}