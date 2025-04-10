package Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;

public class TimeTable extends Action {

	public TimeTable(WebDriver driver) {
		super(driver);
	}

	// Khai báo các thuộc tính cần sử dụng
	private By termDropdown = By.xpath("//*[@id=\"select2-term-container\"]");
	private By weekDropdown = By.xpath("//*[@id=\"select2-week-container\"]");
	private By lecturerDropdown = By.xpath("//*[@id=\"select2-lecturer-container\"]");
	private By termInput = By.xpath(
			"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input");
	private By weekInput = By.xpath(
			"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input");
	private By lecturerInput = By.xpath(
			"/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[3]/div/span[2]/span/span[1]/input");
	private By timetableTable = By.cssSelector("table.personal-timetable");

	// Mở trang "Xem TKB"
	public void openTimeTable() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"main-menu-navigation\"]/li[4]/a/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Xem TKB")).click();
		Thread.sleep(3000);
	}

	// Nhập vào các dropdown (Học kỳ, Tuần, Giảng viên)
	public void inputDropdownValues(String Term, String Week, String Name) throws InterruptedException {
		// Học kỳ
		WebElement term = driver.findElement(termDropdown);
		term.click();
		WebElement inputTerm = driver.findElement(termInput);
		inputTerm.clear();
		inputTerm.sendKeys(Term + Keys.RETURN);
		Thread.sleep(1000);

		// Tuần
		WebElement week = driver.findElement(weekDropdown);
		week.click();
		WebElement inputWeek = driver.findElement(weekInput);
		inputWeek.clear();
		inputWeek.sendKeys(Week + Keys.RETURN);
		Thread.sleep(1000);

		// Giảng viên
		WebElement lecturer = driver.findElement(lecturerDropdown);
		lecturer.click();
		WebElement inputLecturer = driver.findElement(lecturerInput);
		inputLecturer.clear();
		inputLecturer.sendKeys(Name + Keys.RETURN);
		Thread.sleep(3000);
		
		// Lỗi File Json
		try {
	        // Tìm phần tử thông báo lỗi
	        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='personalTimetableDiv']/h4"));
	        
	        // Lấy và in ra thông báo lỗi nếu tìm thấy
	        String errorText = errorMessage.getText();
	        System.out.println("Thông báo lỗi: " + errorText);
	    } catch (NoSuchElementException e) {
	        // Nếu không tìm thấy phần tử, in thông báo và tiếp tục
	        System.out.println("Không tìm thấy thông báo lỗi");
	    }
	}

	// Kiểm tra và in ra bảng dữ liệu
	public void displayTimeTableData() throws InterruptedException {
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
	    
	    // Lập bảng dữ liệu và so sánh
	    WebElement table = driver.findElement(timetableTable);
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    List<WebElement> headers = table.findElements(By.cssSelector("thead th"));

	    for (int i = 1; i < rows.size(); i++) { // Bỏ qua hàng tiêu đề
	        List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

	        for (int j = 1; j < columns.size(); j++) {
	            WebElement cell = columns.get(j);
	            if (!cell.getText().trim().isEmpty()) {
	                String day = headers.get(j).getText();
	                WebElement classInfo = cell.findElement(By.tagName("div"));

	                String subject = classInfo.findElement(By.tagName("b")).getText();
	                String lhpCode = classInfo.getText().split("Mã LHP:")[1].split("\n")[0].trim();
	                String weekRange = classInfo.getText().split("Tuần BĐ/KT:")[1].split("\n")[0].trim();
	                String room = classInfo.getText().split("Phòng:")[1].split("\n")[0].trim();
	                String lesson = classInfo.getText().split("Tiết:")[1].trim();
	                
	                

	                // Hiển thị kết quả thực tế
	                System.out.println("Kết quả thực tế:");
	                System.out.println(day + ": MH: " + subject + " - Mã LHP: " + lhpCode + " - Tuần BĐ/KT: "
	                        + weekRange + " - Phòng: " + room + " - Tiết: " + lesson);

	                // Hiển thị dữ liệu mong đợi
	                System.out.println("Dữ liệu mong đợi:");
	                String expectedSubject = expectedSubject1;
	                String expectedLhpCode = expectedLhpCode1;
	                String expectedWeekRange = expectedWeekRange1;
	                String expectedRoom = expectedRoom1;
	                String expectedLesson = expectedLesson1;
	                
	                if (subject.equals(expectedSubject2)) {
	                    expectedSubject = expectedSubject2;
	                    expectedLhpCode = expectedLhpCode2;
	                    expectedWeekRange = expectedWeekRange2;
	                    expectedRoom = expectedRoom2;
	                    expectedLesson = expectedLesson2;
	                } else if (subject.equals(expectedSubject3)) {
	                    expectedSubject = expectedSubject3;
	                    expectedLhpCode = expectedLhpCode3;
	                    expectedWeekRange = expectedWeekRange3;
	                    expectedRoom = expectedRoom3;
	                    expectedLesson = expectedLesson3;
	                } else if (subject.equals(expectedSubject4)) {
	                    expectedSubject = expectedSubject4;
	                    expectedLhpCode = expectedLhpCode4;
	                    expectedWeekRange = expectedWeekRange4;
	                    expectedRoom = expectedRoom4;
	                    expectedLesson = expectedLesson4;
	                }

	                System.out.println("MH mong đợi: " + expectedSubject + " - Mã LHP mong đợi: " + expectedLhpCode
	                        + " - Tuần BĐ/KT mong đợi: " + expectedWeekRange + " - Phòng mong đợi: " + expectedRoom
	                        + " - Tiết mong đợi: " + expectedLesson);

	                // So sánh dữ liệu thực tế với dữ liệu mong đợi
	                boolean isSubjectMatch = false;
	                if (subject.equals(expectedSubject) && lhpCode.equals(expectedLhpCode)
	                        && weekRange.equals(expectedWeekRange) && room.equals(expectedRoom)
	                        && lesson.equals(expectedLesson)) {
	                    System.out.println("Kết quả hợp lệ\n");
	                    isSubjectMatch = true;
	                }

	                // Nếu môn học không khớp với bất kỳ kỳ vọng nào
	                if (!isSubjectMatch) {
	                    System.out.println("Kết quả không hợp lệ\n");
	                }

	                System.out.println("-------x-------");
	                }
	            }
	        }
	    }
	}
