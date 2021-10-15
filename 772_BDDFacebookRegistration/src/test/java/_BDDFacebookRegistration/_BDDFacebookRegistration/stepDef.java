package _BDDFacebookRegistration._BDDFacebookRegistration;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class stepDef {
WebDriver driver;
String url;
	
	@Given("^browser details$")
	public void browser_details() throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	   
	}

	@Given("^url details$")
	public void url_details() throws Throwable {
		url="https://www.facebook.com/";
	}

	@When("^Load page$")
	public void load_page() throws Throwable {
		driver.get(url);
		
	}

	@Then("^I validate page title and print title$")
	public void i_validate_page_title_and_print_title() throws Throwable {
		System.out.println("Title :"+ driver.getTitle());
	   Assert.assertTrue(driver.getTitle().contains("Facebook "));
	   System.out.println("title is displayed correctly");
	}
	
	WebElement newAccount;
	//Checking check in page is opened
	@Given("^Sign in button$")
	public void sign_in_button() throws Throwable {
		//Actions a=new Actions(driver);
		newAccount=driver.findElement(By.xpath("//a[text()='Create New Account']"));
	//	a.moveToElement(newAccount).click().build().perform();
		
				//driver.findElement(By.id("u_0_2_fc"));
	}

	
	WebElement form;
	@When("^clicked on it$")
	public void clicked_on_it() throws Throwable {
		 newAccount.click();
		  System.out.println("clciked on Create account button");
			
	}


	
	@Then("^Sign In form is dispalyed$")
	public void sign_In_form_is_dispalyed() throws Throwable {
	Thread.sleep(3000);
		 
driver.findElement(By.xpath("//div[@class='_8ien']")).isDisplayed();
	/*
	 //identifing the form using javascript executor
	String forms="document.getElementsByClassName('_8ien')[0]";
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement element=(WebElement) js.executeScript(forms);
	System.out.println("element" + element);
	element.isDisplayed();
	*/
	   System.out.println("Sign in form is displayed");
	    }
	
	
	String firstName,lastName,mobile,month,day,year,gender,password;
	//passing values to sign in form
	
	@Given("^First name$")
	public void first_name(DataTable table) throws Throwable {
	    List<List<String>> data=table.raw();
	    
	    System.out.println("FirstName :" +data.get(0).get(0));
	    System.out.println("LastName :" +data.get(0).get(1));
	    System.out.println("mobile number :" +data.get(0).get(2));
	    System.out.println("Password :" +data.get(0).get(3));
	    
	    System.out.println("DOB-month :" +data.get(0).get(4));
	    System.out.println("DOB-day :" +data.get(0).get(5));
	    System.out.println("DOB-year :" +data.get(0).get(6));
	    System.out.println("gender :" +data.get(0).get(7));
	    
	    firstName=data.get(0).get(0);
	    lastName=data.get(0).get(1);
	    mobile=data.get(0).get(2);
	    password=data.get(0).get(3);
	    month=data.get(0).get(4);
	    day=data.get(0).get(5);
	    year=data.get(0).get(6);
	    gender=data.get(0).get(7);
	 //   driver.findElement(By.xpath("//input[@aria-label=\"First name\"]")).sendKeys(firstName);
	    
	    driver.findElement(By.cssSelector("[aria-label='First name']")).sendKeys(firstName);
	    driver.findElement(By.cssSelector("[aria-label=\"Last name\"]")).sendKeys(lastName);
	    driver.findElement(By.cssSelector("[aria-label=\"Mobile number or email\"]")).sendKeys(mobile);
	    driver.findElement(By.cssSelector("[id=\"password_step_input\"]")).sendKeys(password);
	 
	
	    Select s= new Select(driver.findElement(By.cssSelector("#month")));
	    s.selectByVisibleText(month);
	    
	 //   driver.findElement(By.cssSelector("#day")).click();
	    Select s1= new Select(driver.findElement(By.cssSelector("#day")));
	    s.selectByVisibleText(day);
	
	 //   s.selectByVisibleText(day);
	  //  driver.findElement(By.cssSelector("#year")).click();
	    Select s2= new Select(driver.findElement(By.cssSelector("#year")));
	   s.selectByValue("2002");
	  //  s.selectByVisibleText("2002");
	    if(gender.contains("Female")) {
	   driver.findElement(By.xpath("//input[@class=\"_8esa\"]")).click();
	    }else if(gender.contains("Male")){
	    	driver.findElement(By.xpath("//input[@class=\"_8esa\" and @value='2']")).click();
	    }else {
	    	driver.findElement(By.cssSelector("input._8esa[value='-1']")).click();
	    }
	  //  driver.findElement(By.xpath("//button[@type='submit']")).click();
	}





}
