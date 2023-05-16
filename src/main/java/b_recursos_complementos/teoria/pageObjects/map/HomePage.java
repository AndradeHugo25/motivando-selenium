package b_recursos_complementos.teoria.pageObjects.map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "CERTIFICATES")
    public WebElement botaoCertificate;
    @FindBy(how = How.ID, using = "search2")
    public WebElement campoPesquisa;
    @FindBy(how = How.ID, using = "learntocode_searchbtn")
    public WebElement botaoPesquisa;

    public void clicarLimparEnviar(String valorDesejado) {
        campoPesquisa.click();
        campoPesquisa.clear();
        campoPesquisa.sendKeys(valorDesejado);
    }

}
