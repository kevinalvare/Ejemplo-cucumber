package seleniumgluecode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Test {
    private ChromeDriver driver = Hooks.getDriver();

    @Given("I am in the login page of the Para Bank Application")
    public void i_am_in_the_login_page_of_the_para_bank_application() {
        // Write code here that turns the phrase above into concrete actions
        WebElement customerLoginMessageLocator= driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/h2"));
        assertEquals("Customer Login",customerLoginMessageLocator.getText());

    }

    @When("I enter valid credentials")
    public void i_enter_valid_credentials() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.name("username")).submit();

    }

    @Then("I should be taken to the Overview page")
    public void i_should_be_taken_to_the_overview_page() {
        // Write code here that turns the phrase above into concrete actions
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='rightPanel']/div/div/h1")));
        WebElement sinInTitleLocator = driver.findElement(By.xpath("//h1[@class='title']"));
        assertEquals("Accounts Overview", sinInTitleLocator.getText());
        //driver.findElement(By.xpath("//h1[@class='title']")).isDisplayed();
        driver.findElement(By.linkText("Log Out")).click();


    }
}
