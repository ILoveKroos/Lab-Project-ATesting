import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class timeTable {
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
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Xem TKB")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void input() throws InterruptedException {
		// DropList Học kỳ
		WebElement Term = driver.findElement(By.xpath("//*[@id=\"select2-term-container\"]"));
		// Mở DropList
		Term.click();
		// Tìm thanh Input
		WebElement inputTerm = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div"
				+ "/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		// Clear data
		inputTerm.clear();
		// Nhập dữ liệu "Học kỳ"
		inputTerm.sendKeys("666" + Keys.RETURN);
		Thread.sleep(1000);

		// DropList Tuần
		WebElement Week = driver.findElement(By.xpath("//*[@id=\"select2-week-container\"]"));
		// Mở DropList
		Week.click();
		// Tìm thanh Input
		WebElement inputWeek = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div"
				+ "/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		// Clear data
		inputWeek.clear();
		// Nhập dữ liệu "Tuần"
		inputWeek.sendKeys("Tuần 7" + Keys.RETURN);
		Thread.sleep(1000);

		// DropList GV
		WebElement GV = driver.findElement(By.xpath("//*[@id=\"select2-lecturer-container\"]"));
		// Mở DropList
		GV.click();
		// Tìm thanh Input
		WebElement inputGV = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div"
				+ "/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		// Clear data
		inputGV.clear();
		// Nhập dữ liệu "Tuần"
		inputGV.sendKeys("Trần Gia Hào" + Keys.RETURN);
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void data() {
		// Tìm vị trí tuần
		WebElement alertMessage = driver.findElement(By.cssSelector("div.alert-body"));

		// In ra màn hình
		String message = alertMessage.getText();
		System.out.println(message);
		
		WebElement table = driver.findElement(By.cssSelector("table.personal-timetable"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Lấy danh sách tiêu đề cột (Thứ 2, Thứ 3, ...)
		List<WebElement> headers = table.findElements(By.cssSelector("thead th"));

		// Lặp qua từng hàng
		for (int i = 1; i < rows.size(); i++) { // Bỏ qua hàng tiêu đề
			List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
			String period = columns.get(0).getText(); // Lấy Tiết học (vd: 1-3)

			// Lặp qua từng cột (bỏ cột đầu tiên vì đó là tiết học)
			for (int j = 1; j < columns.size(); j++) {
				WebElement cell = columns.get(j);
				if (!cell.getText().trim().isEmpty()) { // Chỉ lấy cột có dữ liệu
					String day = headers.get(j).getText(); // Lấy tiêu đề thứ trong tuần
					WebElement classInfo = cell.findElement(By.tagName("div"));

					// Lấy nội dung môn học
					String subject = classInfo.findElement(By.tagName("b")).getText();
					String lhpCode = classInfo.getText().split("Mã LHP:")[1].split("\n")[0].trim();
					String weekRange = classInfo.getText().split("Tuần BĐ/KT:")[1].split("\n")[0].trim();
					String room = classInfo.getText().split("Phòng:")[1].split("\n")[0].trim();
					String lesson = classInfo.getText().split("Tiết:")[1].trim();

					// In ra kết quả theo format mong muốn
					System.out.println(day + ": MH: " + subject + " - Mã LHP: " + lhpCode + " - Tuần BĐ/KT: "
							+ weekRange + " - Phòng: " + room + " - Tiết: " + lesson);
				}
			}
		}
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}
