package c_cucumber_bdd.teoria.globo;

import c_cucumber_bdd.teoria.system.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GloboPages extends BasePage {

    public GloboPages(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"header-section\"]/div[2]/div[4]/div[1]/ul/li[4]/a")
    public WebElement acessoGe;
    @FindBy(how = How.ID, using = "mosaico__wrapper")
    public WebElement menuTimes;
    @FindBy(how = How.XPATH, using = "//*[@id=\"tab-content-1\"]/div[5]/a/img")
    public WebElement escudoBotafogo;
    @FindBy(how = How.XPATH, using = "//*[@id=\"bstn-rtcl\"]/div/div[1]/div/div/div/div/div/div")
    public WebElement tabelaProximosJogos;

    @FindBy(how = How.ID, using = "header-search-input")
    public WebElement iconeBusca;
    @FindBy(how = How.XPATH, using = "//*[@id=\"content\"]/div/div/ul/li[2]/div[3]/a/div[1]")
    public WebElement tituloPrimeiraNoticia;

}
