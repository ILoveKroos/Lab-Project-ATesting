package Function;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.FileReader;

public class UserInformation extends Action {

    public UserInformation(WebDriver driver) {
        super(driver);
    }

    // Khai báo các thuộc tính cần sử dụng
    private By profileIcon = By.xpath("//*[@id=\"dropdown-user\"]/span/img");
    private By profileLink = By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]");
    private By staffIdInput = By.id("staff_id");
    private By fullNameInput = By.id("full_name");

    // Mở tab thông tin cá nhân
    public void openUserInfoTab() throws InterruptedException {
        clickElement(profileIcon);
        Thread.sleep(1000);
        clickElement(profileLink);
        Thread.sleep(1000);
    }

    // Điền thông tin từ file JSON
    public void updateUserInfoFromJson(String jsonFilePath) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonFilePath));

        JSONArray infoArray = (JSONArray) jsonObject.get("information");

        JSONObject info = (JSONObject) infoArray.get(0);
        String staffId = (String) info.get("staff_id");
        String fullName = (String) info.get("full_name");

        WebElement staffIdField = driver.findElement(staffIdInput);
        WebElement fullNameField = driver.findElement(fullNameInput);

        String oldStaffId = staffIdField.getAttribute("value");
        String oldFullName = fullNameField.getAttribute("value");

        staffIdField.clear();
        staffIdField.sendKeys(staffId);

        fullNameField.clear();
        fullNameField.sendKeys(fullName);
        
        driver.findElement(By.xpath("//*[@id=\"profile-form\"]/button")).click();
        Thread.sleep(1000);
        try {
	        // Tìm phần tử thông báo lỗi
	        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"staff_id-error\"]"));
	        
	        // Lấy và in ra thông báo lỗi nếu tìm thấy
	        String errorText = errorMessage.getText();
	        System.out.println("Thông báo lỗi: " + errorText);
	    } catch (NoSuchElementException e) {
	        // Nếu không tìm thấy phần tử, in thông báo và tiếp tục
	        System.out.println("Không tìm thấy thông báo lỗi, tiếp tục thực hiện các bước tiếp theo.");
	    }
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/div/div[6]/button[1]")).click();

        System.out.println("Đã thay đổi \"" + oldStaffId + "\" \"" + oldFullName + "\" sang \"" + staffId + "\" \"" + fullName + "\"");

        Assert.assertEquals(staffIdField.getAttribute("value"), staffId);
        Assert.assertEquals(fullNameField.getAttribute("value"), fullName);
    }
}
