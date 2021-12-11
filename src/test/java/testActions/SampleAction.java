package testActions;

import org.openqa.selenium.By;

import testDriver.Shell;

import java.util.concurrent.TimeUnit;

public class SampleAction extends Shell{
	public static void sampleMethod() {

	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/h3")).isDisplayed()){
			driver.findElement(By.id("name")).click();
			log.info("clicked on Name button");


			driver.findElement(By.id("name")).sendKeys("Ayushi");
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/button/span[2]")).click();
			log.info("Fill in your Information popup is closed");
		}
else{
			System.out.println("");
		}
		driver.findElement(By.id("name")).click();
		log.info("clicked on Name button");

		driver.findElement(By.id("name")).sendKeys("Ayushi");

	}
}
