package Function;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.io.FileReader;

public class ViewHrsLesson extends Action {

    public ViewHrsLesson(WebDriver driver) {
        super(driver);
    }

    // Khai báo các thuộc tính cần sử dụng
    private By hrsByLessonTab = By.xpath("/html/body/div[2]/div[1]/div[2]/ul/li[5]/a/span");
    private By hrsByLessonItem = By.linkText("Số giờ cá nhân");
    private By termDropdown = By.id("select2-unit-container");
    private By termInput = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[1]/div/span[2]/span/span[1]/input");
    private By term2Dropdown = By.xpath("//*[@id=\"select2-term-container\"]");
    private By term2Input = By.xpath("/html/body/div[2]/div[2]/div[3]/div/section/div/div/div/div[2]/div[1]/div[2]/div/span[2]/span/span[1]/input");   
    private By chbCaGiang = By.xpath("//*[@id=\"isLesson\"]");
    private By tableButton = By.xpath("//*[@id=\"table-tab\"]");

    // Mở tab "Số giờ cá nhân"
    public void openHrsByLessonTab() throws InterruptedException {
        clickElement(hrsByLessonTab);
        Thread.sleep(1000);
        clickElement(hrsByLessonItem);
    }

    // Chọn loại Học kỳ
    public void selectTerm() throws InterruptedException {
        clickElement(termDropdown); // Mở dropdown Học kỳ
        WebElement termInputField = driver.findElement(termInput);
        termInputField.clear();
        termInputField.sendKeys("Học kỳ" + Keys.RETURN);
        Thread.sleep(1000); // Chờ 1 giây cho thao tác
    }

    // Chọn số Học kỳ
    public void selectTerm2() throws InterruptedException {
        clickElement(term2Dropdown); // Mở dropdown Học kỳ 2
        WebElement term2InputField = driver.findElement(term2Input);
        term2InputField.clear();
        term2InputField.sendKeys("666" + Keys.RETURN);
        Thread.sleep(1000); // Chờ 1 giây cho thao tác
    }

    // Kiểm tra checkbox "Xem theo ca giảng"
    public void selectChB_CaGiang() throws InterruptedException {
        clickElement(chbCaGiang); // Nhấn vào checkbox "Xem theo ca giảng"
        Thread.sleep(4000); // Chờ 4 giây
    }

    // Chọn Bảng Biểu
    public void selectTable() throws InterruptedException {
        clickElement(tableButton); // Nhấn vào bảng biểu
        Thread.sleep(4000); // Chờ 4 giây
    }

    // Kiểm tra bảng dữ liệu
    public void displayTable() throws Exception {
        // Đọc dữ liệu từ file JSON sử dụng JSONParser
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("D:\\ExpectedResult.json"));
        JSONArray expectedDataArray = (JSONArray) jsonObject.get("expectedData");

        // Lấy danh sách các dòng trong bảng
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='tblStatistics']/tbody/tr"));

        // Lặp qua từng dòng trong bảng và so sánh với dữ liệu mong đợi
        for (int i = 0; i < rows.size(); i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));

            // Lấy dữ liệu từ các cột trong mỗi hàng
            String ma_hp = columns.get(1).getText();
            String ten_hp = columns.get(2).getText();
            String nganh = columns.get(3).getText();
            String so_tc = columns.get(4).getText();
            String so_lop = columns.get(5).getText();
            String so_gio_giang = columns.get(6).getText();
            String so_gio_quy_doi = columns.get(7).getText();

            // Lấy dữ liệu mong đợi từ JSON
            JSONObject expectedData = (JSONObject) expectedDataArray.get(i);
            String expectedMaHp = (String) expectedData.get("ma_hp");
            String expectedTenHp = (String) expectedData.get("ten_hp");
            String expectedNganh = (String) expectedData.get("nganh");
            String expectedSoTc = (String) expectedData.get("so_tc");
            String expectedSoLop = (String) expectedData.get("so_lop");
            String expectedSoGioGiang = (String) expectedData.get("so_gio_giang");
            String expectedSoGioQuyDoi = (String) expectedData.get("so_gio_quy_doi");

            System.out.println("Mã HP: " + ma_hp + " - Tên HP: " + ten_hp + " - Ngành: " + nganh + " - Số TC: " + so_tc 
                    + " - Số lớp: " + so_lop + " - Số giờ giảng: " + so_gio_giang + " - Số giờ quy đổi: " + so_gio_quy_doi);
            System.out.println("Mã HP mong đợi: " + expectedMaHp + " - Tên HP mong đợi: " + expectedTenHp + " - Ngành mong đợi: " + expectedNganh
                    + " - Số TC mong đợi: " + expectedSoTc + " - Số lớp mong đợi: " + expectedSoLop + " - Số giờ giảng mong đợi: " 
                    + expectedSoGioGiang + " - Số giờ quy đổi mong đợi: " + expectedSoGioQuyDoi);
            
            // So sánh dữ liệu thực tế với dữ liệu mong đợi
            boolean isMatch = true;

            if (!ma_hp.equals(expectedMaHp)) {
                System.out.println("Lỗi: Mã HP không khớp");
                isMatch = false;
            }
            if (!ten_hp.equals(expectedTenHp)) {
                System.out.println("Lỗi: Tên HP không khớp");
                isMatch = false;
            }
            if (!nganh.equals(expectedNganh)) {
                System.out.println("Lỗi: Ngành không khớp");
                isMatch = false;
            }
            if (!so_tc.equals(expectedSoTc)) {
                System.out.println("Lỗi: Số TC không khớp");
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
            if (!so_gio_quy_doi.equals(expectedSoGioQuyDoi)) {
                System.out.println("Lỗi: Số giờ quy đổi không khớp");
                isMatch = false;
            }

            // Nếu tất cả các giá trị đều khớp
            if (isMatch) {
                System.out.println("Kết quả hợp lệ\n");
            } else {
                System.out.println("Kết quả không hợp lệ\n");
            }
        }
    }
}
