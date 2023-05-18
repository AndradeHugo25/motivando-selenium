package b_recursos_complementos.teoria.frame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();

        System.out.println("Iniciando teste no frame principal:");

        capturandoTxtFrame0(driver, true);
        capturandoTxtFrame1(driver, true);

        System.out.println("\nTrocando para frame 1:");
        driver.switchTo().frame("frame1");

        capturandoTxtFrame0(driver, true);
        capturandoTxtFrame1(driver, true);

        System.out.println("\nTrocando para parent frame:");
        driver.switchTo().parentFrame();

        capturandoTxtFrame0(driver, true);
        capturandoTxtFrame1(driver, true);

        System.out.println("\nTrocando para frame 1 e default content:");
        driver.switchTo().frame("frame1");
        driver.switchTo().defaultContent();

        capturandoTxtFrame0(driver, true);
        capturandoTxtFrame1(driver, true);

        driver.quit();
    }

    public static void capturandoTxtFrame0(WebDriver driver, boolean tratando) {
        if (tratando) {
            try {
                String txtFramePrincipal = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]")).getText();
                System.out.println(">>> SUCESSO! Capturamos o texto: " + txtFramePrincipal);
            } catch (Exception e) {
                System.out.println(">>> ERRO!! Não foi possível capturar o texto do frame 0!");
            }
        } else {
            String txtFramePrincipal = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[1]")).getText();
            System.out.println(">>> SUCESSO! Capturamos o texto: " + txtFramePrincipal);
        }
    }

    public static void capturandoTxtFrame1(WebDriver driver, boolean tratando) {
        if (tratando) {
            try {
                String txtFrame1 = driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(">>> SUCESSO! Capturamos o texto: " + txtFrame1);
            } catch (Exception e) {
                System.out.println(">>> ERRO!! Não foi possível capturar o texto do frame 1!");
            }
        } else {
            String txtFrame1 = driver.findElement(By.id("sampleHeading")).getText();
            System.out.println(">>> SUCESSO! Capturamos o texto: " + txtFrame1);
        }
    }
}
