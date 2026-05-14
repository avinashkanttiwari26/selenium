package testNGSessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C_ExpectedExceptionconcept {

    @Test
    public void addToCart() {
        System.out.println("Test start");
        // throw new ArithmeticException();
        Assert.assertEquals(true, true);
        System.out.println("Test end");
        //throw new ArithmeticException();
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void addToCartWithExpExceptions() {
        System.out.println("Test start");
        // throw new ArithmeticException();
        Assert.assertEquals(true, true);
        System.out.println("Test end");
        throw new ArithmeticException();
    }

    @Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
    public void addToCartWithMultipleExpExceptions() {
        System.out.println("Test start");
        // throw new ArithmeticException();
        Assert.assertEquals(true, true);
        System.out.println("Test end");
        throw new ArithmeticException();
    }

}
