package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

//In the page class we need the fields that represents the elements on the page and Methods to interact with the element

    private WebDriver driver;

    /**
     * The constructor is where we pass the driver we used to launch the browser to the current page
     * @param driver this driver is the actual driver that launched the browser in the setup page
     */
    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    //Using By as a locator for elements
    private By username = By.xpath("//*[@id=\"txtUsername\"]");

    public void enterUsername(String uName)
    {
        //Find the username element and enter the username
        driver.findElement(username).sendKeys(uName);
    }

    public void enterUserPassword(String pwd)
    {
        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.sendKeys(pwd);
    }

    public DashboardPage clickLoginBtn()
    {
        driver.findElement(By.xpath("//input[@name='Submit']")).click();
        return new DashboardPage(driver);
    }
}
