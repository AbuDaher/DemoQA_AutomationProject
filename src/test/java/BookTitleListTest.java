import org.testng.annotations.Test;
import utils.Utils;

public class BookTitleListTest extends BaseTest{
    @Test
    public void getAllBooksTitles (){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.getAllBooksTitles();
    }
}

