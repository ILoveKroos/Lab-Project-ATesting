package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Action {

    public Login(WebDriver driver) {
        super(driver);
    }

    // Khai báo các thuộc tính cần sử dụng
    private By emailField = By.id("i0116");
    private By nextButton = By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[4]/div/div/div/div/input");
    private By passwordField = By.id("i0118");
    private By signInButton = By.id("idSIButton9");
    private By nextButtonAfter = By.id("idSIButton9");

    // Nhập email
    public void enterEmail(String email) {
        sendKeys(emailField, email);
    }

    // Nhấn nút "Next" sau khi nhập email
    public void clickNextButton() {
        clickElement(nextButton);
    }

    // Nhập mật khẩu
    public void enterPassword(String password) {
        sendKeys(passwordField, password);
    }

    // Nhấn nút "Sign in" sau khi nhập mật khẩu
    public void clickSignInButton() {
        clickElement(signInButton);
    }

    // Nhấn nút "Next"
    public void clickNextButtonAfter() {
        clickElement(nextButtonAfter);
    }
}
