package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurityPage extends Action {

    public SecurityPage(WebDriver driver) {
        super(driver);
    }

    // Nút Advanced Browser
    private By advancedButton = By.xpath("/html/body/div/div[2]/button[3]");

    // Link Web
    private By webLink = By.xpath("/html/body/div/div[3]/p[2]/a");

    // Nút Đăng nhập
    private By loginButton = By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button");

    public void clickAdvancedButton() {
        clickElement(advancedButton);
    }

    public void clickConnectLink() {
        clickElement(webLink);
    }

    public void clickLoginButton() throws InterruptedException {
        clickElement(loginButton);
    }
}
