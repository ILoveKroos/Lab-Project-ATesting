package Function;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class ViewHrs extends Action {

    public ViewHrs(WebDriver driver) {
        super(driver);
    }

    // Các phần tử trong menu
    private By tabButton = By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a/span");
    private By hoursMenuItem = By.linkText("Số giờ giảng viên");

    // Các phần tử trong dropdown Học kỳ
    private By termDropdown = By.id("select2-unit-container");
    private By termInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input");
    private By term2Dropdown = By.xpath("//*[@id=\"select2-term-container\"]");
    private By term2Input = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input");
    private By majorDropdown = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[1]/span[1]/span/span[1]");
    private By majorInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[4]/div/span[2]/span/span[1]/input");
    private By tutorDropdown = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[1]/span[1]/span/span[1]");
    private By tutorInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[5]/div/span[2]/span/span[1]/input");

    // Mở Tab và chọn "Số giờ giảng viên"
    public void openTab() throws InterruptedException {
        clickElement(tabButton);
        Thread.sleep(1000);
    }

    public void selectHoursMenu() {
        clickElement(hoursMenuItem); // Chọn "Số giờ giảng viên"
    }

    // Mở dropdown Học kỳ và chọn giá trị
    public void selectTerm(String termValue) throws InterruptedException {
        clickElement(termDropdown); // Mở dropdown Học kỳ
        WebElement termInputField = driver.findElement(termInput);
        termInputField.clear();
        termInputField.sendKeys(termValue + Keys.RETURN);
        Thread.sleep(1000);
    }

    // Mở dropdown Học kỳ 2 và chọn giá trị
    public void selectTerm2(String term2Value) throws InterruptedException {
        clickElement(term2Dropdown); // Mở dropdown Học kỳ 2
        WebElement term2InputField = driver.findElement(term2Input);
        term2InputField.clear();
        term2InputField.sendKeys(term2Value + Keys.RETURN);
        Thread.sleep(1000);
    }

    // Mở dropdown Ngành và chọn giá trị
    public void selectMajor(String majorValue) throws InterruptedException {
        clickElement(majorDropdown); // Mở dropdown Ngành
        WebElement majorInputField = driver.findElement(majorInput);
        majorInputField.clear();
        majorInputField.sendKeys(majorValue + Keys.RETURN);
        Thread.sleep(1000);
    }

    // Mở dropdown Giảng viên và chọn giá trị
    public void selectTutor(String tutorValue) throws InterruptedException {
        clickElement(tutorDropdown); // Mở dropdown Giảng viên
        WebElement tutorInputField = driver.findElement(tutorInput);
        tutorInputField.clear();
        tutorInputField.sendKeys(tutorValue + Keys.RETURN);
        Thread.sleep(1000);
    }

    // Mở bảng biểu
    public void selectBangBieu() throws InterruptedException {
        WebElement bangBieuButton = driver.findElement(By.xpath("//*[@id=\"table-tab\"]"));
        bangBieuButton.click();
        Thread.sleep(2000);
    }

    // Kiểm tra bảng dữ liệu
    public void displayTable() {
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tblStatistics']/tbody/tr"));
        String[][] expectedData = { 
            { "2274802010221", "Trần Gia Hào", "Cơ hữu", "3", "4", "120" },
            { "2274802010002", "-", "Cơ hữu", "3", "4", "120" }, 
            { "0110", "Dương Minh An", "Cơ hữu", "1", "4", "120" },
            { "", "", "Cơ hữu", "2", "3", "90"}
        };

        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            String ma_gv = columns.get(2).getText();
            String ten_gv = columns.get(3).getText();
            String loai_gv = columns.get(4).getText();
            String so_hp = columns.get(5).getText();
            String so_lop = columns.get(6).getText();
            String so_gio_giang = columns.get(7).getText();

            // Hiển thị kết quả thực tế
            System.out.println("Kết quả thực tế:");
            System.out.println("Mã GV: " + ma_gv + " - Tên GV: " + ten_gv + " - Loại GV: " + loai_gv + " - Số HP: "
                    + so_hp + " - Số lớp: " + so_lop + " - Số giờ giảng: " + so_gio_giang);

            // Hiển thị dữ liệu mong đợi
            System.out.println("Dữ liệu mong đợi:");
            String expectedMaGp = expectedData[i][0];
            String expectedTenGp = expectedData[i][1];
            String expectedLoaiGp = expectedData[i][2];
            String expectedSoHp = expectedData[i][3];
            String expectedSoLop = expectedData[i][4];
            String expectedSoGioGiang = expectedData[i][5];

            System.out.println("Mã GV mong đợi: " + expectedMaGp + " - Tên GV mong đợi: " + expectedTenGp + " - Loại GV mong đợi: " + expectedLoaiGp + " - Số HP mong đợi: " + expectedSoHp + " - Số lớp mong đợi: " + expectedSoLop + " - Số giờ giảng mong đợi: " + expectedSoGioGiang);
            
            // Kiểm tra
            boolean isMatch = true;

            if (!ma_gv.equals(expectedMaGp)) {
                System.out.println("Lỗi: Mã GV không khớp");
                isMatch = false;
            }
            if (!ten_gv.equals(expectedTenGp)) {
                System.out.println("Lỗi: Tên GV không khớp");
                isMatch = false;
            }
            if (!loai_gv.equals(expectedLoaiGp)) {
                System.out.println("Lỗi: Loại GV không khớp");
                isMatch = false;
            }
            if (!so_hp.equals(expectedSoHp)) {
                System.out.println("Lỗi: Số HP không khớp");
                isMatch = false;
            }
            if (!so_lop.equals(expectedSoLop)) {
                System.out.println("Lỗi: Số lớp không khớp");
                isMatch = false;
            }
            if (!so_gio_giang.equals(expectedSoGioGiang)) {
                System.out.println("Lỗi: Số giờ giảng không khớp");
                isMatch = false;
            }

            // Nếu kết quả thực tế khớp với dữ liệu mong đợi
            if (isMatch) {
                System.out.println("Kết quả hợp lệ\n");
            } else {
                System.out.println("Kết quả không hợp lệ\n");
            }
            System.out.println("-------x-------");
        }
    }
}
