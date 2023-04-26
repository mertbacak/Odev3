package imdb;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {
    @AndroidFindBy (xpath = "//*[@text='Search']")
    private MobileElement searchButton;
    @AndroidFindBy (xpath = "//*[@text='Top 250 TV shows']")
    private MobileElement top250TvShowCategory;
    @AndroidFindBy(xpath = "//*[@text='Streaming & TV']")
    private MobileElement streamingTVText;
    @AndroidFindBy (xpath = "//*[@text='1. Dünya Gezegeni - 2']")
    private MobileElement top250FirstFilm;
    @AndroidFindBy(xpath = "//*[@resource-id='com.imdb.mobile:id/list']")
    List<WebElement> top250TvShowFilmList;
    @AndroidFindBy (id = "com.imdb.mobile:id/state_off")
    private MobileElement watchListButton;
    @AndroidFindBy (xpath = "//*[@text='Dünya Gezegeni - 2']")
    private MobileElement watchListFilm;
    @AndroidFindBy (id="com.imdb.mobile:id/text_on")
    private MobileElement watchListAddedText;
    @AndroidFindBy(id = "com.imdb.mobile:id/recycler_view")
    private MobileElement cast;
    @AndroidFindBy(xpath = "//*[@text='Emma Napper']")
    private MobileElement catActorEmmaNaper;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.ImageView[2]")
    private MobileElement favoriteIcon;
    @AndroidFindBy (xpath = "//*[@text='Sevdiğiniz Sinemalar']")
    private MobileElement favoritePeopleField;
    @AndroidFindBy (id = "com.imdb.mobile:id/notification_not_now")
    private MobileElement notificationNotNow;

    public SearchPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void searchIconClick(){
       elementClick(searchButton);
    }
    public void swipe250TvShowSwipe(){
      elementVisiblescrollDown(top250TvShowCategory);
    }
    public void swipe250TvClick(){
        elementClick(top250TvShowCategory);
    }
    public void top250FirstFilmClick(){
        elementClick(top250FirstFilm);
    }
    public void  watchListButtonClick(){
        elementClick(watchListButton);
    }
    public void swipeCast(){
        elementVisiblescrollDown(cast);
    }
    public void horizontalSwipeCast(){
        elementVisibleHorizontalScroll(cast,catActorEmmaNaper);
    }
    public void fiveCastFavoriteIconClick(){
        elementClick(favoriteIcon);
    }
    public void swipeFavoritePeopleField()
    {
        elementVisiblescrollDown(favoritePeopleField);
    }
    public String setFavoritePeopleNameText(){
        waitGenericMethod(catActorEmmaNaper);
        String a= catActorEmmaNaper.getText();
        return a;
    }

    public String watchListFilmAddedText(){
        waitGenericMethod(watchListAddedText);
        String a= watchListAddedText.getText();
        return a;
    }
    public String myAccountwatchListFilmCheck(){
        waitGenericMethod(watchListFilm);
        String a= watchListFilm.getText();
        return a;
    }

    public void setNotificationNotNow(){
        elementClick(notificationNotNow);
    }

}

