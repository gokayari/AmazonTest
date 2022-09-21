package com.clipboardHealth.step_definitions;

import com.clipboardHealth.pages.AmazonPage;
import com.clipboardHealth.utilities.BrowserUtils;
import com.clipboardHealth.utilities.ConfigurationReader;
import com.clipboardHealth.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AmazonStepDefinitions {

    AmazonPage amazonPage = new AmazonPage();

    String brandName = "";

    @Given("user is on the Amazon Home page")
    public void userIsOnTheAmazonHomePage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url.amazon"));

    }

    @When("user clicks the hamburger menu")
    public void userClicksTheHamburgerManu() {

        amazonPage.hamburgerMenu.click();

    }

    @And("user clicks the Tv Appliances Electronics Button")
    public void userClicksTheTvAppliancesElectronicsButton() {

        amazonPage.tvAppliancesElectronicsButton.click();
    }


    @And("user clicks the Televisions Button")
    public void userClicksTheTelevisionsButton() {

        amazonPage.televisionsButton.click();

    }
    /*
        @And("user goes all the way down and clicks the Brands Button")
        public void userGoesAllTheWayDownAndClicksTheBrandsButton() {

            Actions actions = new Actions(Driver.getDriver());

            actions.moveToElement(amazonPage.samsungTv).perform();

            amazonPage.samsungTv.click();

            BrowserUtils.sleep(1);


        }
    */
    @When("user goes all the way down and clicks the {string} Button")
    public void user_goes_all_the_way_down_and_clicks_the_button(String selectedBrand) {
        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(amazonPage.brandsHeader).perform();

        Driver.getDriver().findElement(By.xpath("//span/a/span[.='"+ selectedBrand+ "']")).click();

        BrowserUtils.sleep(1);

        brandName = selectedBrand;
    }

    @And("user clicks the sort button and sorts high to low")
    public void userClicksTheSortButtonAndSortsHighToLow() {

        amazonPage.sortButton.click();

        BrowserUtils.sleep(2);

        amazonPage.sortHighToLowButton.click();

        BrowserUtils.sleep(2);

    }

    @And("user clicks the second highest priced item")
    public void userClicksTheSecondHighestPricedItem() {

        amazonPage.secondPricedItem.click();
    }


    @Then("user verifies that About this item is visible and log the text")
    public void userVerifiesThatAboutThisItemIsVisible() {

        BrowserUtils.switchToWindow(brandName);

        Actions actions = new Actions(Driver.getDriver());

        actions.moveToElement(amazonPage.aboutThisItem).perform();

        Assert.assertTrue(amazonPage.aboutThisItem.isDisplayed());

        String text = amazonPage.aboutThisItem.getText();

        System.out.println("text = " + text);


    }

}
