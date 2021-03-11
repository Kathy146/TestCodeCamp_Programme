package User;

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
        System.setProperty("webdriver.chrome.driver","Resources/chromedriver.exe");
        //launch the chromedriver.exe file
        driver = new ChromeDriver();
        //Input the Website URL
        driver.get("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login");
        //Wait for page to load in 5 Secs
        Thread .sleep(10000);
        //Maximise the browser
        driver.manage().window().fullscreen();
        //Get Page Title
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
    @Test
    public void loginTest() throws InterruptedException {
        //click on the Username field and input a valid username "performancetest"
      driver.findElement(By.id("username")).sendKeys("performancetest");
        //click on the password field and input a valid password "admin123."
        driver.findElement(By.id("password")).sendKeys("admin123.");
        //click on login/sign-in button
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[2]/div/div/div/div[2]/div/div/form/button")).click();
        Thread.sleep(10000);
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/app/feed")){
            System.out.println("PASSED-User has successfully logged in");

        }else{
            System.out.println("FAILED-The user is unable to login");
        }Thread.sleep(10000);
        //waiting to see logged in page

    }
    @Test
    public  void logoutTest() throws InterruptedException {
        //click on the user profile
        driver.findElement (By.xpath("//*[@id=\"root\"]/div/div/div/main/div/div[1]/div[1]/div/div[2]/div[3]/button")).click();
        Thread.sleep(10000);
        driver.findElement (By.linkText("Log Out")).click();
        if (driver.getCurrentUrl().contains("https://dev.d2rxvhrryr2bkn.amplifyapp.com/login")) {
            System.out.println("PASSED-User has successfully logged out");

        }else{
            System.out.println("FAILED-The user is still logged in");
        }Thread.sleep(10000);
        //waiting to see logged out of page
    }
    @AfterTest
    public  void tearDown(){
        driver.quit();
    }
}
