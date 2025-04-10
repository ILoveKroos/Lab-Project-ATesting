package Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class Action {
    protected WebDriver driver;

    public Action(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }
}
