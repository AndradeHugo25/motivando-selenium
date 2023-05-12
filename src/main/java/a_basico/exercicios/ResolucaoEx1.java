package a_basico.exercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ResolucaoEx1 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        driver.findElement(By.linkText("Admin Page")).click();
        driver.findElement(By.id("soapEndpoint")).sendKeys("Bla bla bla");
        driver.findElement(By.id("restEndpoint")).sendKeys("Ble ble ble");
        driver.findElement(By.id("endpoint")).sendKeys("Teste");

        driver.findElement(By.id("initialBalance")).click();
        driver.findElement(By.id("initialBalance")).clear();
        driver.findElement(By.id("initialBalance")).sendKeys("20000");

        driver.findElement(By.id("minimumBalance")).click();
        driver.findElement(By.id("minimumBalance")).clear();
        driver.findElement(By.id("minimumBalance")).sendKeys("100");

        WebElement comboProvider = driver.findElement(By.id("loanProvider"));
        Select selecao = new Select(comboProvider);
        selecao.selectByIndex(1);

        WebElement comboProcessor = driver.findElement(By.id("loanProcessor"));
        selecao = new Select(comboProcessor);
        selecao.selectByIndex(2);

        driver.findElement(By.id("loanProcessorThreshold")).click();
        driver.findElement(By.id("loanProcessorThreshold")).clear();
        driver.findElement(By.id("loanProcessorThreshold")).sendKeys("20");
        driver.findElement(By.xpath("//*[@id=\"adminForm\"]/input")).click();

        String msgSite = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p/b")).getText();
        final String MSG_ESPERADA = "Settings saved successfully.";

        Assert.assertEquals(MSG_ESPERADA, msgSite);

        driver.close();
    }

}
