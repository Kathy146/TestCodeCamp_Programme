package user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserManagementTests {
    //import selenium WebDriver
    private WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        //fetch the chromedriver.exe file
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //Input the Website URL
        driver.get("https://web.facebook.com/?_rdc=1&_rdr");
        //Wait for page to load in 5 Secs
        Thread.sleep(10000);
        //Maximise the browser
        driver.manage().window().maximize();
        //Get Page Title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void loginTest() throws InterruptedException {
        //click on the Username field and input a valid username "bookytester"
        driver.findElement(By.id("email")).sendKeys("bookytester");
        //click on the password field and input a valid password "07037277604"
        driver.findElement(By.id("pass")).sendKeys("07037277604");
        //click on login/sign-in button
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(10000);
        if (driver.getCurrentUrl().contains("https://web.facebook.com/?sk=welcome")) {
            System.out.println("PASSED-User has successfully logged in");

        } else {
            System.out.println("FAILED-The user is unable to login");
        }
        Thread.sleep(10000);
        //waiting to see logged in page
    }

    @Test
    public void logoutTest() throws InterruptedException {
        //click on the user profile
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]/img")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div/div[4]/div/div[1]/div[2]/div/div/div/div/span")).click();
        if (driver.getCurrentUrl().contains("https://web.facebook.com/?_rdc=1&_rdr")) {
            System.out.println("PASSED-User has successfully logged out");
        } else {
            System.out.println("FAILED-The user is still logged in");
        }
        Thread.sleep(10000);
        //waiting to see logged out of page
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
