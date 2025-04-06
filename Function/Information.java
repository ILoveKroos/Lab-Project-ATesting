package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class Information {
    WebDriver driver;

    By staffIdInput = By.id("staff_id");
    By fullNameInput = By.id("full_name");

    public Information(WebDriver driver) {
        this.driver = driver;
    }

    public void updateInformation(String staffId, String fullName) {
        driver.findElement(staffIdInput).clear();
        driver.findElement(staffIdInput).sendKeys(staffId);

        driver.findElement(fullNameInput).clear();
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public void readAndUpdateInformationFromJson(String jsonFilePath) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonFilePath));
        JSONObject information = (JSONObject) ((JSONArray) jsonObject.get("information")).get(0);

        String staffId = (String) information.get("staff_id");
        String fullName = (String) information.get("full_name");

        updateInformation(staffId, fullName);
    }
}
