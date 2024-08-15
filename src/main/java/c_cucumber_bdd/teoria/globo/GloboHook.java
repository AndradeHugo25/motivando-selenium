package c_cucumber_bdd.teoria.globo;

import c_cucumber_bdd.teoria.system.Hook;
import c_cucumber_bdd.teoria.system.NomesPropriedades;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class GloboHook {

    @Before("@Globo")
    public void before(Scenario cenario) throws Exception {
        Hook.beforeAll(cenario, NomesPropriedades.PROP_TRELLO_LOGIN, NomesPropriedades.PROP_TRELLO_SENHA, NomesPropriedades.PROP_TRELLO_URL);
        GloboSteps.inicializarPropriedades(Hook.driver);
    }

}
