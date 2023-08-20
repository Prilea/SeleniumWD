import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class HomeWork {
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
        inputTel.sendKeys("5847125369");

        WebElement inputSubject = webDriver.findElement(By.id("subjectsInput"));
        inputSubject.sendKeys("Math");
        inputSubject.sendKeys(Keys.ENTER);

        webDriver.findElement(By.id("dateOfBirthInput")).click();
        WebElement elementMonth = webDriver.findElement(By.className("react-datepicker__month-select"));
        Select select1 = new Select(elementMonth);
        select1.selectByVisibleText("April");
        WebElement elementYear = webDriver.findElement(By.className("react-datepicker__year-select"));
        Select select2 = new Select(elementYear);
        select2.selectByVisibleText("1996");
        webDriver.findElement(By.className("react-datepicker__day--017")).click();


        webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        webDriver.findElement(By.cssSelector("label[for='hobbies-checkbox-2']")).click();

        WebElement inputAddress = webDriver.findElement(By.id("currentAddress"));
        inputAddress.sendKeys("text");

        File picture = new File("C:\\Users\\moker\\Desktop\\SeleniumWebDriver\\src\\test\\java\\operadriver_win64.zip");
        webDriver.findElement(By.id("uploadPicture")).sendKeys(picture.getAbsolutePath());

        WebElement state = webDriver.findElement(By.id("react-select-3-input"));
        String userState = "NCR";
        state.sendKeys(userState);
        state.sendKeys(Keys.ENTER);

        WebElement city = webDriver.findElement(By.id("react-select-4-input"));
        String userCity = "Delhi";
        city.sendKeys(userCity);
        city.sendKeys(Keys.ENTER);

        WebElement submit = webDriver.findElement(By.id("submit"));
        submit.submit();

        WebElement heading = webDriver.findElement(By.className("modal-title"));
        Assertions.assertEquals("Thanks for submitting the form", heading.getText());
        Thread.sleep(3000);

        Assertions.assertEquals("Name Last Name", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(1) > td:nth-child(2)")).getText());
        Assertions.assertEquals("example@mail.ru", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(2) > td:nth-child(2)")).getText());
        Assertions.assertEquals("Male", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(3) > td:nth-child(2)")).getText());
        Assertions.assertEquals("5847125369", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(4) > td:nth-child(2)")).getText());
        Assertions.assertEquals("17 April,1996", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(5) > td:nth-child(2)")).getText());
        Assertions.assertEquals("Sports, Reading", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(7) > td:nth-child(2)")).getText());
        Assertions.assertEquals("operadriver_win64.zip", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(8) > td:nth-child(2)")).getText());
        Assertions.assertEquals("text", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(9) > td:nth-child(2)")).getText());
        Assertions.assertEquals("NCR Delhi", webDriver.findElement(By.cssSelector("tbody > tr:nth-child(10) > td:nth-child(2)")).getText());

    }
}
