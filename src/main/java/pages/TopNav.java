package pages;

import framework.FrameworkControl;
import framework.WebdriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TopNav extends WebdriverBase {
    private FrameworkControl lnkProducts = new FrameworkControl(By.linkText("Products"));
    private FrameworkControl lnkResources = new FrameworkControl(By.linkText("Resources"));
    private FrameworkControl lnkResourcesLibrary = new FrameworkControl(By.xpath("(//a[contains(.,'Resources Library')])"));
    private FrameworkControl lnkSearch = new FrameworkControl(By.xpath("(//*[@id='search-toggle']/i)[2]"), "Search Button");

    public void clickSearch() {
        lnkSearch.click();
    }

    public void selectResourceLibrary() {
        lnkResources.hoverOverMe();
        lnkResourcesLibrary.clickDisplayed();
    }


}
