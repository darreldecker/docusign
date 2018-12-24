package pages;

import framework.FrameworkControl;
import framework.WebdriverBase;
import org.openqa.selenium.By;

public class ContractManagementPage extends WebdriverBase {

    FrameworkControl lnkWatchOurDemo = new FrameworkControl(By.xpath("//a[contains(.,'WATCH OUR PRODUCT DEMO')]"));
    FrameworkControl stcContractManagement = new FrameworkControl(By.xpath("//span[text()='Contract Management']"));

    public boolean exists() {
        return stcContractManagement.exists(5);
    }

    public String clickWatchOurDemoLink() {
        return lnkWatchOurDemo.clickAndSwitchTabs();
    }

}
