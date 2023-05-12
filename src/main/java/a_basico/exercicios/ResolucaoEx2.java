package a_basico.exercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ResolucaoEx2 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.globo.com/");

        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.linkText("Cartola")).click();
        driver.findElement(By.xpath("//*[@id=\"header-produto\"]/div[2]/div/div/div[1]/div/span")).click();
        driver.findElement(By.linkText("brasileirão")).click();
        String primeiroLugar = driver.findElement(By.xpath("//*[@id=\"classificacao__wrapper\"]/article/section[1]/div/table[1]/tbody/tr[1]/td[2]/strong")).getText();

        System.out.println("\n>>> O 1º lugar do brasileirão é o " + primeiroLugar);

        Assert.assertEquals("Botafogo", primeiroLugar);

        driver.close();
    }

}
