package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
    WebDriver driver;
    
    // Các phần tử
    By userDropdown = By.xpath("//*[@id=\"dropdown-user\"]/span/img");
    By hrsByLecturerLink = By.linkText("Số giờ giảng viên");
    
    public MenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openUserMenu() {
        driver.findElement(userDropdown).click();
    }

    public void selectHrsByLecturer() {
        driver.findElement(hrsByLecturerLink).click();
    }
}