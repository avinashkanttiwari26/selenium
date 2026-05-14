package appsDataProvider;

import appsParametrisation.BaseTestParam;
import org.testng.annotations.Test;

public class GoogleTestDataProvider extends BaseTestParam {

    @Test
    public void validateTitle() {
        String expTitle = "Your Store";
        String actTitle = driver.getTitle();

        //Assert.assertEquals(expTitle, actTitle);

    }


}
