import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidateInputTest {
    static Menu menu;

    @BeforeAll
    public static void setup() {
        menu = new Menu();
    }

    @Test
    public void When_InputIsOneToSeven_Expect_True() {
        String input = "1";


        assertTrue(menu.validateInput(input));
    }

    @Test
    public void When_InputIsOutsideOneToSeven_Expect_False() {
        String input = "0";
        assertFalse(menu.validateInput(input));
    }

    @Test
    public void When_InputIsAlphabetical_Expect_False() {
        String input = "a";
        assertFalse(menu.validateInput(input));
    }

    @Test
    public void When_InputIsASymbol_Expect_False() {
        String input = " ";
        assertFalse(menu.validateInput(input));
    }
}
