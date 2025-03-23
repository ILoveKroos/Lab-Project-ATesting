import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ViewHours_TermYear {
	public String BaseURL = "https://cntttest.vanlanguni.edu.vn:18081/Phancong02/";
	String driverPath = "C:\\chromedriver.exe";
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get(BaseURL);
		driver.manage().window().maximize();
	}
	
	String[][] expectedData = {
	        {"2274802010221", "Trần Gia Hào", "Cơ hữu", "3", "4", "120"},
	        {"2274802010002", "-", "Cơ hữu", "3", "4", "120"},
	        {"3231332", "QuocTrieu", "Cơ hữu", "2", "3", "90"}
	    };

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
		driver.findElement(By.linkText("Số giờ giảng viên")).click();
	}

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
		Thread.sleep(1000);

		// Tìm thanh Input thuộc tính Ngành
		WebElement Major1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span/span[1]"));
		Major1.click();
		// Input
		WebElement Major1_1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input"));
		// Clear data
		Major1_1.clear();
		// Ngành SWTECH
		Major1_1.sendKeys("SWTECH" + Keys.RETURN);
		Thread.sleep(1000);

		// Tìm thanh Input thuộc tính Giảng viên
		WebElement Tutor1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[5]/div/span[1]/span[1]/span/span[1]"));
		Tutor1.click();
		// Input
		WebElement Tutor1_1 = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[3]/div/section"
				+ "/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input"));
		// Clear data
		Tutor1_1.clear();
		// Tất cả
		Tutor1_1.sendKeys("Tất cả" + Keys.RETURN);
		Thread.sleep(5000);
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
		Thread.sleep(5000);
	}

	@Test(priority = 4)
	public void selectBangBieu() throws InterruptedException {
		WebElement bangBieuButton = driver.findElement(By.xpath("//*[@id=\"table-tab\"]"));
		bangBieuButton.click();
		Thread.sleep(2000);

	}

	@Test(priority = 5)
	public void displayTable() {
		// Tìm tất cả các hàng trong tbody
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tblStatistics']/tbody/tr"));

        // Duyệt từng hàng và kiểm tra
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            String ma_gv = columns.get(2).getText();
            String ten_gv = columns.get(3).getText();
            String loai_gv = columns.get(4).getText();
            String so_hp = columns.get(5).getText();
            String so_lop = columns.get(6).getText();
            String so_gio_giang = columns.get(7).getText();

            // In kết quả
            System.out.println("Mã GV: " + ma_gv + " - Tên GV: " + ten_gv +
                    " - Loại GV: " + loai_gv + " - Số HP: " + so_hp +
                    " - Số lớp: " + so_lop + " - Số giờ giảng: " + so_gio_giang);

            // So sánh giá trị
            Assert.assertEquals(ma_gv, expectedData[i][0], "Mã GV không khớp");
            Assert.assertEquals(ten_gv, expectedData[i][1], "Tên GV không khớp");
            Assert.assertEquals(loai_gv, expectedData[i][2], "Loại GV không khớp");
            Assert.assertEquals(so_hp, expectedData[i][3], "Số HP không khớp");
            Assert.assertEquals(so_lop, expectedData[i][4], "Số lớp không khớp");
            Assert.assertEquals(so_gio_giang, expectedData[i][5], "Số giờ giảng không khớp");
        }
    }

	@AfterTest
	public void close() {
		driver.quit();
	}
}
