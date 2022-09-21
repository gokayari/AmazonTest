package com.clipboardHealth.pages;

import com.clipboardHealth.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {

    public AmazonPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = "input[name='login']")
    public WebElement emailInputBox;

    @FindBy (xpath = "//i[@class='hm-icon nav-sprite']")
    public WebElement hamburgerMenu;

    @FindBy (xpath = "//div[.='TV, Appliances, Electronics']")
    public WebElement tvAppliancesElectronicsButton;

    @FindBy (xpath = "//a[.='Televisions']")
    public WebElement televisionsButton;
    /*
        @FindBy (xpath = "//span[.='Samsung']")
        public WebElement samsungTv;
    */
    @FindBy (xpath = "//div/span[.='Brands']")
    public WebElement brandsHeader;

    @FindBy (xpath = "//span[.='Featured']")
    public WebElement sortButton;

    @FindBy (xpath = "//a[.='Price: High to Low']")
    public WebElement sortHighToLowButton;

    @FindBy (xpath = "//div[@data-index='2']")
    public WebElement secondPricedItem;

    @FindBy (xpath = "//h1[.=' About this item ']")
    public WebElement aboutThisItem;
}
