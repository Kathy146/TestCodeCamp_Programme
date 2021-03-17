package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    public DashboardPage (WebDriver driver) { this.driver = driver; }

    private WebDriver driver;

    //Locate elements
    private By welcomeAdmin = By.cssSelector("#branding a:nth-child(2)");
    private By logOut = By.xpath("/html/body/div[1]/div[1]/a[2]");

    //Functions to interact with the element
    public void clickWelcomeAdmin() throws InterruptedException
    {
        //Wait for 10 seconds before executing the action
        Thread.sleep(10000);
        driver.findElement(welcomeAdmin).click();
    }
    public LoginPage clickLogout() throws InterruptedException
    {
        //Wait for 3 seconds before executing the action
        Thread.sleep(3000);
        driver.findElement(logOut).click();
        return new LoginPage(driver);
    }
}
