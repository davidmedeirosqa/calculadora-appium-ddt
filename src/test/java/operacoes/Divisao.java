package operacoes;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Divisao {

    private AndroidDriver driver;

    public Divisao(AndroidDriver driver) {
        this.driver = driver;
    }

    // Operação Divisão
    public void clicarDiv() {
        WebElement btnDiv = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_div"));
        btnDiv.click();
    }
}