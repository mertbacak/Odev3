import imdb.LoginPage;
import imdb.SearchPage;
import io.appium.java_client.MobileElement;
import jdk.jfr.Description;
import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class SearcTest extends BaseTest {
    private SearchPage searchPage;
    private LoginPage loginPage;

    @BeforeEach
    public void before(){
        loginPage=new LoginPage(driver);
        searchPage=new SearchPage(driver);
    }
    @Description("Top250TV İlk Filmi İzleme Listesine Ekleme")
    @Test
    public void searchTop250TvWatchList(){
        loginPage.loginSuc();
        searchPage.searchIconClick();
        searchPage.swipe250TvShowSwipe();
        searchPage.swipe250TvClick();
        searchPage.top250FirstFilmClick();
        searchPage.watchListButtonClick();
        searchPage.setNotificationNotNow();
        Assertions.assertEquals(searchPage.watchListFilmAddedText(),"İzleme Listesine eklendi");
        searchPage.profilIconClick();
        Assertions.assertEquals(searchPage.myAccountwatchListFilmCheck(),"Dünya Gezegeni - 2");
    }
    @Description("Top250TV Altındaki Filmden Favori Oyuncu Ekleme")
    @Test
    public void searchTop250TvFavoriteActor(){
        loginPage.loginSuc();
        searchPage.searchIconClick();
        searchPage.swipe250TvShowSwipe();
        searchPage.swipe250TvClick();
        searchPage.top250FirstFilmClick();
        searchPage.swipeCast();
        searchPage.horizontalSwipeCast();
        searchPage.fiveCastFavoriteIconClick();
        searchPage.profilIconClick();
        searchPage.swipeFavoritePeopleField();
        Assertions.assertEquals(searchPage.setFavoritePeopleNameText(),"Emma Napper");
    }


}
