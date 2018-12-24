package pages;

import framework.FrameworkControl;
import framework.WebdriverBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContractManagementDemoFormPage extends WebdriverBase {
    FrameworkControl txtFirstName = new FrameworkControl(By.name("firstname"), "First Name");
    FrameworkControl txtLastName = new FrameworkControl(By.name("lastname"), "Last Name");
    FrameworkControl txtEmail = new FrameworkControl(By.name("email"), "Email");
    FrameworkControl txtPhone = new FrameworkControl(By.name("phone"), "Phone");
    FrameworkControl txtCountry = new FrameworkControl(By.name("country"), "Country");
    FrameworkControl btnPlayVideo = new FrameworkControl(By.xpath("//input[@value='PLAY VIDEO']"));
    FrameworkControl btnPauseVideo = new FrameworkControl(By.xpath("//button[contains(@title,'Pause')]"));

    public boolean exists() {
        return (txtFirstName.exists() && btnPlayVideo.exists());
    }

    public void clickPlayVideoButton() {
        btnPlayVideo.click();
    }

    public void enterFormValues(String firstname, String lastname, String email, String phone, String country) {
        btnPlayVideo.waitForMe();
        txtFirstName.setText(firstname);
        txtLastName.setText(lastname);
        txtEmail.setText(email);
        txtPhone.setText(phone);
        txtCountry.setText(country);
    }

    public boolean isVideoPlaying() {
        return btnPauseVideo.exists(10);
    }

    public String getFirstNameError() {
        try {
            return txtFirstName.getChildElements(By.xpath("../../ul//label")).get(0).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getLastNameError() {
        try {
            return txtLastName.getChildElements(By.xpath("../../ul//label")).get(0).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getEmailError() {
        try {
            return txtEmail.getChildElements(By.xpath("../../ul//label")).get(0).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getPhoneError() {
        try {
            return txtPhone.getChildElements(By.xpath("../../ul//label")).get(0).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getCountryError() {
        try {
            return txtCountry.getChildElements(By.xpath("../../ul//label")).get(0).getText();
        } catch (Exception e) {
            return "";
        }
    }
}
