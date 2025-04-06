import java.io.FileReader;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Final {
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

		// Dữ liệu mong đợi cho từng dòng
		String[][] expectedData = { { "2274802010221", "Trần Gia Hào", "Cơ hữu", "3", "4", "120" },
				{ "2274802010002", "-", "Cơ hữu", "3", "4", "120" }, { "", "", "Cơ hữu", "2", "3", "90" } };

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
			System.out.println("Mã GV: " + ma_gv + " - Tên GV: " + ten_gv + " - Loại GV: " + loai_gv + " - Số HP: "
					+ so_hp + " - Số lớp: " + so_lop + " - Số giờ giảng: " + so_gio_giang);

			// So sánh giá trị với kết quả mong đợi
			boolean isMatch = true;

			if (!ma_gv.equals(expectedData[i][0])) {
				System.out.println(
						"Lỗi kết quả: Mã GV không khớp. Expected: " + expectedData[i][0] + ", Actual: " + ma_gv);
				isMatch = false;
			}

			if (!ten_gv.equals(expectedData[i][1])) {
				System.out.println(
						"Lỗi kết quả: Tên GV không khớp. Expected: " + expectedData[i][1] + ", Actual: " + ten_gv);
				isMatch = false;
			}

			if (!loai_gv.equals(expectedData[i][2])) {
				System.out.println(
						"Lỗi kết quả: Loại GV không khớp. Expected: " + expectedData[i][2] + ", Actual: " + loai_gv);
				isMatch = false;
			}

			if (!so_hp.equals(expectedData[i][3])) {
				System.out.println(
						"Lỗi kết quả: Số HP không khớp. Expected: " + expectedData[i][3] + ", Actual: " + so_hp);
				isMatch = false;
			}

			if (!so_lop.equals(expectedData[i][4])) {
				System.out.println(
						"Lỗi kết quả: Số lớp không khớp. Expected: " + expectedData[i][4] + ", Actual: " + so_lop);
				isMatch = false;
			}

			if (!so_gio_giang.equals(expectedData[i][5])) {
				System.out.println("Lỗi kết quả: Số giờ giảng không khớp. Expected: " + expectedData[i][5]
						+ ", Actual: " + so_gio_giang);
				isMatch = false;
			}

			if (isMatch) {
				System.out.println("Kết quả đúng: " + ma_gv + " - " + ten_gv);
			}
		}
	}

	@Test(priority = 6)
	public void homePageHrsByLesson() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[1]/a/span")).click();
		Thread.sleep(1000);
		System.out.println("Đã về trang chủ");
	}

	@Test(priority = 7)
	public void MenubarHrsByLesson() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Số giờ cá nhân")).click();
	}

	@Test(priority = 8)
	public void testDropListHockyHrsByLesson() throws InterruptedException {
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

	@Test(priority = 9)
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

			if (ma_hp.equals(expectedMaHp1) && ten_hp.equals(expectedTenHp1) && nganh.equals(expectedNganh1)
					&& so_tc.equals(expectedSoTc1) && so_lop.equals(expectedSoLop1)
					&& so_gio_giang.equals(expectedSoGioGiang1) && so_gio_quy_doi.equals(expectedSoGioQuyDoi1)) {
				System.out.println("Kết quả hợp lệ");
				isMaHpMatch = true;
				isTenHpMatch = true;
				isNganhMatch = true;
				isSoTcMatch = true;
				isSoLopMatch = true;
				isSoGioGiangMatch = true;
				isSoGioQuyDoiMatch = true;
			}

			if (ma_hp.equals(expectedMaHp2) && ten_hp.equals(expectedTenHp2) && nganh.equals(expectedNganh2)
					&& so_tc.equals(expectedSoTc2) && so_lop.equals(expectedSoLop2)
					&& so_gio_giang.equals(expectedSoGioGiang2) && so_gio_quy_doi.equals(expectedSoGioQuyDoi2)) {
				System.out.println("Kết quả hợp lệ");
				isMaHpMatch = true;
				isTenHpMatch = true;
				isNganhMatch = true;
				isSoTcMatch = true;
				isSoLopMatch = true;
				isSoGioGiangMatch = true;
				isSoGioQuyDoiMatch = true;
			}

			if (ma_hp.equals(expectedMaHp3) && ten_hp.equals(expectedTenHp3) && nganh.equals(expectedNganh3)
					&& so_tc.equals(expectedSoTc3) && so_lop.equals(expectedSoLop3)
					&& so_gio_giang.equals(expectedSoGioGiang3) && so_gio_quy_doi.equals(expectedSoGioQuyDoi3)) {
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
			if (!isMaHpMatch || !isTenHpMatch || !isNganhMatch || !isSoTcMatch || !isSoLopMatch || !isSoGioGiangMatch
					|| !isSoGioQuyDoiMatch) {
				System.out.println("Kết quả không hợp lệ");
			}
		}
	}

	@Test(priority = 10)
	public void testDropListNamhocHrsByLesson() throws InterruptedException {
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

	@Test(priority = 11)
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

			if (ma_hp.equals(expectedMaHp1) && ten_hp.equals(expectedTenHp1) && nganh.equals(expectedNganh1)
					&& so_tc.equals(expectedSoTc1) && so_lop.equals(expectedSoLop1)
					&& so_gio_giang.equals(expectedSoGioGiang1) && so_gio_quy_doi.equals(expectedSoGioQuyDoi1)) {
				System.out.println("Kết quả hợp lệ");
				isMaHpMatch = true;
				isTenHpMatch = true;
				isNganhMatch = true;
				isSoTcMatch = true;
				isSoLopMatch = true;
				isSoGioGiangMatch = true;
				isSoGioQuyDoiMatch = true;
			}

			if (ma_hp.equals(expectedMaHp2) && ten_hp.equals(expectedTenHp2) && nganh.equals(expectedNganh2)
					&& so_tc.equals(expectedSoTc2) && so_lop.equals(expectedSoLop2)
					&& so_gio_giang.equals(expectedSoGioGiang2) && so_gio_quy_doi.equals(expectedSoGioQuyDoi2)) {
				System.out.println("Kết quả hợp lệ");
				isMaHpMatch = true;
				isTenHpMatch = true;
				isNganhMatch = true;
				isSoTcMatch = true;
				isSoLopMatch = true;
				isSoGioGiangMatch = true;
				isSoGioQuyDoiMatch = true;
			}

			if (ma_hp.equals(expectedMaHp3) && ten_hp.equals(expectedTenHp3) && nganh.equals(expectedNganh3)
					&& so_tc.equals(expectedSoTc3) && so_lop.equals(expectedSoLop3)
					&& so_gio_giang.equals(expectedSoGioGiang3) && so_gio_quy_doi.equals(expectedSoGioQuyDoi3)) {
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
			if (!isMaHpMatch || !isTenHpMatch || !isNganhMatch || !isSoTcMatch || !isSoLopMatch || !isSoGioGiangMatch
					|| !isSoGioQuyDoiMatch) {
				System.out.println("Kết quả không hợp lệ");
			}
		}
	}

	@Test(priority = 12)
	public void homePageTimetable() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[1]/a/span")).click();
		Thread.sleep(1000);
		System.out.println("Đã về trang chủ");
	}

	@Test(priority = 13)
	public void MenubarTimeTable() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Xem TKB")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 14)
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

	@Test(priority = 15)
	public void data() {
		// Tìm vị trí tuần
		WebElement alertMessage = driver.findElement(By.cssSelector("div.alert-body"));

		// In ra màn hình
		String message = alertMessage.getText();
		System.out.println(message);

		// Giá trị mong đợi
		String expectedSubject1 = "Cấu trúc dữ liệu và giải thuật";
		String expectedLhpCode1 = "221_71ITSE30303_07";
		String expectedWeekRange1 = "1/10";
		String expectedRoom1 = "CS2.C.06.01";
		String expectedLesson1 = "1 - 3";

		String expectedSubject2 = "Hệ Quản trị Cơ sở dữ liệu";
		String expectedLhpCode2 = "221_71ITIS30203_01";
		String expectedWeekRange2 = "1/10";
		String expectedRoom2 = "CS2.C.07.01";
		String expectedLesson2 = "1 - 3";

		String expectedSubject3 = "Hệ Quản trị Cơ sở dữ liệu";
		String expectedLhpCode3 = "221_71ITIS30203_0102";
		String expectedWeekRange3 = "2/11";
		String expectedRoom3 = "CS3.F.12.02";
		String expectedLesson3 = "7 - 9";

		String expectedSubject4 = "Lập trình hướng đối tượng";
		String expectedLhpCode4 = "221_71ITSE30203_0103";
		String expectedWeekRange4 = "2/11";
		String expectedRoom4 = "CS3.F.12.04";
		String expectedLesson4 = "13 - 15";

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

					// So sánh với kết quả mong đợi
					boolean isSubjectMatch = false;
					if (subject.equals(expectedSubject1) && lhpCode.equals(expectedLhpCode1)
							&& weekRange.equals(expectedWeekRange1) && room.equals(expectedRoom1)
							&& lesson.equals(expectedLesson1)) {
						System.out.println("Kết quả hợp lệ");
						isSubjectMatch = true;
					}

					if (subject.equals(expectedSubject2) && lhpCode.equals(expectedLhpCode2)
							&& weekRange.equals(expectedWeekRange2) && room.equals(expectedRoom2)
							&& lesson.equals(expectedLesson2)) {
						System.out.println("Kết quả hợp lệ");
						isSubjectMatch = true;
					}

					if (subject.equals(expectedSubject3) && lhpCode.equals(expectedLhpCode3)
							&& weekRange.equals(expectedWeekRange3) && room.equals(expectedRoom3)
							&& lesson.equals(expectedLesson3)) {
						System.out.println("Kết quả hợp lệ");
						isSubjectMatch = true;
					}

					if (subject.equals(expectedSubject4) && lhpCode.equals(expectedLhpCode4)
							&& weekRange.equals(expectedWeekRange4) && room.equals(expectedRoom4)
							&& lesson.equals(expectedLesson4)) {
						System.out.println("Kết quả hợp lệ");
						isSubjectMatch = true;
					}

					// Nếu môn học không khớp với bất kỳ kỳ vọng nào
					if (!isSubjectMatch) {
						System.out.println("Kết quả không hợp lệ");
					}
				}
			}
		}
	}

	@Test(priority = 16)
	public void homePageInformation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[1]/a/span")).click();
		Thread.sleep(1000);
		System.out.println("Đã về trang chủ");
	}

	@Test(priority = 17)
	public void MenubarInformation() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"dropdown-user\"]/span/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/nav/div/ul/li[2]/div/a[1]")).click();
		Thread.sleep(1000);
	}

	@Test(priority = 18)
	public void information() throws Exception {
		// Đọc dữ liệu từ file JSON
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("D:\\information.json"));

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
		staffIdInput.sendKeys(staffId);

		fullNameInput.clear();
		fullNameInput.sendKeys(fullName);

		// Xuất thông báo thay đổi
		System.out.println("Đã thay đổi \"" + oldStaffId + "\" \"" + oldFullName + "\" sang \"" + staffId + "\" \""
				+ fullName + "\"");

		// Kiểm tra rằng dữ liệu đã được thay đổi chính xác
		Assert.assertEquals(staffIdInput.getAttribute("value"), staffId);
		Assert.assertEquals(fullNameInput.getAttribute("value"), fullName);
	}

	@Test(priority = 19)
	public void homePage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[1]/a/span")).click();
		Thread.sleep(1000);
		System.out.println("Đã về trang chủ");
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