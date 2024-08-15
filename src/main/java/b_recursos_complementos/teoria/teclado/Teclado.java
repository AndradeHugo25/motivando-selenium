package b_recursos_complementos.teoria.teclado;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.Random;

public class Teclado {

    public static void main(String[] args) throws AWTException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.manage().window().maximize();

        driver.findElement(By.name("q")).sendKeys("python" + Keys.ENTER);
        Thread.sleep(2000);

        WebElement elemento = driver.findElement(By.id("APjFqb"));
        elemento.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
        Thread.sleep(2000);
        elemento.sendKeys("macarrão" + Keys.ENTER);

        Thread.sleep(2000);
        driver.quit();
    }

}
