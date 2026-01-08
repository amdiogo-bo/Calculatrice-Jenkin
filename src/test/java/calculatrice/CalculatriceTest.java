package calculatrice;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatriceTest {

    private Calculatrice calc = new Calculatrice();

    @Test
    void testAddition() {
        assertEquals(8, calc.addition(5, 3));
    }

    @Test
    void testSoustraction() {
        assertEquals(2, calc.soustraction(5, 3));
    }

    @Test
    void testMultiplication() {
        assertEquals(15, calc.multiplication(3, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2.0, calc.division(10, 5));
    }

    @Test
    void testDivisionParZero() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.division(10, 0));
    }
}
