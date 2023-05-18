package b_recursos_complementos.teoria.aba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Aba {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.w3schools.com/");
        driver.findElement(By.linkText("CERTIFICATES")).click();

        try {
            driver.findElement(By.partialLinkText("Need help to")).click();
        } catch (Exception e) {
            System.out.println("Não foi possível clicar no elemento!\n");
        }

        System.out.println("Janelas antes:\n");

        Set<String> janelas = driver.getWindowHandles();
        for (String janela : janelas) {
            driver.switchTo().window(janela);
            System.out.println("URL ATUAL: " + driver.getCurrentUrl());
        }

        driver.findElement(By.partialLinkText("Need help to")).click();

        System.out.println("\nJanelas depois:\n");

        janelas = driver.getWindowHandles();
        for (String janela : janelas) {
            driver.switchTo().window(janela);
            System.out.println("URL ATUAL: " + driver.getCurrentUrl());
        }

        driver.quit();
    }

}
