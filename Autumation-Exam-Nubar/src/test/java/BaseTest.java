import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        System.out.println("Test Setup!!");
        DriverSetup.getDriver().manage().window().maximize();
        DriverSetup.getDriver().navigate().refresh();
    }

    @AfterMethod
    public void tearDown() {
        DriverSetup.getDriver().navigate().refresh();
        System.out.println("Test kill!");
        DriverSetup.getDriver().quit();

    }
}
