import org.testng.annotations.Test;
import utils.Utils;

public class BookInformationListTest extends BaseTest{

    @Test
    public void getAllBookInformation(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.allBookInformation();
    }

    @Test
    public void createHashMapTitleAndAuthorsTest(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.hashMapTitleKeyAuthorValue();
        books.allBookInformation();
        books.hashMapTitleKeyAuthorValue();
        books.extractValueByKey("Speaking JavaScript");
        books.extractKeyByValue("Kyle Simpson");
    }

    @Test
    public void getInfoFromURL(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        this.books.selectBookForUrl();
    }

    @Test
    public void compareBooks(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        this.books.compareBooks();
    }
}