import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

public class Calculos {

  private AndroidDriver driver;

  @BeforeEach
  public void setUp() {
    Capabilities options = new BaseOptions()
        .amend("platformName", "Android")
        .amend("appium:platformVersion", "13.0")
        .amend("appium:deviceName", "emulator5554")
        .amend("appium:deviceOrientation", "portrait")
        .amend("appium:appPackage", "com.google.android.calculator")
        .amend("appium:appActivity", "com.android.calculator2.Calculator")
        .amend("appium:automationName", "UiAutomator2")
        .amend("browserName", "")
        .amend("appium:ensureWebviewsHavePages", true)
        .amend("appium:nativeWebScreenshot", true)
        .amend("appium:newCommandTimeout", 3600)
        .amend("appium:connectHardwareKeyboard", true);

    driver = new AndroidDriver(this.getUrl(), options);
  }

  @Test
  public void sampleTest() {
    WebElement dgt2 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2"));
    dgt2.click();

    WebElement dgt5 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_5"));
    dgt5.click();

    WebElement btnSomar = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
    btnSomar.click();

    WebElement dgt7 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_7"));
    dgt7.click();

    dgt5.click();

    WebElement btnIgual = driver.findElement(AppiumBy.id("com.google.android.calculator:id/eq"));
    btnIgual.click();

    WebElement displayResultado = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
    assertEquals("100", displayResultado.getText());

  }

  @AfterEach
  public void tearDown() {
    driver.quit();
  }

  private URL getUrl() {
    try {
      return new URL("http://127.0.0.1:4723");
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
