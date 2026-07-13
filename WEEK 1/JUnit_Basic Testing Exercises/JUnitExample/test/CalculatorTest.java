import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {

        Calculator calculator = new Calculator();

        assertEquals(30, calculator.add(10, 20));

    }

}