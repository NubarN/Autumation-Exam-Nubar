import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {


    private final static int DEFAULT_TIMEOUT = 10;

    public static WaitHelper getInstance() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }
    public WaitHelper waitForElementToBeDisplayed(By location) {
        try {
            new WebDriverWait(DriverSetup.getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error ("Element with provided locator was not displayed "
                    + location.toString() );
        }
    }

    public WaitHelper waitForElementToBeDisplayed(WebElement element) {
        try {
            new WebDriverWait(DriverSetup.getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.visibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error ("Element with provided locator was not displayed "
                    + element.toString() );
        }
    }
    public WaitHelper waitForElementToBeInvisible(WebElement element) {
        try {
            new WebDriverWait(DriverSetup.getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.invisibilityOf(element));
            return this;
        } catch (WebDriverException e) {
            throw new Error ("Element with provided locator was not displayed "
                    + element.toString() );
        }
    }

    public WaitHelper waitForElementToBeClickable(By location) {
        try {
            new WebDriverWait(DriverSetup.getDriver(), DEFAULT_TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable((location)));
            return this;
        } catch (WebDriverException e) {
            throw new Error ("Element with provided locator was not displayed "
                    + location.toString() );
        }
    }

}
