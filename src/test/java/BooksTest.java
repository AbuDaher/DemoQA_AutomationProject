import org.testng.annotations.Test;
import utils.Utils;

public class BooksTest extends BaseTest{

@Test
    public void verifyBookListTest (){
    this.homePage.clickBookStoreApplicationCard();
    Utils.waitInSeconds(1);
    books.printAllBooks();
}


}
