package qa.justeat.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import javax.imageio.ImageIO;
import org.openqa.selenium.chrome.ChromeOptions;
 
//        new WebDriverWait(driver, 20).until(ExpectedConditions.titleContains("jQuery"));

public class TestBase {
 
	protected static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	 
	public static String timeStamp = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	public static NgWebDriver ngWebDriver;
	public static String username;
	public static String passphrase;
	
	
	 
	
	
	public static void initialization(){
		String browserName = "chrome";
		 
		
		if(browserName.equalsIgnoreCase("chrome")){
		//	ChromeOptions options = new ChromeOptions();
		//	options.addArguments("--headless"); Don't need this for Jenkin  
		//	WebDriverManager.chromedriver().setup(); - 
			
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\main\\java\\qa\\justeat\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equalsIgnoreCase("FF")){
		 
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+  "\\src\\main\\java\\qa\\justeat\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equalsIgnoreCase("IE")){
		 
			//	System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+  "\\src\\main\\java\\qa\\parkland\\drivers\\IEDriverServer.exe");	
			driver=new InternetExplorerDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		 
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	 
		
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
		
		
				
	
				
				
				driver.get("http://www.just-eat.co.uk/");
		
		
		}
	public  static void TakeFullscreenshot(String str) throws IOException {
		 Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1500)).takeScreenshot(driver);
	       ImageIO.write(screenshot.getImage(),"PNG",new File(System.getProperty("user.dir") +"/Screenshots/"+str+".png"));
	}
	
	 
	
	
	
	
	
}
