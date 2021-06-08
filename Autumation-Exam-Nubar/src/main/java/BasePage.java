import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage<T> {
    protected WebDriver driver;
    public static final String BASE_URL="https://tree.taiga.io";
    public static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage() {
        this.driver = DriverSetup.getDriver();
    }

    public abstract String getUrl();

    protected void open(String url) {
        LOGGER.info("Opening Url " + DriverSetup.getDriver().getCurrentUrl());
        driver.get(url);
    }

    protected T initPage() {
        PageFactory.initElements(DriverSetup.getDriver(), this);
        LOGGER.info("Initialising to " + DriverSetup.getDriver().getCurrentUrl());
        return (T) this;
    }



    protected void click(WebElement element) {
        clickActions(element);
        element.click();
    }

    protected void clickActions(WebElement element) {

        WaitHelper.getInstance().waitForElementToBeDisplayed(element);
        new Actions(DriverSetup.getDriver()).moveToElement(element).click().build().perform();
    }

    protected void clickAndOpenNewTab(WebElement element) {
        WaitHelper.getInstance().waitForElementToBeDisplayed(element);
        LOGGER.info("Switching to new Tab by clicking on element -> " + element.toString());
        List<String> windowHandles = new ArrayList<>(DriverSetup.getDriver().getWindowHandles());
        DriverSetup.getDriver().switchTo().window(windowHandles.get(windowHandles.size() - 1));
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
