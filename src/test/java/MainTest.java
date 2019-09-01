import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

    class MainTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://raamatukogu.herokuapp.com");
        mainPage = new MainPage(driver);
    }

    @Test
    void openCreateBookPageTest(){
        CreateBook createBook = mainPage.clickCreate();
        String heading = createBook.head();
        Assertions.assertEquals("Create Book",heading);

    }
    @Test
    void createNewBookTest(){
        CreateBook createBook = mainPage.clickCreate();
        createBook.create("The door","The door is open","123-13345");
        String newHeading = createBook.newHead();
        Assertions.assertTrue(newHeading.contains("The door"));
    }
    @Test
    void openBookListTest(){
        BookList bookList = mainPage.clickAllBooks();
        String headingBooks = bookList.head();
        Assertions.assertEquals("Book List",headingBooks);
    }
    @Test
    void verifyNewBookTest(){
        BookList bookList = mainPage.clickAllBooks();
        bookList.openBook();
        String summary = bookList.summary();
        Assertions.assertTrue(summary.contains("The door is open"));
    }
    @AfterEach
    void tearDown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000);
            driver.quit();
        }
    }

}
