package DataTables;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DataTables {
	private static WebDriver driver = null;
    private By table = By.id("table1");

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
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void DataTablesOrder() {
        
        WebElement table1 = driver.findElement(table);
        
        List<WebElement> headersList = table1.findElements(By.tagName("th"));
        headersList.get(0).click();
        headersList.get(0).click();
        
        String cellValue = table1.findElement(By.xpath("//tbody/tr[2]/td[4]")).getText();
        
        assert(cellValue.contentEquals("$100.00"));
        
        
    }



    // CLOSE DRIVER INSTANCE
    @AfterClass
    public static void close() {
        // Close browser
        driver.close();
    }

}
