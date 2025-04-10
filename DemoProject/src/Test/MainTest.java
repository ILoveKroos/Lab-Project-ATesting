package Test;

import Function.Login;
import Function.SecurityPage;
import Function.ViewHrs;
import Function.HomePage;
import Function.ViewHrsLesson;
import Function.TimeTable;
import Function.UserInformation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class MainTest {
	// Khai báo biến - đối tượng
	private WebDriver driver;
	private SecurityPage security;
	private Login login;
	private ViewHrs viewHrs;
	private HomePage homePage;
	private ViewHrsLesson viewHrsLesson;
	private TimeTable timeTable;
	private UserInformation userInformation;

	private String baseURL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();

		security = new SecurityPage(driver);
		login = new Login(driver);
		viewHrs = new ViewHrs(driver);
		homePage = new HomePage(driver);
		viewHrsLesson = new ViewHrsLesson(driver);
		timeTable = new TimeTable(driver);
		userInformation = new UserInformation(driver);

	}

	// -------------Bỏ qua các bước bảo mật---------------//

	@Test(priority = 0)
	public void security() throws InterruptedException {
		security.clickAdvancedButton(); // Nút Advanced Browser
		security.clickConnectLink(); // Link Web
		Thread.sleep(1000);
		security.clickLoginButton(); // Nút Đăng nhập
		Thread.sleep(5000);
	}

	// -------------Đăng nhập vào trang---------------//

	@Test(priority = 1)
	public void login() throws InterruptedException {
		login.enterEmail("hao.2274802010221@vanlanguni.vn");
		login.clickNextButton(); // Nhấn "Next"
		login.enterPassword("VLU06102004");
		Thread.sleep(2000);
		login.clickSignInButton(); // Nhấn "Sign in"
		Thread.sleep(10000); // Đợi mã xác thực
		login.clickNextButtonAfter(); // Nhấn "Next" để vào trang web
		Thread.sleep(2000);
	}

	// -------------Xem số giờ giảng dạy---------------//

	@Test(priority = 2)
	public void menuBar() throws InterruptedException {
		viewHrs.openTab(); // Mở thanh Tab
		viewHrs.selectHoursMenu(); // Chọn Số giờ Giảng viên
	}

	@Test(priority = 3)
	public void testDropListHocky() throws InterruptedException {
		viewHrs.selectTerm("Học kỳ"); // Chọn Học kỳ
		viewHrs.selectTerm2("666"); // Chọn Học kỳ 666
		viewHrs.selectMajor("SWTECH"); // Chọn Ngành SWTECH
		viewHrs.selectTutor("Tất cả"); // Chọn Giảng viên Tất cả
	}

	@Test(priority = 4)
	public void selectBangBieu() throws InterruptedException {
		viewHrs.selectBangBieu(); // Mở bảng biểu
	}

	@Test(priority = 5)
	public void displayTable() {
		viewHrs.displayTable(); // Kiểm tra dữ liệu bảng
	}

	@Test(priority = 6)
	public void homePageHrsByLesson() throws InterruptedException {
		homePage.navigateToHomePage(); // Quay lại trang chủ sau khi hoàn thành một chức năng
		Thread.sleep(1000);
	}

	// -------------Xem danh sách môn học---------------//

	@Test(priority = 7)
	public void menuHrsByLesson() throws InterruptedException {
		viewHrsLesson.openHrsByLessonTab(); // Mở tab "Số giờ cá nhân"
	}

	@Test(priority = 8)
	public void termInput() throws InterruptedException {
		viewHrsLesson.selectTerm(); // Chọn mục "Học kỳ"
	}

	@Test(priority = 9)
	public void termInput2() throws InterruptedException {
		viewHrsLesson.selectTerm2(); // Chọn Học kỳ "666"
	}

	@Test(priority = 10)
	public void selectTable() throws InterruptedException {
		viewHrsLesson.selectTable(); // Chọn Bảng Biểu
	}

	@Test(priority = 11)
	public void displayTableHrsByLesson() throws Exception {
		viewHrsLesson.displayTable(); // Kiểm tra dữ liệu bảng
	}

	@Test(priority = 12)
	public void homePagetimeTable() throws InterruptedException {
		homePage.navigateToHomePage(); // Quay lại trang chủ sau khi hoàn thành một chức năng
		Thread.sleep(1000);
	}

	// -------------Xem thời khóa biểu---------------//

	@Test(priority = 13)
	public void openHrsByLessonTab() throws InterruptedException {
		timeTable.openTimeTable(); // Open Time Table page
	}

	@Test(priority = 14)
	public void input() throws InterruptedException {
		timeTable.inputDropdownValues("666", "7", "Trần Gia Hào"); // Điền dữ liệu
	}

	@Test(priority = 15)
	public void data() throws InterruptedException {
		timeTable.displayTimeTableData(); // Hiển thị và kiểm tra kết quả
	}

	// -------------Xem thời khóa biểu <Failed Data>--------------//

	@Test(priority = 16)
	public void inputFail() throws InterruptedException {
		timeTable.inputDropdownValues("999", "0", "Trần Gia Hào"); // Điền dữ liệu
	}

	@Test(priority = 17)
	public void dataFail() throws InterruptedException {
		timeTable.displayTimeTableData(); // Hiển thị và kiểm tra kết quả
	}

	@Test(priority = 18)
	public void homePageInformation() throws InterruptedException {
		homePage.navigateToHomePage(); // Quay lại trang chủ sau khi hoàn thành một chức năng
		Thread.sleep(1000);
	}

	// -------------Cập nhật thông tin Giảng viên---------------//

	@Test(priority = 19)
	public void openUserInfo() throws InterruptedException {
		userInformation.openUserInfoTab(); // Mở tab thông tin cá nhân
	}

	@Test(priority = 20)
	public void updateUserInfoFail() throws Exception {
		userInformation.updateUserInfoFromJson("D:\\informationFail.json"); // Đọc và điền dữ liệu từ file JSON
	}

	@Test(priority = 21)
	public void updateUserInfo() throws Exception {
		userInformation.updateUserInfoFromJson("D:\\information.json"); // Đọc và điền dữ liệu từ file JSON
	}

	@Test(priority = 22)
	public void homePagetimeAfter() throws InterruptedException {
		homePage.navigateToHomePage(); // Quay lại trang chủ sau khi hoàn thành một chức năng
		Thread.sleep(1000);
	}

	// --------------Kiểm tra lại bảng sau khi cập nhật---------------//

	@Test(priority = 23)
	public void menuBarAfter() throws InterruptedException {
		viewHrs.openTab(); // Mở thanh Tab
		viewHrs.selectHoursMenu(); // Chọn Số giờ Giảng viên
	}

	@Test(priority = 24)
	public void testDropListHockyAfter() throws InterruptedException {
		viewHrs.selectTerm("Học kỳ"); // Chọn Học kỳ
		viewHrs.selectTerm2("666"); // Chọn Học kỳ 666
		viewHrs.selectMajor("SWTECH"); // Chọn Ngành SWTECH
		viewHrs.selectTutor("Tất cả"); // Chọn Giảng viên Tất cả
	}

	@Test(priority = 25)
	public void selectBangBieuAfter() throws InterruptedException {
		viewHrs.selectBangBieu(); // Mở bảng biểu
	}

	@Test(priority = 26)
	public void displayTableAfter() {
		viewHrs.displayTable(); // Kiểm tra lại dữ liệu bảng
	}

	@AfterTest
	public void closeBrowserTest() {
		homePage.closeBrowser(); // Đóng trình duyệt sau khi tất cả kiểm tra hoàn tất
	}
	
	
}
