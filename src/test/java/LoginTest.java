import imdb.LoginPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeEach
    public void before(){
        loginPage=new LoginPage(driver);
    }
    @Description("Login olma senaryosu")
    @Test
    public void loginCase(){
    loginPage.profilIconClick();
    loginPage.singInButtonClick();
    loginPage.setSingInImbdButtonClick();
    loginPage.emailTextboxEnter("qamobiltestekibi@gmail.com");
    loginPage.passwordTextboxEnter("24af3535");
    loginPage.loginButtonSubmit();
    Assertions.assertEquals(loginPage.setUsernameText(),"mobil");
    }

}
