//package b_recursos_complementos.teoria.annotations;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//
//public class Annotations {
//
//    @BeforeClass
//    public static void antesTudo() {
//        System.out.println("Inicializando e configurando tudo.");
//        System.out.println("Automação configurada!");
//    }
//
//    @Before
//    public void antesCenario() {
//        System.out.println("\niniciando cenário.");
//    }
//
//    @Test
//    public void cenario1() {
//        System.out.println("cenário 1 em andamento...");
//    }
//
//    @Test
//    public void cenario2() {
//        System.out.println("cenário 2 em andamento...");
//    }
//
//    @Test
//    public void cenario3() {
//        System.out.println("cenário 3 em andamento...");
//    }
//
//    @After
//    public void depoisCenario() {
//        System.out.println("finalizando cenário.");
//    }
//
//    @AfterClass
//    public static void depoisTudo() throws IOException {
//        System.out.println("\nFechando instâncias e finalizando automação!");
//        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
//    }
//}
