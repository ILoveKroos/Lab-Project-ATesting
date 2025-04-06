import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
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
	@Test(priority = 4)
	public void checkTerm() {
		// Kiểm tra ở Tab học kì
		System.out.println("Kiểm tra mục Học kì");
	    // Tìm tất cả các hàng trong tbody
	    List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

	    // Dữ liệu mong đợi
	    String expectedMaHp1 = "71ITIS30203";
	    String expectedTenHp1 = "Hệ Quản trị Cơ sở dữ liệu";
	    String expectedNganh1 = "SWTech";
	    String expectedSoTc1 = "3";
	    String expectedSoLop1 = "1LT + 1TH";
	    String expectedSoGioGiang1 = "60";
	    String expectedSoGioQuyDoi1 = "348";

	    String expectedMaHp2 = "71ITSE30203";
	    String expectedTenHp2 = "Lập trình hướng đối tượng";
	    String expectedNganh2 = "SWTech";
	    String expectedSoTc2 = "3";
	    String expectedSoLop2 = "1TH";
	    String expectedSoGioGiang2 = "30";
	    String expectedSoGioQuyDoi2 = "203";

	    String expectedMaHp3 = "71ITSE30303";
	    String expectedTenHp3 = "Cấu trúc dữ liệu và giải thuật";
	    String expectedNganh3 = "SWTech";
	    String expectedSoTc3 = "3";
	    String expectedSoLop3 = "1LT";
	    String expectedSoGioGiang3 = "30";
	    String expectedSoGioQuyDoi3 = "186";

	    // Duyệt qua từng hàng để lấy dữ liệu
	    for (WebElement row : rows) {
	        List<WebElement> columns = row.findElements(By.tagName("td"));

	        // Lấy dữ liệu từ các cột trong mỗi hàng
	        String ma_hp = columns.get(1).getText();
	        String ten_hp = columns.get(2).getText();
	        String nganh = columns.get(3).getText();
	        String so_tc = columns.get(4).getText();
	        String so_lop = columns.get(5).getText();
	        String so_gio_giang = columns.get(6).getText();
	        String so_gio_quy_doi = columns.get(7).getText();

	        // In ra kết quả theo format mong muốn
	        System.out.println("Mã HP: " + ma_hp + " - Tên HP: " + ten_hp + " - Ngành: " + nganh + " - Số TC: " + so_tc
	                + " - Số lớp: " + so_lop + " - Số giờ giảng: " + so_gio_giang + " - Số giờ quy đổi: "
	                + so_gio_quy_doi);

	        // So sánh với kết quả mong đợi
	        boolean isMaHpMatch = false;
	        boolean isTenHpMatch = false;
	        boolean isNganhMatch = false;
	        boolean isSoTcMatch = false;
	        boolean isSoLopMatch = false;
	        boolean isSoGioGiangMatch = false;
	        boolean isSoGioQuyDoiMatch = false;

	        if (ma_hp.equals(expectedMaHp1) && ten_hp.equals(expectedTenHp1) && nganh.equals(expectedNganh1) &&
	            so_tc.equals(expectedSoTc1) && so_lop.equals(expectedSoLop1) && so_gio_giang.equals(expectedSoGioGiang1) &&
	            so_gio_quy_doi.equals(expectedSoGioQuyDoi1)) {
	            System.out.println("Kết quả hợp lệ");
	            isMaHpMatch = true;
	            isTenHpMatch = true;
	            isNganhMatch = true;
	            isSoTcMatch = true;
	            isSoLopMatch = true;
	            isSoGioGiangMatch = true;
	            isSoGioQuyDoiMatch = true;
	        }

	        if (ma_hp.equals(expectedMaHp2) && ten_hp.equals(expectedTenHp2) && nganh.equals(expectedNganh2) &&
	            so_tc.equals(expectedSoTc2) && so_lop.equals(expectedSoLop2) && so_gio_giang.equals(expectedSoGioGiang2) &&
	            so_gio_quy_doi.equals(expectedSoGioQuyDoi2)) {
	            System.out.println("Kết quả hợp lệ");
	            isMaHpMatch = true;
	            isTenHpMatch = true;
	            isNganhMatch = true;
	            isSoTcMatch = true;
	            isSoLopMatch = true;
	            isSoGioGiangMatch = true;
	            isSoGioQuyDoiMatch = true;
	        }

	        if (ma_hp.equals(expectedMaHp3) && ten_hp.equals(expectedTenHp3) && nganh.equals(expectedNganh3) &&
	            so_tc.equals(expectedSoTc3) && so_lop.equals(expectedSoLop3) && so_gio_giang.equals(expectedSoGioGiang3) &&
	            so_gio_quy_doi.equals(expectedSoGioQuyDoi3)) {
	            System.out.println("Kết quả hợp lệ");
	            isMaHpMatch = true;
	            isTenHpMatch = true;
	            isNganhMatch = true;
	            isSoTcMatch = true;
	            isSoLopMatch = true;
	            isSoGioGiangMatch = true;
	            isSoGioQuyDoiMatch = true;
	        }

	        // Nếu không có môn học nào khớp với kỳ vọng
	        if (!isMaHpMatch || !isTenHpMatch || !isNganhMatch || !isSoTcMatch || !isSoLopMatch || !isSoGioGiangMatch || !isSoGioQuyDoiMatch) {
	            System.out.println("Kết quả không hợp lệ");
	        }
	    }
	}

	@Test(priority = 5)
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

	@Test(priority = 6)
	public void checkYear() {
		// Kiểm tra ở Tab học kì
		System.out.println("Kiểm tra mục Năm học");
	    // Tìm tất cả các hàng trong tbody
	    List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

	    // Dữ liệu mong đợi
	    String expectedMaHp1 = "71ITIS30203";
	    String expectedTenHp1 = "Hệ Quản trị Cơ sở dữ liệu";
	    String expectedNganh1 = "SWTech";
	    String expectedSoTc1 = "3";
	    String expectedSoLop1 = "1LT + 1TH";
	    String expectedSoGioGiang1 = "60";
	    String expectedSoGioQuyDoi1 = "348";

	    String expectedMaHp2 = "71ITSE30203";
	    String expectedTenHp2 = "Lập trình hướng đối tượng";
	    String expectedNganh2 = "SWTech";
	    String expectedSoTc2 = "3";
	    String expectedSoLop2 = "1TH";
	    String expectedSoGioGiang2 = "30";
	    String expectedSoGioQuyDoi2 = "203";

	    String expectedMaHp3 = "71ITSE30303";
	    String expectedTenHp3 = "Cấu trúc dữ liệu và giải thuật";
	    String expectedNganh3 = "SWTech";
	    String expectedSoTc3 = "3";
	    String expectedSoLop3 = "1LT";
	    String expectedSoGioGiang3 = "30";
	    String expectedSoGioQuyDoi3 = "186";

	    // Duyệt qua từng hàng để lấy dữ liệu
	    for (WebElement row : rows) {
	        List<WebElement> columns = row.findElements(By.tagName("td"));

	        // Lấy dữ liệu từ các cột trong mỗi hàng
	        String ma_hp = columns.get(1).getText();
	        String ten_hp = columns.get(2).getText();
	        String nganh = columns.get(3).getText();
	        String so_tc = columns.get(4).getText();
	        String so_lop = columns.get(5).getText();
	        String so_gio_giang = columns.get(6).getText();
	        String so_gio_quy_doi = columns.get(7).getText();

	        // In ra kết quả theo format mong muốn
	        System.out.println("Mã HP: " + ma_hp + " - Tên HP: " + ten_hp + " - Ngành: " + nganh + " - Số TC: " + so_tc
	                + " - Số lớp: " + so_lop + " - Số giờ giảng: " + so_gio_giang + " - Số giờ quy đổi: "
	                + so_gio_quy_doi);

	        // So sánh với kết quả mong đợi
	        boolean isMaHpMatch = false;
	        boolean isTenHpMatch = false;
	        boolean isNganhMatch = false;
	        boolean isSoTcMatch = false;
	        boolean isSoLopMatch = false;
	        boolean isSoGioGiangMatch = false;
	        boolean isSoGioQuyDoiMatch = false;

	        if (ma_hp.equals(expectedMaHp1) && ten_hp.equals(expectedTenHp1) && nganh.equals(expectedNganh1) &&
	            so_tc.equals(expectedSoTc1) && so_lop.equals(expectedSoLop1) && so_gio_giang.equals(expectedSoGioGiang1) &&
	            so_gio_quy_doi.equals(expectedSoGioQuyDoi1)) {
	            System.out.println("Kết quả hợp lệ");
	            isMaHpMatch = true;
	            isTenHpMatch = true;
	            isNganhMatch = true;
	            isSoTcMatch = true;
	            isSoLopMatch = true;
	            isSoGioGiangMatch = true;
	            isSoGioQuyDoiMatch = true;
	        }

	        if (ma_hp.equals(expectedMaHp2) && ten_hp.equals(expectedTenHp2) && nganh.equals(expectedNganh2) &&
	            so_tc.equals(expectedSoTc2) && so_lop.equals(expectedSoLop2) && so_gio_giang.equals(expectedSoGioGiang2) &&
	            so_gio_quy_doi.equals(expectedSoGioQuyDoi2)) {
	            System.out.println("Kết quả hợp lệ");
	            isMaHpMatch = true;
	            isTenHpMatch = true;
	            isNganhMatch = true;
	            isSoTcMatch = true;
	            isSoLopMatch = true;
	            isSoGioGiangMatch = true;
	            isSoGioQuyDoiMatch = true;
	        }

	        if (ma_hp.equals(expectedMaHp3) && ten_hp.equals(expectedTenHp3) && nganh.equals(expectedNganh3) &&
	            so_tc.equals(expectedSoTc3) && so_lop.equals(expectedSoLop3) && so_gio_giang.equals(expectedSoGioGiang3) &&
	            so_gio_quy_doi.equals(expectedSoGioQuyDoi3)) {
	            System.out.println("Kết quả hợp lệ");
	            isMaHpMatch = true;
	            isTenHpMatch = true;
	            isNganhMatch = true;
	            isSoTcMatch = true;
	            isSoLopMatch = true;
	            isSoGioGiangMatch = true;
	            isSoGioQuyDoiMatch = true;
	        }

	        // Nếu không có môn học nào khớp với kỳ vọng
	        if (!isMaHpMatch || !isTenHpMatch || !isNganhMatch || !isSoTcMatch || !isSoLopMatch || !isSoGioGiangMatch || !isSoGioQuyDoiMatch) {
	            System.out.println("Kết quả không hợp lệ");
	        }
	    }
	}
	
	@Test(priority = 7)
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