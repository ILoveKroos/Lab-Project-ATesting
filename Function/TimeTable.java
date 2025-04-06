package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeTable {
    WebDriver driver;

    By termDropdown = By.xpath("//*[@id=\"select2-term-container\"]");
    By weekDropdown = By.xpath("//*[@id=\"select2-week-container\"]");
    By lecturerDropdown = By.xpath("//*[@id=\"select2-lecturer-container\"]");

    public TimeTable(WebDriver driver) {
        this.driver = driver;
    }

    public void selectTerm(String term) {
        driver.findElement(termDropdown).click();
        WebElement inputTerm = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
        inputTerm.clear();
        inputTerm.sendKeys(term);
    }

    public void selectWeek(String week) {
        driver.findElement(weekDropdown).click();
        WebElement inputWeek = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
        inputWeek.clear();
        inputWeek.sendKeys(week);
    }

    public void selectLecturer(String lecturer) {
        driver.findElement(lecturerDropdown).click();
        WebElement inputLecturer = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
        inputLecturer.clear();
        inputLecturer.sendKeys(lecturer);
    }
}