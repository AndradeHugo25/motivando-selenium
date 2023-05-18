package b_recursos_complementos.teoria.cross_browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class MultiBrowser {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setBrowser(String browser)
    {
        if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void login() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[2]")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }

}

