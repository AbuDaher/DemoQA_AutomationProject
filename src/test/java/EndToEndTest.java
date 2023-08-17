import constants.Constants;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class EndToEndTest extends BaseTest{

    @Test
    public void endToEndTest(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        this.books.logInCredentials();
        Utils.waitInSeconds(2);
        String message = this.books.logInConfirmation();
        Assert.assertEquals(message, Constants.LOG_IN_USER_CONFIRMATION_MESSAGE, ErrorMessages.SIGN_IN_USER_DYSPLAYED);
        Utils.waitInSeconds(1);
        this.books.createBooksCollection();
        Assert.assertEquals(Constants.BOOK_ADDED_TO_COLLECTION_CONFIRMATION_MESSAGE, Utils.getAlertText(driver),
                ErrorMessages.ADD_TO_COLLECTION_ERROR_MESSAGE);
        Utils.waitInSeconds(2);
        Utils.acceptAlert(driver);
        this.books.setBackToBookStore();
        Utils.waitInSeconds(1);
    }

    @Test
    public void EndToEndTestManageCollection(){
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        this.books.logInCredentials();
        Utils.waitInSeconds(2);
        String message = this.books.logInConfirmation();
        Assert.assertEquals(message, Constants.LOG_IN_USER_CONFIRMATION_MESSAGE, ErrorMessages.SIGN_IN_USER_DYSPLAYED);
        Utils.waitInSeconds(1);
        this.books.goToProfileBooks();
        Utils.waitInSeconds(1);
        this.profileBooks.DeteleItem();
        Utils.waitInSeconds(1);
        this.profileBooks.confirmDeteleItem();
        Utils.waitInSeconds(2);
        this.profileBooks.logOut();
    }
}
