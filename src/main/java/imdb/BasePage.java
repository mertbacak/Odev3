package imdb;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.junit.jupiter.api.Assertions;
import io.appium.java_client.MobileElement;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.lang.Thread.sleep;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasePage {
    AppiumDriver driver;

    @AndroidFindBy(id = "android:id/button2")
    private MobileElement dialogOkButton;
    @AndroidFindBy(xpath = "//*[@text='Siz']")
    private MobileElement myAccountIcon;
    public BasePage(AppiumDriver appiumDriver){
        this.driver =appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void waitGenericMethod(MobileElement element) {
        FluentWait<AppiumDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(ofSeconds(10))
                        .pollingEvery(ofSeconds(1))
                        .ignoring(NoSuchElementException.class)
                        .withMessage("element not found");

        wait.until(ExpectedConditions.visibilityOf(element));
        Assertions.assertTrue(element.isDisplayed());
    }
    public void profilIconClick(){
        elementClick(myAccountIcon);
    }
    public void elementClick(MobileElement element)
    {
        waitGenericMethod(element);
        element.click();
    }

    public void textEnter(MobileElement element,String text)
    {
        waitGenericMethod(element);
        element.sendKeys(text);
    }

    public void setDialogOkButton(){
        elementClick(dialogOkButton);
    }

    private void scrollUp(int fromX, int fromY, int toX, int toY) {
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(point(fromX, fromY)).moveTo(point(toX, toY)).release().perform();
    }

    public void elementVisiblescrollDown(MobileElement element) {
        for (int i = 0; i <= 50; i++) {
            try {
                if (element.isDisplayed()==true) {
                    System.out.println("Element Göründü");
                    i=50;
                }
            } catch (Exception e) {
                int pressX = driver.manage().window().getSize().width / 2;
                int bottomY = driver.manage().window().getSize().height * 4 / 5;
                int topY = driver.manage().window().getSize().height / 6;
                scrollUp(pressX, bottomY, pressX, topY);
                System.out.println("Element görüntülenmedi scroll yapıldı.");
            }
        }
    }
    public void elementVisibleHorizontalScroll(MobileElement element,MobileElement visibleElement) {
        for (int i=0; i<=50; i++) {
            try {
                if (visibleElement.isDisplayed() == true) {
                    System.out.println("Element Göründü");
                    i = 50;
                }
            }
            catch (Exception e) {
                Dimension size = element.getSize();
                ElementOption press = element(element, size.width / 2 + 2, size.height / 2);
                ElementOption move = element(element, 1, size.height / 2);
                TouchAction swipe = new TouchAction(driver).press(press)
                        .waitAction(waitOptions(ofSeconds(2)))
                        .moveTo(move).release();
                swipe.perform();
                System.out.println("Element Görüntülenmedi sağa swipe edildi");
            }
        }

    }

    }


