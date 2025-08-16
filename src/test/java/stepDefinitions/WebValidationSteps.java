package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.BasePage;
import utils.WebDriverManager;

import java.util.Set;

public class WebValidationSteps extends BasePage {
    
    private String mainWindowHandle;
    private WebElement resultElement;
    
    @Given("I initialize the browser {string}")
    public void i_initialize_the_browser(String browserName) {
        WebDriverManager.initializeDriver(browserName);
    }
    
    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
        driver.get(url);
        mainWindowHandle = getCurrentWindowHandle();
    }
    
    // Alert Step Definitions
    @When("I click on {string} button")
    public void i_click_on_button(String buttonText) {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(),'" + buttonText + "')]"));
        waitForElementToBeClickable(button);
        button.click();
    }
    
    @Then("I should see alert with text {string}")
    public void i_should_see_alert_with_text(String expectedText) {
        Assert.assertTrue(isAlertPresent(), "Alert is not present");
        String actualText = getAlertText();
        Assert.assertEquals(actualText, expectedText, "Alert text mismatch");
    }
    
    @When("I accept the alert")
    public void i_accept_the_alert() {
        acceptAlert();
    }
    
    @When("I dismiss the alert")
    public void i_dismiss_the_alert() {
        dismissAlert();
    }
    
    @When("I enter text {string} in alert")
    public void i_enter_text_in_alert(String text) {
        sendTextToAlert(text);
    }
    
    @Then("I should see result text {string}")
    public void i_should_see_result_text(String expectedText) {
        resultElement = driver.findElement(By.id("result"));
        waitForElementToBeVisible(resultElement);
        Assert.assertEquals(resultElement.getText(), expectedText, "Result text mismatch");
    }
    
    // Wait Step Definitions
    @When("I click on start button")
    public void i_click_on_start_button() {
        WebElement startButton = driver.findElement(By.xpath("//button[text()='Start']"));
        waitForElementToBeClickable(startButton);
        startButton.click();
    }
    
    @Then("I should wait for loading to complete")
    public void i_should_wait_for_loading_to_complete() {
        WebElement loadingElement = driver.findElement(By.id("loading"));
        waitForElementToBeInvisible(loadingElement);
    }
    
    @And("I should see text {string}")
    public void i_should_see_text(String expectedText) {
        WebElement textElement = driver.findElement(By.xpath("//*[contains(text(),'" + expectedText + "')]"));
        waitForElementToBeVisible(textElement);
        Assert.assertTrue(textElement.isDisplayed(), "Text '" + expectedText + "' is not visible");
    }
    
    // Frame Step Definitions
    @When("I switch to frame {string}")
    public void i_switch_to_frame(String frameName) {
        switchToFrame(frameName);
    }
    
    @When("I switch to parent frame")
    public void i_switch_to_parent_frame() {
        switchToParentFrame();
    }
    
    // Window Step Definitions
    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        waitForElementToBeClickable(link);
        link.click();
    }
    
    @Then("I should have {int} windows open")
    public void i_should_have_windows_open(int expectedCount) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(expectedCount));
        Assert.assertEquals(getWindowCount(), expectedCount, "Window count mismatch");
    }
    
    @When("I switch to new window")
    public void i_switch_to_new_window() {
        switchToNewWindow();
    }
    
    @Then("I should see page title {string}")
    public void i_should_see_page_title(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertEquals(getCurrentWindowTitle(), expectedTitle, "Page title mismatch");
    }
    
    @When("I close current window")
    public void i_close_current_window() {
        closeCurrentWindow();
    }
    
    @When("I switch back to main window")
    public void i_switch_back_to_main_window() {
        switchToWindow(mainWindowHandle);
    }
    
    @Then("I close the browser")
    public void i_close_the_browser() {
        WebDriverManager.quitDriver();
    }
}
