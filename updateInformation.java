
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class updateInformation {
	public String BaseURL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void Security() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div[2]/button[3]")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/p[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/div/form/div/div/div/button")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 1) // Login
	public void Login() throws InterruptedException {
		driver.findElement(By.id("i0116")).sendKeys("hao.2274802010221@vanlanguni.vn");
		driver.findElement(By.xpath(
				"/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div[1]/div[3]/div/div/div/div[4]/div/div/div/div/input"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.id("i0118")).sendKeys("VLU06102004");
		Thread.sleep(1000);
		driver.findElement(By.id("idSIButton9")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(
				"/html/body/div/form/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div[2]/div/div/div[2]/input"))
				.click();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void Menubar() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void information() throws Exception {
		// Đọc dữ liệu từ file JSON
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("D:\\informationLack.json"));

		// Lấy mảng information từ JSON
		JSONArray informationArray = (JSONArray) jsonObject.get("information");

		// Kiểm tra nếu informationArray là null hoặc rỗng
		if (informationArray == null || informationArray.isEmpty()) {
			System.out.println("Mảng 'information' trong file JSON không tồn tại hoặc rỗng.");
			return; // Dừng phương thức nếu mảng không có dữ liệu
		}

		// Lấy phần tử đầu tiên từ mảng information
		JSONObject information = (JSONObject) informationArray.get(0);

		// Lấy dữ liệu từ JSON
		String staffId = (String) information.get("staff_id");
		String fullName = (String) information.get("full_name");

		// Tìm các ô input trên trang web và điền dữ liệu
		WebElement staffIdInput = driver.findElement(By.id("staff_id"));
		WebElement fullNameInput = driver.findElement(By.id("full_name"));

		// Lấy giá trị cũ của các ô input trước khi thay đổi
		String oldStaffId = staffIdInput.getAttribute("value");
		String oldFullName = fullNameInput.getAttribute("value");

		// Điền dữ liệu mới vào các ô input
		staffIdInput.clear();
		staffIdInput.sendKeys(staffId); // Điền mã giảng viên mới

		fullNameInput.clear();
		fullNameInput.sendKeys(fullName); // Điền tên giảng viên mới

		// Xuất thông báo thay đổi
		System.out.println("Đã thay đổi \"" + oldStaffId + "\" \"" + oldFullName + "\" sang \"" + staffId + "\" \""
				+ fullName + "\"");

		// Kiểm tra rằng dữ liệu đã được thay đổi chính xác
		Assert.assertEquals(staffIdInput.getAttribute("value"), staffId);
		Assert.assertEquals(fullNameInput.getAttribute("value"), fullName);
	}
	
	@Test(priority = 5)
	public void homePage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[1]/a/span")).click();
		Thread.sleep(1000);
		System.out.println("Đã về trang chủ");
	}

	@AfterTest
	public void close() {
		driver.quit();
	}
}