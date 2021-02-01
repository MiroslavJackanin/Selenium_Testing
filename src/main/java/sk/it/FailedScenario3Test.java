package sk.it;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FailedScenario3Test {

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
   * Testing failed scenario: wrong interest input
   */
  @Test
  public void failedScenario3Test() {
    driver.get("http://itsovy.sk/testing/");
    driver.manage().window().setSize(new Dimension(669, 695));
    driver.findElement(By.id("amount")).click();
    driver.findElement(By.id("amount")).sendKeys("0");
    driver.findElement(By.id("interest")).click();
    driver.findElement(By.id("interest")).sendKeys("-5");
    driver.findElement(By.id("period")).sendKeys("5");
    driver.findElement(By.id("period")).click();
    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
    driver.findElement(By.id("confirm")).click();
    driver.findElement(By.id("btnsubmit")).click();

    Assert.assertFalse(driver.findElement(By.id("result")).isDisplayed());
    Assert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
    Assert.assertEquals(driver.findElement(By.id("error")).getText(), "Interest must be a number between 0 and 100 !");
  }
}
