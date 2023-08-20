import com.sun.jna.Structure;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class homeWork {
private WebDriver webDriver;
    @BeforeEach
    public void setUp() {
//        WebDriver webDriver = null;
        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
    }
    @AfterEach
    public void tearDrop() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
    @Test
    public void chooseTest() throws InterruptedException {

        webDriver.get("https://demoqa.com/automation-practice-form");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement inputName = webDriver.findElement(By.id("firstName"));
        inputName.sendKeys("Name");

        WebElement inputLastName = webDriver.findElement(By.id("lastName"));
        inputLastName.sendKeys("Last Name");

        WebElement inputEmail = webDriver.findElement(By.id("userEmail"));
        inputEmail.sendKeys("example@mail.ru");

        webDriver.findElement(By.cssSelector("label[for='gender-radio-1']")).click();

        WebElement inputTel = webDriver.findElement(By.id("userNumber"));
        inputTel.sendKeys("58471253698");

        WebElement inputSubjects = webDriver.findElement(By.id("subjectsInput"));
        inputSubjects.sendKeys("text");

        webDriver.findElement(By.id("dateOfBirthInput")).clear();
//        inputDate.sendKeys("01 Jan 1999");

        webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();

        WebElement inputAddress = webDriver.findElement(By.id("currentAddress"));
        inputAddress.sendKeys("text");

        webDriver.findElement(By.cssSelector("label[for='uploadPicture']")).sendKeys("operadriver_win64.zip");

//        webDriver.findElement(By.cssSelector("#stateCity-wrapper > div:nth-child(2) > div")).click();



        webDriver.quit();
    }
}
