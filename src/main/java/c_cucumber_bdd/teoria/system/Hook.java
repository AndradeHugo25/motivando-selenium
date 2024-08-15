package c_cucumber_bdd.teoria.system;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static c_cucumber_bdd.teoria.system.NomesPropriedades.PROP_PATH_BASE_REPORT;

public class Hook {

    public static Properties props;
    public static WebDriver driver;
    public static String pathReport;
    public static Web web;

    public static String login;
    public static String senha;
    public static String url;

    private static int qtdCenario;
    public static String nomeCenario;
    public static boolean isUltimoCenarioFeature;

    public static void beforeAll(Scenario cenario, NomesPropriedades loginAtual, NomesPropriedades senhaAtual, NomesPropriedades urlAtual) throws Exception {
        qtdCenario++;
        nomeCenario = cenario.getName();
        isUltimoCenarioFeature = true;
        System.out.println("CENÁRIO " + qtdCenario + " EM ANDAMENTO: " + nomeCenario);

        if (driver == null) {
            props = PropertiesLoader.inicializarProperties("config.properties");
            driver = DriverFactory.incializarDriver();
        }

        pathReport = props.getProperty(PROP_PATH_BASE_REPORT.getValor()) + "" + nomeCenario + "/";
        login = props.getProperty(loginAtual.getValor());
        senha = props.getProperty(senhaAtual.getValor());
        url = props.getProperty(urlAtual.getValor());
    }

    @After()
    public void after() {
//        driver.quit();
    }

}
