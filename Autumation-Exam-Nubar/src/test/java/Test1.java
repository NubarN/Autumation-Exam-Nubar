import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


@Listeners(TestListener.class)
public class Test1 extends BaseTest {


    @Test
    public void discoverPage(){
        DiscoverPage discover =  new DiscoverPage().open();
        assertEquals(discover.getUrl(), DriverSetup.getDriver().getCurrentUrl(),"Did not navigate to [Discover Page]");

        LoginPage loginPage = discover.clickOnLogin().open();
        assertEquals(loginPage.getUrl(), DriverSetup.getDriver().getCurrentUrl(),"Did not navigate to [Login Page]");
        assertTrue(loginPage.isLoginConatinerDisplayed(), "Login frame is not present");

    }
}
