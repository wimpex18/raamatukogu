import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookList {
    WebDriver driver;

    public BookList(WebDriver driver) {
        this.driver = driver;
    }
    private By headingBookList = By.xpath("//h1[contains(text(),'Book List')]");
    private By newBook = By.xpath("//a[contains(text(),'The door')]");
    private By summary = By.xpath("//p[contains(text(),'The door is open')]");

    public BookList openBook(){
        driver.findElement(newBook).click();
        return new BookList (driver);
    }

    public String head(){
        return driver.findElement(headingBookList).getText();
    }
    public String summary(){
        return driver.findElement(summary).getText();
    }
}
