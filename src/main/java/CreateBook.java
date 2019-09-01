import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CreateBook {

   private WebDriver driver;

    public CreateBook(WebDriver driver) {
        this.driver = driver;
    }
    private By titleField = By.xpath("//input[@id='title']");
    private By authorList = By.xpath("//select[@id='author']");
    private By summaryField = By.xpath("//input[@id='summary']");
    private By isbnField = By.xpath("//input[@id='isbn']");
    private By nonfictionCheckbox = By.xpath("//input[@id='5b6714c73809970014e31c99']");
    private By fictionCheckbox = By.xpath("//input[@id='5b6714c93809970014e31c9a']");
    private By submitButton =By.xpath("//button[@class='btn btn-primary']");
    private By heading = By.xpath("//h1[contains(text(),'Create Book')]");
    private By headingNewBook = By.xpath("//h1[contains(text(),'Title')]");

    public CreateBook typeTitle(String title){
        driver.findElement(titleField).sendKeys(title);
        return this;
    }

    public CreateBook chooseAuthor(){
        WebElement selectAuth = driver.findElement(authorList);
        Select select = new Select(selectAuth);
        select.selectByVisibleText("Novik, Naomi");
        return this;
    }

    public CreateBook typeSummary(String summary){
        driver.findElement(summaryField).sendKeys(summary);
        return this;
    }

    public CreateBook typeIsbn(String isbn){
        driver.findElement(isbnField).sendKeys(isbn);
        return this;
    }

    public CreateBook chooseFiction(){
        driver.findElement(fictionCheckbox).click();
        return this;
    }

    public CreateBook chooseNonFiction(){
        driver.findElement(nonfictionCheckbox).click();
        return this;
    }
    public CreateBook tapButton(){
        driver.findElement(submitButton).click();
        return new CreateBook (driver);
    }

    public CreateBook create(String title, String summary, String isbn){
        this.typeTitle(title);
        this.chooseAuthor();
        this.typeSummary(summary);
        this.typeIsbn(isbn);
        this.chooseFiction();
        this.tapButton();
        return new CreateBook (driver);

    }
    public String head(){
        return driver.findElement(heading).getText();
    }
    public String newHead(){
        return driver.findElement(headingNewBook).getText();
    }
    public String title(){return driver.findElement(titleField).getText();}
}
