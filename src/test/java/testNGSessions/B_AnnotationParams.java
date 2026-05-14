package testNGSessions;

import org.testng.annotations.Test;

public class B_AnnotationParams {

    /* Default output
        test A
        testAB
        testB
        testAB
        testD

        OutputDefault:
        testD
        testAB
        testB
        testC
        test A
        test A
       */

    @Test(priority = 3, invocationCount = 2)
    public void testA() {
        System.out.println("test A: priority=3, invocationCount = 2");
    }

    @Test(dependsOnGroups = "smoke")
    public void testB() {
        System.out.println("testB: dependsOnGroups = smoke");
    }

    @Test(groups = "smoke")
    public void testCAB() {
        System.out.println("testCAB: groups= \"smoke\"");
    }

    @Test(dependsOnMethods = "testD", dependsOnGroups = "smoke")
    public void testBC() {
        System.out.println("testBC: dependsOnMethods = \"testD\", dependsOnGroups = \"smoke\"");
    }

    @Test(priority = -1)
    public void testD() {
        System.out.println("testD: priority=-1");
    }
}
