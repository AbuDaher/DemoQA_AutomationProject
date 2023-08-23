import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utils.Utils;

public class HomePageTest extends BaseTest{

    @Test
    public void verifyPageElementsTest(){
        // Check if Page title is present
        this.homePage.clickBookStoreApplicationCard();
        Utils.waitInSeconds(1);
        Assert.assertTrue(homePage.isPageTitlePresent());
        SoftAssert softAssert = new SoftAssert();
        //Check if Subtitles is present
       softAssert.assertFalse(homePage.isSubtitlePresent(),"Error Subtitle first assertion");
       softAssert.assertTrue(homePage.isSubtitlePresent(),"Error Subtitle second assertion");
        System.out.println("I was here");
       softAssert.assertTrue(homePage.isSubtitlePresent(), "Error Subtitle third assertion");
       softAssert.assertAll();

    }
}
