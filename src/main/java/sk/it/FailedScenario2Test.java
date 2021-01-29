package sk.it;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FailedScenario2Test {

  private WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\MIRO\\Desktop\\SKOLA2\\geckodriver.exe");
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
   * Testing failed scenario: wrong amount input
   */
  @Test
  public void failedScenario2Test() {
    driver.get("http://itsovy.sk/testing/");
    driver.manage().window().setSize(new Dimension(669, 695));
    driver.findElement(By.id("amount")).click();
    driver.findElement(By.id("amount")).sendKeys("-500");
    driver.findElement(By.id("interest")).click();
    driver.findElement(By.id("interest")).sendKeys("0");
    driver.findElement(By.cssSelector("input:nth-child(3)")).click();
    driver.findElement(By.id("confirm")).click();
    driver.findElement(By.id("btnsubmit")).click();
  }
}