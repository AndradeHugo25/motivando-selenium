//package b_recursos_complementos.teoria.pageObjects.testes;
//
//import b_recursos_complementos.teoria.pageObjects.map.CertificatePage;
//import b_recursos_complementos.teoria.pageObjects.map.HomePage;
//import b_recursos_complementos.teoria.pageObjects.map.Map;
//import b_recursos_complementos.teoria.pageObjects.map.PagesAgrupadas;
//
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.util.Set;
//
//public class ComMapeamentoEspecifico {
//
//    private static WebDriver driver;
//    private static HomePage homePage;
//    private static CertificatePage certPage;
//
//    @BeforeClass
//    public static void antesTudo() {
//        System.out.println("Inicializando e configurando tudo.");
//        //        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(Map.URL_HOME);
//
//        homePage = new HomePage(driver);
//        certPage = new CertificatePage(driver);
//        System.out.println("Automação configurada!");
//    }
//
//    @Before
//    public void antesCenario() {
//        System.out.println("\nIniciando cenário.");
//    }
//
//    @Test
//    public void cenario1() throws InterruptedException {
//        System.out.println("Cenário 1 em andamento...");
//        homePage.botaoCertificate.click();
//        trocarAba(driver, Map.PARTE_URL_CERTIFICATE);
//        certPage.campoFiltroPriceTo.sendKeys("33");
//        Thread.sleep(6000);
//    }
//
//    @Test
//    public void cenario2() {
//        System.out.println("Cenário 2 em andamento...");
//        trocarAba(driver, Map.PARTE_URL_HOME);
//        homePage.clicarLimparEnviar("python");
//        homePage.botaoPesquisa.click();
//    }
//
//    @After
//    public void depoisCenario() {
//        System.out.println("Finalizando cenário.");
//        driver.close();
//    }
//
//    @AfterClass
//    public static void depoisTudo() {
//        System.out.println("\nFechando instâncias e finalizando automação!");
//        driver.quit();
//    }
//
//    public static void trocarAba(WebDriver driver, String parteUrlEsperada) {
//        Set<String> janelas = driver.getWindowHandles();
//        String urlAux = "";
//        for (String janela : janelas) {
//            driver.switchTo().window(janela);
//            urlAux = driver.getCurrentUrl();
//            if (urlAux.contains(parteUrlEsperada)) {
//                break;
//            }
//        }
//    }
//
//}
