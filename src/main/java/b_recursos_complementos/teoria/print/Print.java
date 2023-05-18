package b_recursos_complementos.teoria.print;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Print {

    public static void main(String[] args) {
//        printTela();
//        printarTela();
    }

    public static void printTela() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/java/b_recursos_complementos/teoria/recursos/report/print.png"));

        driver.quit();
    }

    // Print
    public static void printarTela() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");

        String data = getDataAtualFormatada("yyyy_MM_dd HH-mm-ss");

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/java/b_recursos_complementos/teoria/recursos/report/"+ data + ".png"));

        driver.findElement(By.id("navbtn_references")).click();
        Thread.sleep(2000);

        data = getDataAtualFormatada("yyyy_MM_dd HH-mm-ss");

        scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("src/main/java/b_recursos_complementos/teoria/recursos/report/"+ data + ".png"));

        driver.quit();
    }

    // Data e Hora
    public static String getDataAtualFormatada(String formato) {
        Calendar calendario = Calendar.getInstance();
        SimpleDateFormat formatadorData = new SimpleDateFormat(formato);
        return formatadorData.format(calendario.getTime());
    }
}
