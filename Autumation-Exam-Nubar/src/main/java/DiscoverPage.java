import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscoverPage extends BasePage<DiscoverPage>
{

    @FindBy(css = "[class='discover-header-inner'] h1")
    private WebElement primaryTitle;

    @FindBy(css = "[class='login']")
    private WebElement loginButton;

    private static final String url = "/discover";


    public DiscoverPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    public DiscoverPage open(){
        open(getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        return BASE_URL+ url;
    }

    public boolean isTitleDisplayed(){
        WaitHelper.getInstance().waitForElementToBeDisplayed(primaryTitle);
        return isDisplayed(primaryTitle);
    }

    public LoginPage clickOnLogin(){
        WaitHelper.getInstance().waitForElementToBeDisplayed(loginButton);
        click(loginButton);
        return new LoginPage();
    }
}
