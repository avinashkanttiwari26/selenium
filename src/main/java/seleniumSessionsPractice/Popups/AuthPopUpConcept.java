package seleniumSessionsPractice.Popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AuthPopUpConcept {


    static WebDriver driver;

    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public static void updateURLGPT(String url, String username, String password) throws MalformedURLException {
        URL original = new URL(url);

        String auth = username + ":" + password + "@";

        String updated =
                original.getProtocol() + "://" +
                        auth +
                        original.getHost() +
                        (original.getPort() != -1 ? ":" + original.getPort() : "") +
                        original.getFile();

    }


    //note below function is not clean, only works for url without. www.
    // doesn't work for password username which contain @ char.
    //refer above code for better realtime practice.

    public static String handleURLAuthPopUp(String url, String username, String password){
        String updatedURL="";
        if(url.indexOf("https")==0){
            String[] split = url.split("https://"); //note that split will also delete the https
            System.out.println(split.length);
            System.out.println(split[1]);

            updatedURL="https://"+username+":"+password+"@"+split[1];
            System.out.println(updatedURL);
        } else if (url.indexOf("http")==0){
            String[] split = url.split("http://"); // deletes the https
            System.out.println(split[1]);

            updatedURL="http://"+username+":"+password+"@"+split[1];
            System.out.println(updatedURL);
        }
    return updatedURL;
    }



    public static void main(String[] args) {
        driver= new ChromeDriver();
        String url="https://.the-internet.herokuapp.com/basic_auth";
        String username="admin";
        String password="admin";
       // driver.get(url);
       // String updatedURL="https://admin:admin@the-internet.herokuapp.com/basic_auth";
        driver.get(handleURLAuthPopUp(url, username, password));



    }




}
