package appsParametrisation;

import org.testng.annotations.Test;

public class OpenCRMTest extends BaseTestParam {


    @Test
    public void validateTitle() {
        String expTitle = "Your Store";
        String actTitle = driver.getTitle();

        //   Assert.assertEquals(expTitle, actTitle);

    }
}
