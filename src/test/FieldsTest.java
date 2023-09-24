package test;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.Fields;

public class FieldsTest {
    @Test
    public void testSetOp() {
        Assert.assertEquals(Fields.Operation.ADD, new Fields("ADD 0 1").getOp());
    }

    @Test
    public void testSetA() {
        Assert.assertEquals(0, new Fields("ADD 0 1").getA(), 0);
    }

    @Test
    public void testSetB() {
        Assert.assertEquals(1, new Fields("ADD 0 1").getB(), 0);
    }

    @Test
    public void testSetNumbers() {
        ArrayList<Float> numbers = new ArrayList<Float>();
        numbers.add((float) 0);
        numbers.add((float) 1);
        numbers.add((float) 2);
        numbers.add((float) 3);
        numbers.add((float) 4);
        
        Assert.assertEquals(numbers, new Fields("SUM 0 1 2 3 4").getNumbers());
    }
}