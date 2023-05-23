package b_recursos_complementos.teoria.espera;

import b_recursos_complementos.teoria.log.Log;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class Espera {

    public static void main(String[] args) throws InterruptedException, IOException {
//        esperaImplicita();
//        esperaImplicitaComErro();
//        esperaExplicita();
//        waitUsingThread();
    }

    // Implicit Wait
    public static void esperaImplicita() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));
        WebElement elemento = driver.findElement(By.xpath("//a/h3"));
        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));

        System.out.println(elemento.getText());
        driver.quit();
    }

    // Implicit Wait Com Erro
    public static void esperaImplicitaComErro() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));

        WebElement elemento = null;
        try {
            elemento = driver.findElement(By.xpath("//a/h3666"));
        } catch (Exception e) {
            System.out.println("Não achou o danado!");
            driver.quit();
        }

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));
    }

    // Explicit Wait
    public static void esperaExplicita() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));

        System.out.println(elemento.getText());
        driver.quit();
    }

    // Thread
    public static void waitUsingThread() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));

        Thread.sleep(6000);
        WebElement elemento = driver.findElement(By.xpath("//a/h3"));

        System.out.println(Log.getDataAtualFormatada("HH:mm:ss.SSS"));

        System.out.println(elemento.getText());
        driver.quit();
    }
}
