package prod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Solution {

    WebDriver  webDriver;
    public void initializaton() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://google.com");
        webDriver.getTitle();
    }

    @Test
    public void testLoginFormPresent() {
        // below you can find already setup webDriver
        Boolean email = webDriver.findElements(By.id("email-input")).size()>0;
        Boolean passowrd = webDriver.findElements(By.id("password-input")).size()>0;

        if(email & passowrd){
            System.out.println("Email and password are present");
        }else{
            System.out.println("Email and password are present");
        }
        Boolean title =  webDriver.getPageSource().contains("qa_login_page");
        //System.out.println("page title : " + Title);
        Assert.assertTrue(title);
    }

    @Test
    public void testemptyfieldsarevalidated(){
        webDriver.findElement(By.id("email-input")).sendKeys(" ");
        webDriver.findElement(By.id("password-input")).sendKeys(" ");
        webDriver.findElement(By.id("login-button")).click();

        String emailerror = webDriver.findElement(By.xpath("//*[@id='messages']/div[1]")).getText();
        Assert.assertTrue(emailerror.contains("Email is required"));

        String passworerror = webDriver.findElement(By.xpath("//*[@id='messages']/div[2]")).getText();
        Assert.assertTrue(passworerror.contains("Password is required"));
    }

    @Test
    public void testerrormessagewheninvcred(){

        webDriver.findElement(By.id("email-input")).sendKeys("unknown@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();

        String emailerror = webDriver.findElement(By.xpath("//*[@id='messages']/div")).getText();
        Assert.assertTrue("Should verify that there is an error message when using invalid credentials", emailerror.contains("You shall not pass"));

    }

    @Test
    public void testemailsarevalidated(){

        webDriver.findElement(By.id("email-input")).sendKeys("unknown");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();

        String emailerror = webDriver.findElement(By.xpath("//*[@id='messages']/div")).getText();
        Assert.assertTrue("Should verify that the emails are validated", emailerror.contains("Enter a valid email"));
    }

    @Test
    public void testsuccessloginmessage(){
        webDriver.findElement(By.id("email-input")).sendKeys("login@codility.com");
        webDriver.findElement(By.id("password-input")).sendKeys("password");
        webDriver.findElement(By.id("login-button")).click();

        String emailerror = webDriver.findElement(By.xpath("//*[@id='container']/div")).getText();
        Assert.assertTrue("Should verify successful login message", emailerror.contains("Welcome to Codility"));
    }
}
