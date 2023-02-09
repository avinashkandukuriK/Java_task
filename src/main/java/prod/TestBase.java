package prod;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class TestBase {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		String Title = driver.getTitle();
		List<WebElement> listoflinks = new ArrayList();
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/div/div[2]")).sendKeys("Automation");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[1]/div[1]/div[2]/button")).click();
		listoflinks = driver.findElements(By.xpath("password-input"));
		WebElement element = listoflinks.get(2);
		element.click();
	}
}