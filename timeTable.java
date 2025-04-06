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
	                if (subject.equals(expectedSubject1) && lhpCode.equals(expectedLhpCode1) &&
	                    weekRange.equals(expectedWeekRange1) && room.equals(expectedRoom1) && lesson.equals(expectedLesson1)) {
	                    System.out.println("Kết quả hợp lệ");
	                    isSubjectMatch = true;
	                }

	                if (subject.equals(expectedSubject2) && lhpCode.equals(expectedLhpCode2) &&
	                    weekRange.equals(expectedWeekRange2) && room.equals(expectedRoom2) && lesson.equals(expectedLesson2)) {
	                    System.out.println("Kết quả hợp lệ");
	                    isSubjectMatch = true;
	                }

	                if (subject.equals(expectedSubject3) && lhpCode.equals(expectedLhpCode3) &&
	                    weekRange.equals(expectedWeekRange3) && room.equals(expectedRoom3) && lesson.equals(expectedLesson3)) {
	                    System.out.println("Kết quả hợp lệ");
	                    isSubjectMatch = true;
	                }

	                if (subject.equals(expectedSubject4) && lhpCode.equals(expectedLhpCode4) &&
	                    weekRange.equals(expectedWeekRange4) && room.equals(expectedRoom4) && lesson.equals(expectedLesson4)) {
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
	
	@Test(priority = 5)
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