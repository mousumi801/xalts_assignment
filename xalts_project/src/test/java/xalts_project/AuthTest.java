package xalts_project;

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.testng.Assert;
	import org.testng.annotations.*;

	public class AuthTest {
	    WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	    	System.setProperty(
		            "webdriver.chrome.driver",
		            "C:\\Selenium Webdriver\\chromeDriver\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	    	ChromeOptions options = new ChromeOptions();
	    	options.setBinary("C:\\Selenium Webdriver\\chrome-win64\\chrome-win64\\chrome.exe");
	    	
		
	    	driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://xaltsocnportal.web.app/");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	    }

	    @Test
	    public void testSignUpSuccess() {
	    	driver.findElement(By.xpath("//button[text()='Get Started']")).click();
	        driver.findElement(By.xpath("//label[text()='E-Mail']")).sendKeys("mehermousumi0@gmail.com");
	        driver.findElement(By.xpath("//label[text()='Password']")).sendKeys("Test@1234");
	        driver.findElement(By.xpath("//label[text()='Confirm Password']")).sendKeys("Test@1234");

	        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	        WebElement signout =  driver.findElement(By.xpath("//button[text()='Sign Out'])]"));
	        boolean atDashboard = signout.isDisplayed();
	        Assert.assertTrue(atDashboard, "Sign up failed.");
	    }

	    @Test
	    public void testSignInSuccess() {
	    	driver.findElement(By.linkText("Already have an account? Click here to sign in."));
	    	driver.findElement(By.xpath("//label[text()='E-Mail']")).sendKeys("mehermousumi0@gmail.com\"");
	        driver.findElement(By.xpath("//label[text()='Password']")).sendKeys("Test@1234");

	        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
	        WebElement signout =  driver.findElement(By.xpath("//button[text()='Sign Out'])]"));
	        boolean atDashboard = signout.isDisplayed();
	        Assert.assertTrue(atDashboard, "Sign up failed.");

	    }


	    @Test
	    public void testSignOut() {
	    	testSignInSuccess();
	       
	        driver.findElement(By.xpath("//button[text()='Sign Out'])]")).click();
	        
	        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign In']"));
	        boolean backToLogin = signin.isDisplayed();
	        Assert.assertTrue(backToLogin, "Logout failed.");
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}

