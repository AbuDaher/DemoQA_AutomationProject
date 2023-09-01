import org.testng.annotations.Test;
import utils.Utils;

public class BooksPublisherListTest extends BaseTest{
    @Test
    public void getAllBooksPublishersList(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.getAllBooksPublisher();
    }

}
