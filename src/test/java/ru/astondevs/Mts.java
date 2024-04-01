package ru.astondevs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class Mts {
    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]/child::h2")
    private WebElement nameBlock;

    @FindBy(xpath = "//button[@id='cookie-agree' and text()='Принять']")
    private WebElement cookieAgree;

    @FindBy(xpath = "//div[@class='pay__wrapper']/descendant::a[text()='Подробнее о сервисе']")
    private WebElement link;

    @FindBy(xpath = "//span[@class='select__now' and text()='Услуги связи']")
    private WebElement dropDown;

    @FindBy(xpath = "//p[@class='select__option' and text()='Услуги связи']")
    private WebElement dropDownSelect;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement phoneField;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement moneyField;

    @FindBy(xpath = "//form[@id='pay-connection']/child::button[@class='button button__default ' and text()='Продолжить']")
    private WebElement continueButton;

    @FindBy(xpath = "//p[@class='header__payment-info']")
    private WebElement decriptionPay;

    @FindBy(xpath = "//button[@class='colored disabled ng-star-inserted']")
    private WebElement payButton;

    @FindBy(xpath = "//label[@class='ng-tns-c49-1 ng-star-inserted']")
    private WebElement cardNumber;

    @FindBy(xpath = "//label[@class='ng-tns-c49-4 ng-star-inserted']")
    private WebElement validityPeriod;

    @FindBy(xpath = "//label[@class='ng-tns-c49-5 ng-star-inserted']")
    private WebElement cvc;

    @FindBy(xpath = "//label[@class='ng-tns-c49-3 ng-star-inserted']")
    private WebElement nameCardholder;

    @FindBy(xpath = "//label[@class='ng-tns-c52-2 ng-star-inserted']")
    private WebElement savePay;

    @FindBy(xpath = "//button[@class='gpay-button black plain short ru']")
    private WebElement gPay;

    @FindBy(xpath = "//button[@class='ya-pay-button ya-pay-button_black']")
    private WebElement yPay;

    @FindBy(xpath = "//p[@class='select__option']")
    private List<WebElement> variantsDropDown;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img")
    private List<WebElement> logos;

    @FindBy(xpath = "//img[@class='ng-tns-c55-0 ng-star-inserted']")
    private List<WebElement> variantsCards;

    @FindBy(xpath = "//img[@class='ng-tns-c55-0 ng-trigger ng-trigger-randomCardState ng-star-inserted']")
    private List<WebElement> varRandomCards;


    public void visibleCookie() {
        if (cookieAgree.isDisplayed())
            cookieAgree.click();
    }

    public String nameBlockSelect() {
        return nameBlock.getText();
    }

    public List<String> paymLogos() {
        List<String> actualLogos = new ArrayList<>();
        for (WebElement list : logos) {
            String l = list.getAttribute("alt");
            actualLogos.add(l);
        }
        return actualLogos;
    }

    public void goLink() {
        link.click();
    }

    public void enterData() {
        dropDown.click();
        dropDownSelect.click();
        phoneField.click();
        phoneField.clear();
        phoneField.sendKeys("297777777");
        moneyField.click();
        moneyField.clear();
        moneyField.sendKeys("25.25");
        continueButton.click();
    }

    public String sumFormVis() {
        return decriptionPay.getText();
    }

    public String sumButtonVis() {
        return payButton.getText();
    }

    public List<String> listDropDown() {
        dropDown.click();
        List<String> actualVariants = new ArrayList<>();
        for (WebElement variants : variantsDropDown) {
            String v = variants.getText();
            actualVariants.add(v);
        }
        return actualVariants;
    }

    public String cardNumberLabel() {
        return cardNumber.getText();
    }

    public String validityPeriodLabel() {
        return validityPeriod.getText();
    }

    public String cvcLabel() {
        return cvc.getText();
    }

    public String cardHolderLabel() {
        return nameCardholder.getText();
    }

    public String savePayLabel() {
        return savePay.getText();
    }

    public String gPayLabel() {
        return gPay.getAttribute("aria-label");
    }

    public String yPayLabel() {
        return yPay.getAttribute("aria-label");
    }

    public List<String> variantsCardsDispl() {
        List<String> actualVarCards = new ArrayList<>();
        for (WebElement varCards : variantsCards) {
            String cards = varCards.getAttribute("src");
            actualVarCards.add(cards);
        }
        return actualVarCards;
    }

    public List<String> varRandomCardsDispl() {
        List<String> actualVarRandCards = new ArrayList<>();
        for (WebElement varRanCards : varRandomCards) {
            String cardsRand = varRanCards.getAttribute("src");
            actualVarRandCards.add(cardsRand);
        }
        return actualVarRandCards;
    }

}