package LogIn;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InvalidPassword {
	private static WebDriver driver = null;
    private By usernameInput = By.id("username");
    private By passwordInput = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit' and @class='radius']");
    private By loginMessageTextBox = By.xpath("//div[@id='flash']");

    // INITIALIZE DRIVER
    @BeforeClass
    public static void initialize() {
        ArrayList<String> optionsList = new ArrayList<String>();
        ChromeOptions chromeOptions = new ChromeOptions();
        optionsList.add("--start-maximized");
        optionsList.add("--incognito");
        optionsList.add("ignore-certificate-errors");
        chromeOptions.addArguments(optionsList);
        driver = new ChromeDriver(chromeOptions);
        // Open URL
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void LoginFail() {
        
        WebElement usernameForm = driver.findElement(usernameInput);
        usernameForm.sendKeys("tomsmith");

        WebElement passwordForm = driver.findElement(passwordInput);
        passwordForm.sendKeys("invalidPassword");

        WebElement loginSubmit = driver.findElement(loginButton);
        loginSubmit.click();

        WebElement successMessage = driver.findElement(loginMessageTextBox);
        String message = successMessage.getText();
        assert message.contains("Your password is invalid!");
    }



    // CLOSE DRIVER INSTANCE
    @AfterClass
    public static void close() {
        // Close browser
        driver.close();
    }

}
