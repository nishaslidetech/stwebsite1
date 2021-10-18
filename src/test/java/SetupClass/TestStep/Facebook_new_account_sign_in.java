package SetupClass.TestStep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Facebook_new_account_sign_in extends Set {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	 JavascriptExecutor js = (JavascriptExecutor) driver;


	@Given("^user is already on Home Page new fb$")
	public void user_is_already_on_Home_Page_new_fb() throws InterruptedException  {
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		
		try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
		Thread.sleep(2000);
		try {
			//driver.manage().deleteAllCookies();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//a[contains(text(),'Sign in with Facebook')]")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} 
		catch (NoSuchElementException popup) {
		}
	    
	}

	@Then("^User click on sign in with facebook button$")
	public void user_click_on_sign_in_with_facebook_button() throws InterruptedException  {
		Thread.sleep(2000);
                
		 WebElement fb_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
			Thread.sleep(2000);
		      fb_email.clear();
		    fb_email.sendKeys("slidetech.qa@gmail.com");
			Thread.sleep(2000);

		    WebElement fb_pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
			Thread.sleep(2000);
		   fb_pass.clear();
		    fb_pass.sendKeys("himanshi@123");
			Thread.sleep(2000);

		    WebElement fb_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbutton")));
			Thread.sleep(2000);
		    fb_login_btn.click();
			Thread.sleep(2000);
		
		/*WebElement privacy =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#platformDialogForm > div._5lnf.uiOverlayFooter._5a8u > table > tbody > tr > td._51m-.prs.uiOverlayFooterMessage > table > tbody > tr > td._51m-.uiOverlayFooterButtons._51mw > button._42ft._4jy0.layerConfirm._51_n.autofocus._4jy5._4jy1.selected._51sy")));
                Thread.sleep(3000);
		privacy.click();*/
	}

	@Then("^user go to free ppts page new fb$")
	public void user_go_to_free_ppts_page_new_fb() throws InterruptedException  {
		//WebElement free_ppt_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.menu-item:nth-child(2) > a:nth-child(1)")));
		//Thread.sleep(2000);

	   // free_ppt_btn.click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		WebElement free_ppt_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Free Stuff")));
		actions.moveToElement(free_ppt_btn1).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Free PPTs')]"))).click().build().perform();
		Thread.sleep(7000);
	
	}
	    

	@Then("^user download a free ppt new fb$")
	public void user_download_a_free_ppt_new_fb() throws InterruptedException  {
		/*
		 * driver.findElement(By.
		 * cssSelector("li.product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)"
		 * )).click(); Thread.sleep(3000);
		 */
		
		driver.get("https://www.slideteam.net/prod-development-and-program-management.html");
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("#clicking")).click();
		Thread.sleep(6000);
	}

	@Then("^user delete the fb account new fb$")
	public void user_delete_the_fb_account_new_fb() throws InterruptedException  {
		
		 driver.get("https://www.slideteam.net/");
		   Thread.sleep(3000);
		   
		 driver.findElement(By.xpath("//a[contains(.,'My Account')]")).click();
		 Thread.sleep(3000);
		 
		 
		


/*try {
			WebElement iframe = driver.findElement(By.id("livechat-full-view"));
			if(iframe.isDisplayed()) {
				driver.switchTo().frame(iframe);   
				 Actions act = new Actions(driver);
				 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
				 Thread.sleep(2000);
					WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
					 Thread.sleep(1000);
						chat1.click();
						 Thread.sleep(1000);
						 driver.switchTo().defaultContent();
						 Thread.sleep(1000);
						 driver.switchTo().parentFrame();
					 Thread.sleep(1000);
			}
			else {
				

			System.out.println("chat window does not open");
			}
		}
				catch(NoSuchElementException NCP) {
					
				}

        
		 /*WebElement delete_account = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div/div[2]/div[2]/div[2]/ul/li/a")));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/form/button[1]")));
		js.executeScript("arguments[0].scrollIntoView();",continue_delete);
		continue_delete.click();
		 Thread.sleep(3000);*/
		
		/* WebElement delete_account = driver.findElement(By.xpath("//a[contains(text(),'Delete Account')]"));
		js.executeScript("arguments[0].scrollIntoView();",delete_account);
		 delete_account.click();
		 Thread.sleep(3000);
		 WebElement continue_delete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'Continue')]")));
		js.executeScript("arguments[0].scrollIntoView();",continue_delete);
		continue_delete.click();
		 Thread.sleep(3000);
	}*/
		
    try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
	}
	
}
