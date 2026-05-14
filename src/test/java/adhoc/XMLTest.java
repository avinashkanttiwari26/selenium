package adhoc;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XMLTest {

    @Parameters({"browser", "url"})
    @Test
    public void testXML(String browser,String abc){
        System.out.println(browser);
    }


}
