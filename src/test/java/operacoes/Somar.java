package operacoes;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Somar {

    private AndroidDriver driver;

    public Somar(AndroidDriver driver) {
        this.driver = driver;
    }

    // Operação Somar
    public void clicarSomar() {
        WebElement btnSomar = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
        btnSomar.click();
    }
}