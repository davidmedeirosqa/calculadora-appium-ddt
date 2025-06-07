package operacoes;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Subtrair {

    private AndroidDriver driver;

    public Subtrair(AndroidDriver driver) {
        this.driver = driver;
    }

    // Operação Subtrair
    public void clicarSub() {
        WebElement btnSub = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_sub"));
        btnSub.click();
    }
}