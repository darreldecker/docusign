import framework.JunitTestDriver;
import framework.TestInfo;
import org.junit.Test;
import pages.HomePage;
import pages.ResourceLibraryPage;

import java.util.ArrayList;
import java.util.List;

public class ResourceTestSuite extends JunitTestDriver {
    public HomePage home = new HomePage();
    public ResourceLibraryPage resource = new ResourceLibraryPage();

    @Test
    @TestInfo(description = "Display report resources",
            categories = "test",
            level = "smoke")
    public void testReportResources() {
        log.result("Are we on the home page?", true, home.exists());

        log.step("Navigate to the resource library");
        home.nav.selectResourceLibrary();
        log.result("Are we on the Resource Library page", true, resource.exists());

        log.step("Filter the media types to only reports and verify the content");
        resource.clickMediaTypes();
        resource.clickReports();
        List<String> actualResources = resource.getDisplayedResources();
        log.resultForListContains("Correct resources displayed?", getExpectedResources(), actualResources);
    }

    public List<String> getExpectedResources() {
        // These could be read in from a file
        List<String> resources = new ArrayList<String>();
        resources.add("REPORT|2018 State of Contract Management Report");
        resources.add("REPORT|Government Business Council Flash Poll: Citizen Engagement");
        resources.add("REPORT|[Forrester] It’s Time To Evolve Past Basic Contract Management");
        resources.add("REPORT|2017 Gartner CRM Vendor Guide");
        return resources;
    }
}
