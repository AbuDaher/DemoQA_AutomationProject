import org.testng.annotations.Test;
import utils.Utils;

public class BookAuthorsListTest extends BaseTest{

    @Test
    public void getAllBooksAuthors (){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.getAllBooksAuthors();
    }
}
