package seleniumSessionsPractice.jsExecutor;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomInIFrame {


    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/shadow-dom-in-iframe/");

        driver.switchTo().frame("pact");
        Thread.sleep(2000);

        /*
        * <div id="snacktime" class="jackPart">
    <template shadowrootmode="open">
        <h4>Snacks</h4>
        <div class="uojl_0"></div><span class="olp_jrp"></span>
        <br>
        <div class="uojl">
            <div class="uoj">
                <input type="text" id="tea" name="chai" title="Chai is a feeling" value="" autocorrect="off" autocapitalize="off" placeholder="Do you love tea" autocomplete="off" spellcheck="false">
            </div>
        </div>
        <div id="app2" qaid="qalunch">
            <template shadowrootmode="open">
                <br>
                <div class="food_block">
                    <h4>Lunch Time</h4>
                    <div class="ol">
                        <div class="uojl_1"></div><span class="olp_jrp1"></span>
                        <div class="uojl1">
                            <div class="uoj1">
                                <div class="uoj2"><span class="let_x"><span class="let_y"></span>
                                    <input type="text" id="pizza" placeholder="What would you like to have in lunch?">
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div id="app2" qaid="qa1lunch"></div>
                    </div>
                </div>
            </template>
        </div>
        <div id="concepts" qaid="letsTest">
            <template shadowrootmode="closed">
                <br>
                <h4>Selector's Concept Test</h4>
                <input style="width: 400px;" type="text" id="training" placeholder="Does shadow dom support xpath?">
                <br>
                <br><a class="elementor-button elementor-button-link elementor-size-sm btn-hover" style="text-decoration:none;" href="https://www.udemy.com/course/xpath-css-selector-webdom-selectorshub-testcase-studio/" target="_blank">Not sure about it, learn from here.</a></template>
        </div>
        <br>
        <iframe id="shadpact" src="https://selectorshub.com/shadow-input-box/" width="400" height="170" style="border:none"></iframe>
    </template>
</div>
        * */


        //document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
        String jsScript= "return document\n" +
                "       .querySelector(\"#snacktime\")\n" +
                "       .shadowRoot\n" +
                "       .querySelector(\"#tea\");";
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement ele = (WebElement) js.executeScript(jsScript);

        ele.sendKeys("hmmmmm");
        driver.switchTo().defaultContent();




    }

}
