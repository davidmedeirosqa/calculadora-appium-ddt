import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Capabilities;

import commons.Common;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import operacoes.Somar;
import operacoes.Subtrair;

public class Calculos {

  private AndroidDriver driver;
  private Common common;
  private Somar opSomar;
  private Subtrair opSub;

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
    common = new Common(driver);
    opSomar = new Somar(driver);
    opSub = new Subtrair(driver);
  }

  @Test
  public void sampleTest() {

    // Declaração de valor
    int numero1 = 500;
    int numero2 = 500;
    
    // int resultadoMult = numero1 * numero2;
    // int resultadoDiv = numero1 / numero2;

    // ## Soma ##
    common.digito(numero1);
    opSomar.clicarSomar();
    common.digito(numero2);
    common.clicarIgual();

    // Validação da soma
    int resultadoEsperadoSoma = numero1 + numero2;
    assertEquals(String.valueOf(resultadoEsperadoSoma), common.resultadoFinal());

    // ### Subtrair ####
    common.digito(numero1);
    opSub.clicarSub();
    common.digito(numero2);
    common.clicarIgual();

    // Validação da subtração
    int resultadoEsperadoSub = numero1 - numero2;
    assertEquals(String.valueOf(resultadoEsperadoSub), common.resultadoFinal());
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
