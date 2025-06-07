package commons;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Common {

    private AppiumDriver driver;

    public Common(AppiumDriver driver) {
        this.driver = driver;
    }

    // Digitar um número
    public void digito(int numero) {
        String numeroStr = String.valueOf(numero);
        for (char caracter : numeroStr.toCharArray()) {
            WebElement digito = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_" + caracter));
            digito.click();
        }
    }

    // Clicar no botão Igual
    public void clicarIgual() {
        WebElement btnIgual = driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
        btnIgual.click();
    }

    // Mapeamento do resultado
    public String resultadoFinal() {
        return driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final")).getText();
    }

}