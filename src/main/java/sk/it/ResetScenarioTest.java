package sk.it;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.HashMap;
import java.util.Map;

public class ResetScenarioTest {
  private WebDriver driver;

  @Before
  public void setUp() {
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
   * Testing reset
   */
  @Test
  public void resetScenarioTest() {
    driver.get("http://itsovy.sk/testing/");
    driver.manage().window().setSize(new Dimension(669, 696));
    driver.findElement(By.id("amount")).click();
    driver.findElement(By.id("amount")).sendKeys("456");
    driver.findElement(By.id("interest")).click();
    driver.findElement(By.id("interest")).sendKeys("3");
    driver.findElement(By.id("period")).sendKeys("3");
    driver.findElement(By.id("period")).click();
    driver.findElement(By.id("confirm")).click();
    driver.findElement(By.id("btnsubmit")).click();
    driver.findElement(By.id("btnreset")).click();
  }
}
