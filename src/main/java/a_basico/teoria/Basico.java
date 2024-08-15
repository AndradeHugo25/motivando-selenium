package a_basico.teoria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Set;

public class Basico {

    public static void main(String[] args) throws IOException {
//        isRegressao();

//        //        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://webdriveruniversity.com/index.html");

        //click
        driver.findElement(By.xpath("//*[@id=\"dropdown-checkboxes-radiobuttons\"]/div/div[1]/h1")).click();

        trocarAba(driver, "Drop");

        //select (combo)
        WebElement combo1 = driver.findElement(By.id("dropdowm-menu-1"));
        Select selecao = new Select(combo1);
        selecao.selectByIndex(2);

        //fechamento da aba
        driver.close();

        trocarAba(driver, "index");

        //acessando direto
        driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");

        //sendKeys, clear
        driver.findElement(By.name("first_name")).sendKeys("Teste");
        driver.findElement(By.name("first_name")).clear();
        driver.findElement(By.name("first_name")).sendKeys("NovoTeste");
        driver.findElement(By.name("last_name")).sendKeys("Fulano de Tal");
        driver.findElement(By.name("email")).sendKeys("bla@gmail.com");
        driver.findElement(By.name("message")).sendKeys("Um texto qualquer aqui");
        driver.findElement(By.xpath("//*[@id=\"form_buttons\"]/input[2]")).click();

        //getText
        String msg = driver.findElement(By.xpath("//*[@id=\"contact_reply\"]/h1")).getText();

        //validação
        Assert.assertEquals("Thank You for your Message!", msg);

        //fechamento do driver
        driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    public static void isRegressao() {
        try {
            Properties props = new Properties();
            InputStream resource = Basico.class.getClassLoader().getResourceAsStream("config.properties");
            props.load(new InputStreamReader(resource, StandardCharsets.UTF_8));

            boolean regressao = Boolean.parseBoolean(props.getProperty("regressao"));
            if (regressao) {
                System.out.println("ESTAMOS NUMA REGRESSÃO!");
            }
        } catch (Exception e) {
            System.out.println("");
        }

    }

    public static void trocarAba(WebDriver driver, String parteUrlEsperada) {
        Set<String> janelas = driver.getWindowHandles();
        String urlAux = "";
        for (String janela : janelas) {
            driver.switchTo().window(janela);
            urlAux = driver.getCurrentUrl();
            if (urlAux.contains(parteUrlEsperada)) {
                break;
            }
        }
    }
}
