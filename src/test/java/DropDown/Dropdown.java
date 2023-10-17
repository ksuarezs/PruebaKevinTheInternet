package DropDown;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	private static WebDriver driver = null;
    private By dropdown = By.id("dropdown");

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
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void DropdownOptions() {
        
        WebElement dropdownList = driver.findElement(dropdown);
        
        Select selectList = new Select(dropdownList);
        
        String option_default_text = selectList.getFirstSelectedOption().getText();
        
        assert(option_default_text.contains("Please select an option"));
        
        selectList.selectByVisibleText("Option 1");
        String option_selected = selectList.getFirstSelectedOption().getText();
        assert(option_selected.contains("Option 1"));
        
        selectList.selectByVisibleText("Option 2");
        option_selected = selectList.getFirstSelectedOption().getText();
        assert(option_selected.contains("Option 2"));
    }



    // CLOSE DRIVER INSTANCE
    @AfterClass
    public static void close() {
        // Close browser
        driver.close();
    }

}
