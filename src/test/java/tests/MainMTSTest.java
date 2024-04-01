package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.astondevs.Mts;


public class MainMTSTest extends BasicTest {

    @Test
    public void nameBlockCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);
        wdm.get("https://www.mts.by/");
        mts.visibleCookie();
        Assert.assertTrue(mts.nameBlockSelect().contains("Онлайн пополнение"));
    }

    @Test
    public void availPaymLogosCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);
        wdm.get("https://www.mts.by/");
        mts.visibleCookie();
        Assert.assertFalse(mts.availPaymLogos().isEmpty());
    }

    @Test
    public void logoCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);
        wdm.get("https://www.mts.by/");
        mts.visibleCookie();
        mts.goLink();
        Assert.assertTrue(wdm.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
    }

    @Test
    public void enterDataCheck() {
        Mts mts = PageFactory.initElements(wdm, Mts.class);
        wdm.get("https://www.mts.by/");
        mts.visibleCookie();
        mts.enterData();
    }

}