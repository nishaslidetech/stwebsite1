package SetupClass.TestStep;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Facebook_existing_user_sign_in extends Set{
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	 JavascriptExecutor js = (JavascriptExecutor) driver;

	@Given("^user is already on Home Page old fb$")
	public void user_is_already_on_Home_Page_old_fb() throws InterruptedException {
		
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(5000);

		try {
			 System.out.println("pop_up_url  ="   +driver.getCurrentUrl());
			driver.findElement(By.cssSelector("div.social-login-authentication-channel:nth-child(3) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)")).click();
			Thread.sleep(2000);
			log.info("It's opening the website URL");
		} 
		catch (NoSuchElementException popup) {
		}
	    
	}

	@Then("^User click on sign in with facebook button old fb$")
	public void user_click_on_sign_in_with_facebook_button_old_fb() throws InterruptedException  {
		
		//driver.get("https://www.slideteam.net/");
		Thread.sleep(4000);
		WebElement fb_link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-block btn-social btn-facebook social-btn']")));
		Thread.sleep(2000);
	    fb_link.click();
		Thread.sleep(3000);
		

	    WebElement fb_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		Thread.sleep(2000);
		 fb_email.clear();
	    fb_email.sendKeys("parulpahwa309@gmail.com");
		Thread.sleep(2000);

	    WebElement fb_pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
		Thread.sleep(2000);
		fb_pass.clear();
	    fb_pass.sendKeys("parulpahwa@12");
		Thread.sleep(2000);

	    
	    WebElement fb_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.id("loginbutton")));
		Thread.sleep(2000);

	    fb_login_btn.click();
		Thread.sleep(4000);
	/*WebElement privacy =wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#platformDialogForm > div._5lnf.uiOverlayFooter._5a8u > table > tbody > tr > td._51m-.prs.uiOverlayFooterMessage > table > tbody > tr > td._51m-.uiOverlayFooterButtons._51mw > button._42ft._4jy0.layerConfirm._51_n.autofocus._4jy5._4jy1.selected._51sy")));
                Thread.sleep(3000);
		privacy.click();*/
	}

	@Then("^user go to free ppts page old fb$")
	public void user_go_to_free_ppts_page_old_fb() throws InterruptedException  {
	 
		//free ppt pg
		 System.out.println("free_ppts_url  ="   +driver.getCurrentUrl());
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		//WebElement free_ppt_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='menu-link'][normalize-space()='Free Stuff']")));
		WebElement free_ppt_btn1=wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Free Stuff")));
		actions.moveToElement(free_ppt_btn1).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Free PPTs')]"))).click().build().perform();
		Thread.sleep(7000);

	}

	@Then("^user download a free ppt old fb$")
	public void user_download_a_free_ppt_old_fb() throws InterruptedException  {
	 
		Thread.sleep(2000);
		/*Thread.sleep(2000);
		driver.findElement(By.cssSelector("li.product:nth-child(4) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)")).click();
		Thread.sleep(3000); */
		
		driver.get("https://www.slideteam.net/circular-flow-of-process-4-stages-powerpoint-slides-templates.html");
		Thread.sleep(3000);
		
		
		WebElement download_btn_pdp = driver.findElement(By.cssSelector("#clicking"));
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",download_btn_pdp);	
		Thread.sleep(2000);
		download_btn_pdp.click();
				Thread.sleep(2000);
		driver.navigate().refresh();
		
		// logout
		Thread.sleep(2000);
		try {
			WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]"));
			if (logout.isEnabled()) {
				Thread.sleep(1000);
				logout.click();
				Thread.sleep(8000);
				driver.navigate().refresh();
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException Ext) {

		}
		
	}

}
