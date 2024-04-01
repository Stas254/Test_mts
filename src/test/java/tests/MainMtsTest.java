package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.astondevs.Mts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainMtsTest extends BasicTest {

    @Test
    @DisplayName("Проверка названия блока \"Онлайн пополнение без комиссии\"")
    public void nameBlockCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();

        Assertions.assertTrue(mts.nameBlockSelect().contains("Онлайн пополнение"));
    }

    @Test
    @DisplayName("Проверка наличия логотипов платежных систем в блоке \"Онлайн пополнение без комиссии\"")
    public void paymLogosCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();

        Assertions.assertFalse(mts.paymLogos().isEmpty());

        /*List<String> expectedLogos = new ArrayList<>();
        Collections.addAll(expectedLogos, "Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт", "МИР");

        Assertions.assertEquals(expectedLogos, mts.paymLogos());*/
    }

    @Test
    @DisplayName("Проверка работы ссылки \"Подробнее о сервисе\"")
    public void linkCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();
        mts.goLink();

        Assertions.assertTrue(wdm.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    @DisplayName("Заполнение полей блока \"Онлайн пополнение без комиссии\" и проверка работы кнопки \"Продолжить\"")
    public void enterDataCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();
        mts.enterData();
    }

    @Test
    @DisplayName("Проверка вариантов оплаты услуг (список drop down блока \"Онлайн пополнение без комиссии\")")
    public void DropDownCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();
        List<String> expectedVariants = new ArrayList<>();
        Collections.addAll(expectedVariants, "Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность");

        Assertions.assertEquals(expectedVariants, mts.listDropDown());
    }

    /*@Test
    @DisplayName("Заполнение полей блока \"Онлайн пополнение без комиссии\" и проверка корректности отображения названия услуги, номера телефона и суммы оплаты")
    public void sumPaymNumPhoneCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();
        mts.enterData();

        wdm.switchTo().frame(wdm.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        new WebDriverWait(wdm, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='app-wrapper']")));

        Assertions.assertTrue(mts.sumFormVis().contains("Оплата: Услуги связи Номер:375297777777") && mts.sumButtonVis().contains("25.25 BYN"));
    }*/

    @Test
    @DisplayName("Проверка отображения выбранной услуги, заполнения номера телефона и суммы оплаты, данных банковской карты и наличия иконок всех платежных систем на форме оплаты")
    public void cardDataCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);

        mts.visibleCookie();
        mts.enterData();

        wdm.switchTo().frame(wdm.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        new WebDriverWait(wdm, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@class='app-wrapper']")));

        List<String> expectedVarCards = new ArrayList<>();
        Collections.addAll(expectedVarCards, "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg", "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg", "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg");
        List<String> expectedVarRandCards = new ArrayList<>();
        Collections.addAll(expectedVarRandCards, "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg", "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg");


        Assertions.assertTrue(mts.sumFormVis().contains("Оплата: Услуги связи Номер:375297777777") && mts.sumButtonVis().contains("25.25 BYN"));
        Assertions.assertEquals("Номер карты", mts.cardNumberLabel());
        Assertions.assertEquals("Срок действия", mts.validityPeriodLabel());
        Assertions.assertEquals("CVC", mts.cvcLabel());
        Assertions.assertEquals("Имя держателя (как на карте)", mts.cardHolderLabel());
        Assertions.assertEquals("Сохранить данные карты для последующих оплат", mts.savePayLabel());
        //Assertions.assertTrue(mts.variantsCardsDispl().get(0).contains("mastercard-system") && mts.variantsCardsDispl().get(1).contains("visa-system") && mts.variantsCardsDispl().get(2).contains("belkart-system"));
        Assertions.assertEquals(expectedVarCards, mts.variantsCardsDispl());
        Assertions.assertEquals(expectedVarRandCards, mts.varRandomCardsDispl());
        Assertions.assertEquals("Google Pay", mts.gPayLabel());
        Assertions.assertEquals("Yandex Pay", mts.yPayLabel());
    }

}