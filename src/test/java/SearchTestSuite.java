import framework.JunitTestDriver;
import framework.TestInfo;
import framework.WebdriverBase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ContractManagementDemoFormPage;
import pages.ContractManagementPage;
import pages.HomePage;
import pages.SearchPage;

public class SearchTestSuite extends JunitTestDriver {
    public HomePage home = new HomePage();
    public SearchPage search = new SearchPage();
    public ContractManagementPage contract = new ContractManagementPage();
    public ContractManagementDemoFormPage form = new ContractManagementDemoFormPage();

    // Test data - we could feed this in from a file
    public String textToSearchFor = "contract management";
    public String expectedSearchResult = "Contract Management Software | SpringCM";

    @BeforeClass
    public static void beforeClass() {
        beforeSuite("SearchTestSuite");
    }

    @AfterClass
    public static void afterClass() {
        afterSuite();
    }

    @Test
    @TestInfo(description = "Search for 'Contract Management' in SpringCM",
            categories = "test",
            level = "smoke")
    public void testSearchContractManagementInSpringCM() {

        log.result("Are we on the home page?", true, home.exists());

        doSearch(textToSearchFor, expectedSearchResult);
        search.closeSearch();
    }

    @Test
    @TestInfo(description = "Search for 'Contract Management' in SpringCM",
            categories = "test",
            level = "smoke")
    public void testSeeSpringCMInAction() {
        doSearch(textToSearchFor, expectedSearchResult);

        log.step("Select the Contract Management page");
        search.clickSearchResult(expectedSearchResult);
        log.result("Contract Management page is displayed?", true, contract.exists());
        contract.clickWatchOurDemoLink();
        log.result("Contract Management form displayed?", true, form.exists());

        log.step("Verify form messages");
        form.clickPlayVideoButton();
        String errorText = "Please complete this required field.";
        log.result("Verify First Name error", errorText, form.getFirstNameError());
        log.result("Verify Last Name error", errorText, form.getLastNameError());
        log.result("Verify Email error", errorText, form.getEmailError());
        log.result("Verify Phone error", errorText, form.getPhoneError());
        log.result("Verify Country error", errorText, form.getCountryError());

        log.step("Fill out the form and play the video");
        form.enterFormValues("test", "demo", "test@demo.com", "5555555555", "USA");
        form.clickPlayVideoButton();
        log.result("Is the demo video playing?", true, form.isVideoPlaying());
    }

    public void doSearch(String textToSearchFor, String expectedSearchResult) {
        log.step("Search for '" + textToSearchFor + "'");
        home.nav.clickSearch();
        log.result("Search field exists with placeholder text 'Type to search'", "Type to search", search.getSearchPlaceholderText());

        search.enterSearchText(textToSearchFor);
        log.result("Search field contains text '" + textToSearchFor + "'?'", textToSearchFor, search.getSearchValueText());
        log.result("Search results contain '" + expectedSearchResult + "'", true, search.resultsContainText(expectedSearchResult));
    }
}
