package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    
    // Các phần tử
    By emailField = By.id("i0116");
    By nextButton = By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[4]/div/div/div/div/input");
    By passwordField = By.id("i0118");
    By signInButton = By.id("idSIButton9");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(nextButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }
}
