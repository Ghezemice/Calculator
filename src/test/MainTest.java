package test;
import org.junit.Assert;
import org.junit.Test;

import main.Fields;
import main.Main;

public class MainTest {
    @Test
    public void testParseLineOp() {
        Assert.assertEquals(Fields.Operation.ADD, Main.parseLine("ADD 0 1").getOp());
    }

    @Test
    public void testParseLineA() {
        Assert.assertEquals(0, Main.parseLine("ADD 0 1").getA());
    }

    @Test
    public void testParseLineB() {
        Assert.assertEquals(1, Main.parseLine("ADD 0 1").getB());
    }
}