package pages;

import framework.FrameworkControl;
import framework.WebdriverBase;
import org.openqa.selenium.By;

public class HomePage extends WebdriverBase {
    public TopNav nav = new TopNav();

    public FrameworkControl btnRequestDemo = new FrameworkControl(By.xpath("//a[contains(.,'REQUEST DEMO')]"));

    public boolean exists() {
        return btnRequestDemo.exists(5);
    }
}
