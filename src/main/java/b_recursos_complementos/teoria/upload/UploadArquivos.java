package b_recursos_complementos.teoria.upload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class UploadArquivos {

    public static void main(String[] args) throws InterruptedException, AWTException {
        uploadSelenium();

//        uploadWindows();
    }

    public static void uploadSelenium() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        File arq = new File("src/main/java/b_recursos_complementos/teoria/upload/arquivo.png");

        driver.findElement(By.id("file-upload")).sendKeys(arq.getAbsolutePath());
        driver.findElement(By.id("file-submit")).submit();

        Thread.sleep(2000);

        if (driver.getPageSource().contains("File Uploaded!")) {
            System.out.println("file uploaded");
        } else {
            System.out.println("file not uploaded");
        }

        driver.quit();
    }

    public static void uploadWindows() throws InterruptedException, AWTException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement elemento = driver.findElement(By.id("file-upload"));
        Actions action = new Actions(driver);
        action.click(elemento).perform();

        File arq = new File("src/main/java/b_recursos_complementos/teoria/upload/arquivo.png");

        StringSelection ss = new StringSelection(arq.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, ss);
        Thread.sleep(2000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        if (driver.getPageSource().contains("File Uploaded!")) {
            System.out.println("UPLOAD REALIZADO!");
        } else {
            System.out.println("DEU RUIM");
        }

        driver.quit();
    }

}
