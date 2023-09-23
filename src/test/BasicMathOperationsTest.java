package test;
import org.junit.Assert;
import org.junit.Test;

import main.BasicMathOperations;

public class BasicMathOperationsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(1, BasicMathOperations.add(0, 1));
        Assert.assertEquals(0, BasicMathOperations.add(-1, 1));
        Assert.assertEquals(-2, BasicMathOperations.add(-1, -1));
    }

    @Test
    public void testSub() {
        Assert.assertEquals(-1, BasicMathOperations.sub(0, 1));
        Assert.assertEquals(0, BasicMathOperations.sub(-1, -1));
        Assert.assertEquals(-2, BasicMathOperations.sub(-1, 1));
        Assert.assertEquals(2, BasicMathOperations.sub(1, -1));
    }

    @Test
    public void testDiv() {
        Assert.assertEquals(0, BasicMathOperations.div(0, 1), 0);
        Assert.assertEquals(1, BasicMathOperations.div(1, 1), 0);
        Assert.assertEquals(2, BasicMathOperations.div(4, 2), 0);
        Assert.assertEquals(1, BasicMathOperations.div(-1, -1), 0);
        Assert.assertEquals(-2, BasicMathOperations.div(4, -2), 0);
        Assert.assertEquals(-2, BasicMathOperations.div(-4, 2), 0);
        Assert.assertEquals(Float.NaN, BasicMathOperations.div(1, 0), 0);
    }

    @Test
    public void testMul() {
        Assert.assertEquals(0, BasicMathOperations.mul(0, 1), 0);
        Assert.assertEquals(1, BasicMathOperations.mul(1, 1), 0);
        Assert.assertEquals(8, BasicMathOperations.mul(4, 2), 0);
        Assert.assertEquals(1, BasicMathOperations.mul(-1, -1), 0);
        Assert.assertEquals(-8, BasicMathOperations.mul(4, -2), 0);
        Assert.assertEquals(-8, BasicMathOperations.mul(-4, 2), 0);
    }
}