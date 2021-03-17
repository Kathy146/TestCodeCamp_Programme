package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageObject.DashboardPage;
import pageObject.LoginPage;

public class SetupTest {

    //Create a WebDriver Object
    private WebDriver driver;

    //Create LoginPage object
    protected LoginPage loginPage;

    //Create DashboardPage object
    protected DashboardPage dashboardPage;

    @BeforeTest
    public void setUp()
    {
        //Selenium WebDriver needs this executable in order to know which browser to run your test
        //Browser setup for Chrome
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //Instantiate WebDriver object
        driver = new ChromeDriver();


        //Any activity you want to perform concerning your automated test can now be done using the driver

        //Maximize window size
        driver.manage().window().maximize();

        //Launch the application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //Instantiate login page after launching the browser - Handle
        loginPage = new LoginPage(driver);
    }
    @AfterTest
    public void closeBrowser()
    {
        // ".close" would close the window but the ".quit" would exit the session
        driver.quit();
    }
}
