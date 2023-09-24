package test;
import org.junit.Assert;
import org.junit.Test;

import main.Fields;

public class FieldsTest {
    @Test
    public void testParseLineOp() {
        Assert.assertEquals(Fields.Operation.ADD, new Fields("ADD 0 1").getOp());
    }

    @Test
    public void testParseLineA() {
        Assert.assertEquals(0, new Fields("ADD 0 1").getA(), 0);
    }

    @Test
    public void testParseLineB() {
        Assert.assertEquals(1, new Fields("ADD 0 1").getB(), 0);
    }
}