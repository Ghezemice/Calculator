package test;
import org.junit.Assert;
import org.junit.Test;

import main.ErrorHandling;

public class ErrorHandlingTest {
    @Test
    public void checkOperationValidityTest() {
        Assert.assertEquals(true, ErrorHandling.checkOperationValidity("ADD"));
        Assert.assertEquals(true, ErrorHandling.checkOperationValidity("SUB"));
        Assert.assertEquals(true, ErrorHandling.checkOperationValidity("DIV"));
        Assert.assertEquals(true, ErrorHandling.checkOperationValidity("MUL"));
        Assert.assertEquals(false, ErrorHandling.checkOperationValidity("asd"));
    }

    @Test
    public void isIntegerTest() {
        Assert.assertEquals(true, ErrorHandling.isFloat("1"));
        Assert.assertEquals(false, ErrorHandling.isFloat("A"));
    }
}
