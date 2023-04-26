package imdb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.jupiter.api.Assertions;

public class LoginPage extends BasePage{

    public LoginPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy(id = "com.imdb.mobile:id/sign_in_button")
    private MobileElement singInButton;
    @AndroidFindBy(id = "com.imdb.mobile:id/imdb_auth_portal")
    private MobileElement singInImbdButton;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='ap_email']")
    private MobileElement emailTextbox;
    @AndroidFindBy(xpath= "//android.widget.EditText[@resource-id='ap_password']")
    private MobileElement passwordTextbox;
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='signInSubmit']")
    private MobileElement singInSumnitButton;
    @AndroidFindBy(id = "com.imdb.mobile:id/user_name")
    private MobileElement usernameText;


    public void singInButtonClick(){
        elementClick(singInButton);
    }
    public void setSingInImbdButtonClick(){
        elementClick(singInImbdButton);
    }
    public void emailTextboxEnter(String email){textEnter(emailTextbox,email);}
    public void passwordTextboxEnter(String password){
        textEnter(passwordTextbox,password);
    }
    public void loginButtonSubmit(){
        elementClick(singInSumnitButton);
    }
   public String setUsernameText(){
       waitGenericMethod(usernameText);
       String a= usernameText.getText();
       return a;
   }
   public void loginSuc(){
        profilIconClick();
        singInButtonClick();
        setSingInImbdButtonClick();
        emailTextboxEnter("qamobiltestekibi@gmail.com");
        passwordTextboxEnter("24af3535");
        loginButtonSubmit();
        Assertions.assertEquals(setUsernameText(),"mobil");
   }


}
