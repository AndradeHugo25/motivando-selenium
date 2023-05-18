package b_recursos_complementos.teoria.espera;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Espera {

    public static void main(String[] args) throws InterruptedException {
        esperaExplicita();
        esperaImplicita();
        waitUsingThread();
    }

    // Explicit Wait
    public static void esperaExplicita() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        System.out.println(firstResult.getText());
        driver.quit();
    }

    // Implicit Wait
    public static void esperaImplicita() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement elemento = driver.findElement(By.xpath("//a/h3"));

        System.out.println(elemento.getText());
        driver.quit();
    }

    // Thread
    public static void waitUsingThread() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        Thread.sleep(5000);
        WebElement elemento = driver.findElement(By.xpath("//a/h3"));

        System.out.println(elemento.getText());
        driver.quit();
    }
}
