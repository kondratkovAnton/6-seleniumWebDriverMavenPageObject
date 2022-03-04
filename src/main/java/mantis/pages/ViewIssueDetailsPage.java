package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssueDetailsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement deleteSubmit;

    @FindBy(xpath = "//*[@value='Delete Issues']")
    private WebElement deleteIssuesSubmit;

    public ViewIssueDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void deleteIssue() {
        deleteSubmit.click();
        deleteIssuesSubmit.click();
    }
}
