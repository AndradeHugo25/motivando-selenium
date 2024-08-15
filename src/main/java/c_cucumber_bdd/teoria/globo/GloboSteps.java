package c_cucumber_bdd.teoria.globo;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GloboSteps {

    public static WebDriver driver;
    private static GloboPages globoPages;

    private String proximosJogos;

    public static void inicializarPropriedades(WebDriver webDriver) {
        driver = webDriver;
        globoPages = new GloboPages(driver);
    }

    @Dado("que eu tenha acessado globo.com")
    public void queEuTenhaAcessadoGlobo() {
        driver.get("https://www.globo.com/");
    }

    @E("que eu tenha acessado o GE")
    public void queEuTenhaAcessadoGE() {
        globoPages.acessoGe.click();
    }

    @E("que eu tenha acessado a home do time")
    public void queEuTenhaAcessadoHomeTime() {
        globoPages.menuTimes.click();
        globoPages.escudoBotafogo.click();
    }

    @Quando("eu capturar os próximos jogos")
    public void euCapturarProximosJogos() {
        proximosJogos = globoPages.tabelaProximosJogos.getText();
    }

    @Então("eu exibo resultado")
    public void euExiboResultado() {
        System.out.println("\n" + proximosJogos);
    }

    @Quando("eu pesquisar por {string}")
    public void euPesquisarPorValor(String valor) {
        globoPages.iconeBusca.click();
        globoPages.iconeBusca.sendKeys(valor);
        globoPages.iconeBusca.sendKeys(Keys.ENTER);
    }

    @Então("eu exibo o título da primeira notícia")
    public void euExiboTituloPrimeiraNoticia() {
        String titulo = globoPages.tituloPrimeiraNoticia.getText();
        System.out.println("O título da primeira notícia é:\n" + titulo + "\n");
    }
}
