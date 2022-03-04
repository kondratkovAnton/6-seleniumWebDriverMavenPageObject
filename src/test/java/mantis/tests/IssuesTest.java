package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IssuesTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void checkIssuesNumber() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToViewIssuesPage();
        int actualIssuesNumber = mantisSite.getViewIssuesPage().countIssues();
        Assertions.assertEquals(50, actualIssuesNumber);
    }

    @Test
    public void createAndDeleteReportIssueTest() {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.getReportIssuePage().createNewReportIssue("Summary_1", "Description_1");
        mantisSite.getMainPage().goToViewIssuesPage();
        String actualIssueSummary = mantisSite.getViewIssuesPage().getIssueSummary();
        String expectedIssueID = mantisSite.getViewIssuesPage().getIssueID();

        softAssertions.assertThat(actualIssueSummary).isEqualTo("Summary_1");

        mantisSite.deleteReportIssue();
        String actualIssueID = mantisSite.getViewIssuesPage().getIssueID();

        softAssertions.assertThat(actualIssueID).isNotEqualTo(expectedIssueID);
    }
}
