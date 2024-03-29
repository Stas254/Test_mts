package ru.astondevs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;

public class Mts {
    @FindBy(xpath = "//div[@class=\"pay__wrapper\"]/child::h2")
    private WebElement nameBlock;

    @FindBy(xpath = "//button[@id='cookie-agree' and text()='Принять']")
    private WebElement cookieAgree;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[@alt='Visa']")
    private WebElement altVisa;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[@alt='Verified By Visa']")
    private WebElement altVerifiedByVisa;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[@alt='MasterCard']")
    private WebElement altMasterCard;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[@alt='MasterCard Secure Code']")
    private WebElement altMasterCardSecureCode;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[@alt='Белкарт']")
    private WebElement altBelcard;

    @FindBy(xpath = "//div[@class='pay__partners']/descendant::img[@alt='МИР']")
    private WebElement altPeace;

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


    public Mts() {
    }

    public void visibleCookie() {
        if (cookieAgree.isDisplayed())
            cookieAgree.click();
    }

    public String nameBlockSelect() {
        String result = nameBlock.getText();
        return result;
    }

    public ArrayList availPaymLogos() {
        ArrayList<WebElement> logos = new ArrayList<>();
        Collections.addAll(logos, altVisa, altVerifiedByVisa, altMasterCard, altMasterCardSecureCode, altBelcard, altPeace);
        return logos;
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

}