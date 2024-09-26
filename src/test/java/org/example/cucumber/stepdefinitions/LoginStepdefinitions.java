package org.example.cucumber.stepdefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepdefinitions {
	
    WebDriver driver;
    
    @Before
    public void setUp() {
 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
    }
      
    @Given("User is on Home page")
    public void userOnHomePage() {
         
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }
  
    @When("User enters username as {string}")
    public void entersUsername(String userName)  {
  
        System.out.println("Username Entered");
        driver.findElement(By.name("username")).sendKeys(userName);
        
  
    }
  
    @When("User enters password as {string}")
    public void entersPassword(String passWord)  {
  
        System.out.println("Password Entered");
        driver.findElement(By.name("password")).sendKeys(passWord);
        driver.findElement(By.xpath("//*[@class='oxd-form']/div[3]/button")).submit();
    }
  
    @Then("User should be able to login sucessfully")
    public void sucessfullLogin()  {
  
         String homePageHeading = driver.findElement(By.xpath("//*[@class='oxd-topbar-header-breadcrumb']/h6")).getText();
 
         //Verify new page - HomePage
         Assert.assertEquals("Dashboard",homePageHeading);   
  
    }
  
    @Then("Login will be unsuccessfull with error message {string}")
    public void unsucessfullLogin(String expectedErrorMessage)  {
  
         String actualErrorMessage = driver.findElement(By.xpath("//*[@class='orangehrm-login-error']/div[1]/div[1]/p")).getText();
 
         // Verify Error Message
         Assert.assertEquals( expectedErrorMessage, actualErrorMessage);
  
    }
     
    @After
    public void teardown() {
 
        driver.quit();
    }

}
