package testNGSessions;


import org.testng.annotations.*;

public class A_IntroductionTestNG {

    @BeforeSuite()
    public void testA() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite()
    public void testB() {
        System.out.println("AfterSuite");
    }

    @BeforeClass()
    public void testC() {
        System.out.println("BeforeClass");
    }

    @AfterClass()
    public void testD() {
        System.out.println("AfterClass");
    }

    @BeforeMethod()
    public void testE() {
        System.out.println("BeforeMethod");
    }

    @AfterMethod()
    public void testF() {
        System.out.println("AfterMethod");
    }

    @BeforeTest()
    public void testG() {
        System.out.println("BeforeTest");
    }

    @AfterTest()
    public void testH() {
        System.out.println("AfterTest");
    }

    @Test()
    public void testI() {
        System.out.println("Test I");
    }

    @Test()
    public void testJ() {
        System.out.println("Test J");
    }


}
