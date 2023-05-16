package b_recursos_complementos.teoria.pageObjects.testes;

import b_recursos_complementos.teoria.pageObjects.map.Map;
import b_recursos_complementos.teoria.pageObjects.map.PagesAgrupadas;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class ComMapeamentoAgrupado {

    private static WebDriver driver;
    private static PagesAgrupadas pages;

    @BeforeClass
    public static void antesTudo() {
        System.out.println("Inicializando e configurando tudo.");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Map.URL_HOME);

        pages = new PagesAgrupadas(driver);
        System.out.println("Automação configurada!");
    }

    @Before
    public void antesCenario() {
        System.out.println("\nIniciando cenário.");
    }

    @Test
    public void cenario1() throws InterruptedException {
        System.out.println("Cenário 1 em andamento...");
        pages.botaoCertificate.click();
        trocarAba(driver, Map.PARTE_URL_CERTIFICATE);
        pages.campoFiltroPriceTo.sendKeys("33");
        Thread.sleep(6000);
    }

    @Test
    public void cenario2() {
        System.out.println("Cenário 2 em andamento...");
        trocarAba(driver, Map.PARTE_URL_HOME);
        pages.clicarLimparEnviar("python");
        pages.botaoPesquisa.click();
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
