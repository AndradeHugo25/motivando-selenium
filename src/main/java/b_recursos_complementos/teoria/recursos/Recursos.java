package b_recursos_complementos.teoria.recursos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Recursos {

    public static void main(String[] args) throws InterruptedException {
//      ESPERA
//        esperaExplicita();
//        esperaImplicita();
//        waitUsingThread();

//      FRAME
//        testingFrame();

//      ABAS
//        trocarAba();
    }


    // ============================= RECURSOS =============================================
    // Explicit Wait
    public static void esperaExplicita() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.findElement(By.name("q")).sendKeys("macarrão" + Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 5);
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

    // Frame
    public static void testingFrame() {
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

    // Frame
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

    // Frame
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

    // Abas
    public static void trocarAba() {
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

    // Cross browser

    // ============================= COMPLEMENTOS =============================================
    // Print
    // Interações com teclado e mouse
    // Upload de arquivos
    // Log

}
