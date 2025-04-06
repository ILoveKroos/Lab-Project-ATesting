package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HrsByLesson {
    WebDriver driver;

    By tableButton = By.xpath("//*[@id=\"table-tab\"]");

    public HrsByLesson(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTableButton() {
        driver.findElement(tableButton).click();
    }
}