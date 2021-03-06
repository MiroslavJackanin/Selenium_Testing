package sk.it;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ResetScenarioTest {
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

    Assert.assertEquals(driver.findElement(By.id("amount")).getText(), "");
    Assert.assertEquals(driver.findElement(By.id("interest")).getText(), "");
    Assert.assertEquals(driver.findElement(By.id("period")).getAttribute("value"), "1");
  }
}
