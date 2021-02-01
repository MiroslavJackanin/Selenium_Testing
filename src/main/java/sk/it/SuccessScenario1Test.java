package sk.it;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SuccessScenario1Test {

  private WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "D:\\__SCHOOL\\SKOLA2\\geckodriver.exe");
    driver = new FirefoxDriver();
  }
  @After
  public void tearDown() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.quit();
  }

  /**
   * Testing success scenario
   */
  @Test
  public void successScenario() {
    driver.get("http://itsovy.sk/testing/");
    driver.manage().window().setSize(new Dimension(669, 694));
    driver.findElement(By.id("amount")).click();
    driver.findElement(By.id("amount")).sendKeys("3500");
    driver.findElement(By.id("interest")).click();
    driver.findElement(By.id("interest")).sendKeys("3");
    driver.findElement(By.id("period")).sendKeys("3");
    driver.findElement(By.id("period")).click();
    driver.findElement(By.id("confirm")).click();
    driver.findElement(By.id("btnsubmit")).click();

    String result = driver.findElement(By.id("result")).getText();

    Assert.assertEquals(result, getResult());
  }

  private String getResult() {
    return "Total amount : 3758.10 , net profit : 258.10";
  }
}
