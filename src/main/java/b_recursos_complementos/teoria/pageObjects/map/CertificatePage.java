package b_recursos_complementos.teoria.pageObjects.map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CertificatePage {

    public CertificatePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "filter-Price-0-to")
    public WebElement campoFiltroPriceTo;

}
