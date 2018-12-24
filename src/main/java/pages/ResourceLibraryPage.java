package pages;

import framework.FrameworkControl;
import framework.Functions;
import framework.WebdriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResourceLibraryPage extends WebdriverBase {
    private FrameworkControl stcHeader = new FrameworkControl(By.xpath("//span[text()='SpringCM Resource Library']"));
    private FrameworkControl lnkMediaTypes = new FrameworkControl(By.linkText("Media Types"));
    private FrameworkControl lnkReports = new FrameworkControl(By.linkText("Reports"));

    public boolean exists() {
        return stcHeader.exists(5);
    }

    public void clickMediaTypes() {
        lnkMediaTypes.click();
    }

    public void clickReports() {
        lnkReports.click();
        Functions.sleep(1);
    }

    public List<WebElement> getAllResources() {
        FrameworkControl resourceTypes = new FrameworkControl(By.xpath("//div[contains(@class,'portfolio-item')]"));
        List<WebElement> resources = resourceTypes.getMyElements();
        return resources;
    }

    public List<String> getDisplayedResources() {
        List<WebElement> resources = getAllResources();
        List<String> displayedResources = new ArrayList<String>();
        for (int x = 0; x < resources.size(); x++) {
            if (resources.get(x).isDisplayed()) {
                displayedResources.add(resources.get(x).getText().replace("\n", "|"));

            }
        }
        log.info("Found " + displayedResources.size() + " resources displayed");
        return displayedResources;
    }
}
