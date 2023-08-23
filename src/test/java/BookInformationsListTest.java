import org.testng.annotations.Test;
import utils.Utils;

public class BookInformationsListTest extends BaseTest{
    @Test
    public void getAllBookInformations(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.allBookInformation();
    }
}