import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public  By home = By.xpath("//a[contains(text(),'Home')]");
    public  By createBook = By.xpath("//li[9]//a[1]");
    public  By allBooks = By.xpath("//a[contains(text(),'All books')]");

    public  MainPage clickHome(){
        driver.findElement(home).click();
        return new MainPage(driver);
    }
    public CreateBook clickCreate(){
        driver.findElement(createBook).click();
        return new CreateBook(driver);
    }
    public BookList clickAllBooks(){
        driver.findElement(allBooks).click();
        return new BookList(driver);
    }

}
