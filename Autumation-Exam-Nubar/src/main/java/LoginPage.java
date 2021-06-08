import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage<LoginPage>{

    @FindBy(css = "[class='login-form-container']")
    private WebElement loginContainer;

    private static final String url = "/login?next=%252Fdiscover";


    public LoginPage(){
        PageFactory.initElements(DriverSetup.getDriver(), this);
    }

    public LoginPage open(){
        open(getUrl());
        return this;
    }

    @Override
    public String getUrl() {
        return BASE_URL+ url;
    }

    public boolean isLoginConatinerDisplayed(){
        WaitHelper.getInstance().waitForElementToBeDisplayed(loginContainer);
        return isDisplayed(loginContainer);
    }


}
