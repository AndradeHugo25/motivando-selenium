package b_recursos_complementos.teoria.mouse;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.Random;

public class Mouse {

    public static void main(String[] args) throws AWTException, InterruptedException {
//        moverMouseParaElemento();
        moverMouseAleatoriamente(5);
    }

    public static void moverMouseParaElemento() throws InterruptedException {
        //        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com/ncr");
        driver.manage().window().maximize();

        WebElement elemento = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[2]"));

        Thread.sleep(3000);

        Actions action = new Actions(driver);
        action.click(elemento).perform();

        Thread.sleep(3000);

        driver.quit();
    }

    public static void moverMouseAleatoriamente(int qtdVezes) throws AWTException, InterruptedException {
        Thread.sleep(2000);
        Robot robot = new Robot();
        Random random = new Random();
        for (int i = 0; i < qtdVezes; i++) {
            int eixoX = random.nextInt(950);
            int eixoY = random.nextInt(750);

            robot.mouseMove(eixoX, eixoY);

            String horiz;
            if (eixoX >= 645) {
                horiz = "direita";
            } else {
                horiz = "esquerda";
            }

            String vert;
            if (eixoY <= 320) {
                vert = "em cima";
            } else {
                vert = "embaixo";
            }

            System.out.println("Movi para: (" + eixoX + ", " + eixoY + ") >> " + horiz + ", " + vert);
            Thread.sleep(4000);
        }
    }

}
