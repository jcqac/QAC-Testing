import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExample
{
    private String url = "https://wwww.google.com";
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
    public void qaTest()
    {
        webDriver.navigate().to(url);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement searchBar = webDriver.findElement(By.cssSelector("#lst-ib"));
        searchBar.sendKeys("qa\n");
        WebElement qaLink = webDriver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div:nth-child(1) > div > div > h3 > a"));
        String currentUrl = webDriver.getCurrentUrl();
        String expectedUrl = "https://www.qa.com/";
        //assertEquals("Not on the right URL", expectedUrl, currentUrl);
    }
}
