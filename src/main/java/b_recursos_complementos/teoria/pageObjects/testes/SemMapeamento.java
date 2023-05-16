package b_recursos_complementos.teoria.pageObjects.testes;

import b_recursos_complementos.teoria.pageObjects.map.PagesAgrupadas;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SemMapeamento {

    private static WebDriver driver;

    @BeforeClass
    public static void antesTudo() {
        System.out.println("Inicializando e configurando tudo.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/");

        PagesAgrupadas pagesAgrupadas = new PagesAgrupadas(driver);
        System.out.println("Automação configurada!");
    }

    @Before
    public void antesCenario() {
        System.out.println("\nIniciando cenário.");
    }

    @Test
    public void cenario1() throws InterruptedException {
        System.out.println("Cenário 1 em andamento...");
        driver.findElement(By.linkText("CERTIFICATES")).click();
        trocarAba(driver, "course-catalog");
        driver.findElement(By.id("filter-Price-0-to")).sendKeys("33");
        Thread.sleep(6000);
    }

    @Test
    public void cenario2() {
        System.out.println("Cenário 2 em andamento...");
        trocarAba(driver, "w3schools");
        driver.findElement(By.id("search2")).click();
        driver.findElement(By.id("search2")).clear();
        driver.findElement(By.id("search2")).sendKeys("python");
        driver.findElement(By.id("learntocode_searchbtn")).click();
    }

    @After
    public void depoisCenario() {
        System.out.println("Finalizando cenário.");
        driver.close();
    }

    @AfterClass
    public static void depoisTudo() {
        System.out.println("\nFechando instâncias e finalizando automação!");
        driver.quit();
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
