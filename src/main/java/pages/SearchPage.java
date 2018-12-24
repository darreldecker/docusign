package pages;

import framework.FrameworkControl;
import framework.WebdriverBase;
import org.openqa.selenium.By;

public class SearchPage extends WebdriverBase {

    private FrameworkControl txtSearchTerm = new FrameworkControl(By.xpath("//input[contains(@class,'sj-search-bar-input ')]"), "Search");
    private FrameworkControl btnResultsNext = new FrameworkControl(By.xpath("//div[contains(@class,'sj-paginator')]/div[contains(.,'>')]"));
    private FrameworkControl btnCloseSearch = new FrameworkControl(By.xpath("//div[contains(@class,'sj-overlay-close')]"), "Search Close");

    public String getSearchPlaceholderText() {
        return txtSearchTerm.getAttribute("placeholder");
    }

    public String getSearchValueText() {
        return txtSearchTerm.getAttribute("value");
    }

    public void enterSearchText(String textToSearch) {
        txtSearchTerm.setText(textToSearch);
        btnResultsNext.waitForMe();
    }

    public boolean resultsContainText(String textToFind) {
        FrameworkControl result = new FrameworkControl(By.xpath("//a[contains(.,'" + textToFind + "')]"));
        return result.exists(2);
    }

    public void clickSearchResult(String resultText) {
        FrameworkControl result = new FrameworkControl(By.xpath("//a[contains(.,'" + resultText + "')]"));
        result.click();
    }

    public void closeSearch() {
        btnCloseSearch.click();
    }
}
