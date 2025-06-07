package operacoes;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Multiplicacao {

    private AndroidDriver driver;

    public Multiplicacao(AndroidDriver driver) {
        this.driver = driver;
    }

    // Operação Multiplicacao
    public void clicarMulti() {
        WebElement btnMulti = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_mul"));
        btnMulti.click();
    }
}