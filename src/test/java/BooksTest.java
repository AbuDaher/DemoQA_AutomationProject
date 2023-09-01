import org.testng.annotations.Test;
import utils.Utils;

public class BooksTest extends BaseTest{

    @Test
    public void verifyBookListTest (){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.printAllBooks();
    }

    @Test
    public void printAuthorAndPublisherByBookNamePositiveTest(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.printAuthorAndPublisherIfBookIsPresent("JavaScript");
    }

    @Test
    public void printAuthorAndPublisherByBookNameNegativeTest(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.printAuthorAndPublisherIfBookIsPresent("Harry Potter");
    }

    @Test
    public void printBookTitlesByIndexText(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.printBookTitleByIndex(2);
    }

    @Test
    public void printBookAuthorsByIndexText(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        books.getAuthorByIndex(3);
    }
}