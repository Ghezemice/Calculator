package test;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import main.BasicMathOperations;

public class BasicMathOperationsTest {

    @Test
    public void testAdd() {
        Assert.assertEquals(1, BasicMathOperations.add(0, 1), 0);
        Assert.assertEquals(0, BasicMathOperations.add(-1, 1), 0);
        Assert.assertEquals(-2, BasicMathOperations.add(-1, -1), 0);
        Assert.assertEquals(2147483648f, BasicMathOperations.add(1, 2147483647), 0);
        Assert.assertEquals(-2147483648f, BasicMathOperations.add(-1, -2147483647), 0);
    }

    @Test
    public void testSub() {
        Assert.assertEquals(-1, BasicMathOperations.sub(0, 1), 0);
        Assert.assertEquals(0, BasicMathOperations.sub(-1, -1), 0);
        Assert.assertEquals(-2, BasicMathOperations.sub(-1, 1), 0);
        Assert.assertEquals(2, BasicMathOperations.sub(1, -1), 0);
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

    @Test
    public void testSum() {
        ArrayList<Float> numbers = new ArrayList<Float>();
        numbers.add((float) 0);
        numbers.add((float) 1);
        numbers.add((float) 2);
        numbers.add((float) 3);
        numbers.add((float) 4);

        Assert.assertEquals(10, BasicMathOperations.sum(numbers), 0);

        numbers.set(4, (float) -5);
        numbers.remove(1);

        Assert.assertEquals(0, BasicMathOperations.sum(numbers), 0);

        numbers.add(1, (float) -1);
        numbers.set(2, (float) -2);
        numbers.set(3, (float) -3);
        numbers.set(4, (float) -4);

        Assert.assertEquals(-10, BasicMathOperations.sum(numbers), 0);
    }
}