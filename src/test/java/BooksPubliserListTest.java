import org.testng.annotations.Test;
import utils.Utils;

public class BooksPubliserListTest extends BaseTest{

    @Test
    public void getAllBooksPublisher (){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.getAllBooksPublisher();
    }
}
