import constants.Constants;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Utils;

public class LogInTest extends BaseTest {
    @Test
    public void logInTest()  {
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        this.books.logInCredentials();
        Utils.waitInSeconds(2);
        String message = this.books.logInConfirmation();
        Assert.assertEquals(message, Constants.LOG_IN_USER_CONFIRMATION_MESSAGE, ErrorMessages.SIGN_IN_USER_DYSPLAYED);
        driver.close();
    }
}