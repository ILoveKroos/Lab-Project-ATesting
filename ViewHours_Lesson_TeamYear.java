import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
// import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewHours_Lesson_TeamYear {
	public String BaseURL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
	}

	@Test(priority = 0) //
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
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Số giờ cá nhân")).click();
	}

	// select2-unit-container
	// select2-year-container

	@Test(priority = 3)
	public void testDropListHocky() throws InterruptedException {
		// Tìm DropList Học kỳ (Gồm học kỳ và Năm học)
		WebElement Term1 = driver.findElement(By.id("select2-unit-container"));
		// Mở DropList
		Term1.click();
		// Tìm thanh Input
		WebElement Term1_1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		// Clear data
		Term1_1.clear();
		// Nhập dữ liệu "Học kỳ"
		Term1_1.sendKeys("Học kỳ" + Keys.RETURN);
		Thread.sleep(1000);

		// Tìm DropList Học kỳ (DropList 2)
		WebElement Term2 = driver.findElement(By.xpath("//*[@id=\"select2-term-container\"]"));
		// Mở DropList Học kỳ (DropList 2)
		Term2.click();
		Thread.sleep(1000);
		// Tìm thanh Input
		WebElement Term2_1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input"));
		// Clear data
		Term2_1.clear();
		// Chọn học kỳ 666
		Term2_1.sendKeys("666" + Keys.RETURN);
		Thread.sleep(4000);

		// Xem theo ca giảng (CheckBox)
		WebElement ChB_CaGiang = driver.findElement(By.xpath("//*[@id=\"isLesson\"]"));
		ChB_CaGiang.click();
		Thread.sleep(4000);

		// Chọn bảng (Bảng biểu)
		WebElement Table = driver.findElement(By.xpath("//*[@id=\"table-tab\"]"));
		Table.click();

		Thread.sleep(4000);

	}

	@Test(priority = 3)
	public void testDropListNamhoc() throws InterruptedException {
		// Tìm DropList Học kỳ (Gồm học kỳ và Năm học)
		WebElement Year1 = driver.findElement(By.id("select2-unit-container"));
		// Mở DropList
		Year1.click();
		// Tìm thanh Input
		WebElement Year1_1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input"));
		// Clear data
		Year1_1.clear();
		// Nhập dữ liệu "Năm học"
		Year1_1.sendKeys("Năm học" + Keys.RETURN);
		Thread.sleep(1000);

		// Tìm DropList Năm học (DropList 2)
		WebElement Year2 = driver.findElement(By.xpath("//*[@id=\"select2-year-container\"]"));
		// Mở DropList Năm học (DropList 2)
		Year2.click();
		Thread.sleep(1000);
		// Tìm thanh Input
		WebElement Year2_1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input"));
		// Clear data
		Year2_1.clear();
		// Chọn năm học 2024 - 2025
		Year2_1.sendKeys("2024 - 2025" + Keys.RETURN);
		Thread.sleep(4000);

		// Xem theo ca giảng (CheckBox)
		WebElement ChB_CaGiang = driver.findElement(By.xpath("//*[@id=\"isLesson\"]"));
		ChB_CaGiang.click();
		Thread.sleep(4000);

		// Chọn bảng (Bảng biểu)
		WebElement Table = driver.findElement(By.xpath("//*[@id=\"table-tab\"]"));
		Table.click();
	}

//	@AfterTest
//	public void teardown() {
//		driver.quit();
//	}
}