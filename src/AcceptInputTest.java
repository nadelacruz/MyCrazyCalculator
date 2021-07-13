import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

//@RunWith(JUnitPlatform.class)
//@ExtendWith(TraceUnitExtension.class)
public class AcceptInputTest {
    static Menu menu;

    @BeforeAll
    public static void setup() {
        menu = new Menu();
    }


    @Test
    public void When_InputIsOne_Expect_InfixExpressionToHaveAValue() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        assertNotNull(menu.getInfixExpression());
    }

    @Test
    public void When_InputIsTwoAndInputIsInvalid_Expect_ConvertedExpressionIsNull() {
        changeScannerInputTo("1+1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(2);

        assertNull(menu.getConvertedExpression());
    }

    @Test
    public void When_InputIsTwoAndInputIsValid_Expect_ConvertedExpressionToHaveAValue() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(2);

        assertEquals("+ 1 1", menu.getConvertedExpression());
    }

    @Test
    public void When_InputIsThreeAndInputIsInvalid_Expect_ConvertedExpressionIsNull() {
        changeScannerInputTo("1+1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(3);

        assertNull(menu.getConvertedExpression());
    }

    private void acceptInputAndHandleNoSuchElementException(int option) {
        Exception exception = assertThrows(NoSuchElementException.class, () -> menu.acceptInput(option));

        String expectedMessage = "No line found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void When_InputIsThreeAndInputIsValid_Expect_ConvertedExpressionToHaveAValue() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(3);

        assertEquals("1 1 +", menu.getConvertedExpression());
    }

    @Test
    public void When_InputIsFourAndInfixExpressionIsInvalid_Expect_SystemOutToPrintSameValueAsInfixExpression() {
        changeScannerInputTo("1+1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(4);

        assertNull(menu.printedInfixExpression);
    }

    @Test
    public void When_InputIsFourAndInfixExpressionIsValid_Expect_SystemOutToPrintSameValueAsInfixExpression() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(4);

        assertEquals("Infix expression: " + menu.getInfixExpression(), menu.printedInfixExpression);
    }

    @Test
    public void When_InputIsFiveAndConvertedExpressionIsInvalid_Expect_SystemOutToPrintSameValueAsConvertedExpression() {
        changeScannerInputTo("1+1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(5);

        assertNull(menu.printedInfixExpression);
    }

    @Test
    public void When_InputIsFiveAndConvertedExpressionIsValid_Expect_SystemOutToPrintSameValueAsConvertedExpression() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(5);

        assertEquals("Converted expression: " + menu.getConvertedExpression(), menu.printedConvertedExpression);
    }

    @Test
    public void When_InputIsSixAndConvertedExpressionIsInvalidAndConvertedExpressionIsPrefix_Expect_SystemOutToPrintEvaluatedExpression() {
        changeScannerInputTo("1+1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(2);

        acceptInputAndHandleNoSuchElementException(6);

        assertNull(menu.printedEvaluatedExpression);
    }

    @Test
    public void When_InputIsSixAndConvertedExpressionIsValidAndConvertedExpressionIsPrefix_Expect_SystemOutToPrintEvaluatedExpression() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(2);

        acceptInputAndHandleNoSuchElementException(6);

        assertEquals("Evaluated expression: " + menu.evaluatedExpression, menu.printedEvaluatedExpression);
    }

    @Test
    public void When_InputIsSixAndConvertedExpressionIsInvalidAndConvertedExpressionIsPostfix_Expect_SystemOutToPrintEvaluatedExpression() {
        changeScannerInputTo("1+1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(3);

        acceptInputAndHandleNoSuchElementException(6);

        assertNull(menu.printedEvaluatedExpression);
    }

    @Test
    public void When_InputIsSixAndConvertedExpressionIsValidAndConvertedExpressionIsPostfix_Expect_SystemOutToPrintEvaluatedExpression() {
        changeScannerInputTo("1 + 1");

        acceptInputAndHandleNoSuchElementException(1);

        acceptInputAndHandleNoSuchElementException(3);

        acceptInputAndHandleNoSuchElementException(6);

        assertEquals("Evaluated expression: " + menu.evaluatedExpression, menu.printedEvaluatedExpression);
    }

    private void changeScannerInputTo(String infixExpression) {
        String input = infixExpression;
        InputStream in = new ByteArrayInputStream(input.getBytes());

        System.setIn(in);
    }
}
