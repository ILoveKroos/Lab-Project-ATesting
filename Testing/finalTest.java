package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Function.*;


public class finalTest {

    WebDriver driver;
    LoginPage loginPage;
    MenuPage menuPage;
    TimeTable timeTablePage;
    HrsByLesson hrsByLessonPage;
    Information informationPage;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://cntttest.vanlanguni.edu.vn:18081/Phancong02/");
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);
        menuPage = new MenuPage(driver);
        timeTablePage = new TimeTable(driver);
        hrsByLessonPage = new HrsByLesson(driver);
        informationPage = new Information(driver);
    }

    @Test(priority = 1)
    public void login() {
        loginPage.login("hao.2274802010221@vanlanguni.vn", "VLU06102004");
    }

    @Test(priority = 2)
    public void navigateToHrsByLecturer() {
        menuPage.openUserMenu();
        menuPage.selectHrsByLecturer();
    }

    @Test(priority = 3)
    public void selectTermAndWeek() {
        timeTablePage.selectTerm("666");
        timeTablePage.selectWeek("Tuần 7");
    }

    @Test(priority = 4)
    public void updateInformation() throws Exception {
        informationPage.readAndUpdateInformationFromJson("D:\\information.json");
    }

    @AfterTest
	public void close() {
		if (driver != null) {
			driver.quit();
		} else {
			System.out.println("WebDriver không được khởi tạo.");
		}
	}
}
