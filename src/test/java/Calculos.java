import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.Capabilities;

import commons.Common;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;
import operacoes.Divisao;
import operacoes.Multiplicacao;
import operacoes.Somar;
import operacoes.Subtrair;

public class Calculos {

  private AndroidDriver driver;
  private Common common;
  private Somar opSomar;
  private Subtrair opSub;
  private Multiplicacao opMulti;
  private Divisao opDiv;

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
    opMulti = new Multiplicacao(driver);
    opDiv = new Divisao(driver);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "csv/digitos.csv", numLinesToSkip = 1, delimiter = ',')
  public void executarOperacoes(int numero1, int numero2) {

    // ## Soma ##
    common.digito(numero1);
    opSomar.clicarSomar();
    common.digito(numero2);
    common.clicarIgual();

    // Validação da soma
    assertEquals(String.valueOf(numero1 + numero2), common.resultadoFinal());

    // ### Subtrair ####
    common.digito(numero1);
    opSub.clicarSub();
    common.digito(numero2);
    common.clicarIgual();

    // Validação da subtração
    assertEquals(String.valueOf(numero1 - numero2), common.resultadoFinal());

    // ### Multiplicação ###
    common.digito(numero1);
    opMulti.clicarMulti();
    common.digito(numero2);
    common.clicarIgual();

    // Validação da multiplicação
    assertEquals(String.valueOf(numero1 * numero2), common.resultadoFinal());

    // ### Divisão ###
    common.digito(numero1);
    opDiv.clicarDiv();
    common.digito(numero2);
    common.clicarIgual();

    // Validação da divisão
    double resultadoEsperadoDiv = (double) numero1 / numero2;
    String resultadoCalculadora = common.resultadoFinal().replace(".",",");
    DecimalFormat df = new DecimalFormat("#.#############");
    String resultadoFormatado;
    if (resultadoEsperadoDiv % 1 == 0) {
      resultadoFormatado = String.valueOf((int) resultadoEsperadoDiv);
    } else {
      resultadoFormatado = df.format(resultadoEsperadoDiv);
    }
    assertEquals(resultadoFormatado, resultadoCalculadora);
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
