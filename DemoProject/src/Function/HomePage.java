package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Action {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // xpath Trang chủ
    private By homeButton = By.xpath("//*[@id=\"main-menu-navigation\"]/li[1]/a/span");

    // Nút về trang chủ
    public void navigateToHomePage() throws InterruptedException {
        clickElement(homeButton); // Nhấn nút về trang chủ
        Thread.sleep(1000);
        System.out.println("Đã về trang chủ");
    }

    // Đóng trình duyệt
    public void closeBrowser() {
        driver.quit();
        System.out.println("Trình duyệt đã được đóng.");
    }
}