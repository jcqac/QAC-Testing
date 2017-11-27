import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverLoginTest
{
    private String url = "https://dev26668.service-now.com/";
    private WebDriver webDriver;

    @Before
    public void setUp()
    {
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        webDriver.quit();
    }

    @Test
    public void loginTest()
    {
        webDriver.navigate().to(url);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement login = webDriver.findElement(By.id("user_name"));
        login.sendKeys("admin");
        WebElement pword = webDriver.findElement(By.cssSelector("#user_password"));
        pword.sendKeys("3df1#FU!^4Mky38\n");
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "https://dev26668.service-now.com/navpage.do";
        assertEquals("Not on the right URL", expectedUrl, currentUrl);
    }
}
