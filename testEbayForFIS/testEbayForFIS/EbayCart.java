package testEbayForFIS;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EbayCart {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver d = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(20));
		d.get("https://www.ebay.com");
        d.manage().window().maximize();	
        d.findElement(By.xpath("//*[@title=\"Search\" and @type=\"text\"]")).sendKeys("book");
        d.findElement(By.xpath("//*[@id=\"gh-search-btn\"]/span")).click();
        String parentWindow = d.getWindowHandle();
        d.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div/a/div/span")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowhandle : d.getWindowHandles()) {
        	d.switchTo().window(windowhandle);        	
        }   
     
        WebElement addToCart = d.findElement(By.xpath("//*[@id=\"atcBtn_btn_1\"]"));
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.click();
        WebElement cartItems =  d.findElement(By.xpath("//*[@id=\"gh\"]/nav/div[2]/div[4]/div/a/span/span"));
		String text = cartItems.getText();
		System.out.println(text);
		assert(text.contains("1"));
		System.out.println("Verified that 1 item added in cart successfuly");
	}

}
