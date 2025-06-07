package operacoes;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Somar {

    private AndroidDriver driver;

    public Somar(AndroidDriver driver) {
        this.driver = driver;
    }

    public void digito(int numero) {
        String numeroStr = String.valueOf(numero);
        for (char digito : numeroStr.toCharArray()) {
            WebElement dgt = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_" + digito));
            dgt.click();
        }
    }

    public void btnSomar() {
        WebElement btnSomar = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
        btnSomar.click();
    }

    public void clicarIgual() {
        WebElement btnIgual = driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
        btnIgual.click();
    }

}
