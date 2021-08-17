package tests;

import Actions.Steps;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthorizationPage;
import pages.MailPage;
import settings.Init;
import settings.WebDriverSettings;

public class MainTest extends WebDriverSettings {
    private static AuthorizationPage authorizationPage;
    private static MailPage mailPage;


    @BeforeClass
    public static void setupTest(){
        Init.setup();
        authorizationPage = new AuthorizationPage(driver);
        mailPage = new MailPage(driver);
        authorizationPage.authentification();
    }
    @Test
    public void auth(){
        Steps.btnClick(authorizationPage.getUserMenuBtn());
        Assert.assertEquals(authorizationPage.getLoginText(), Init.USER_LOGIN);
    }

    @Test
    public void mailCheck(){
        mailPage.mailCheck();
        Steps.btnClick(mailPage.getDraftBtn());
        System.out.println(mailPage.getDraftEmailToText());
        System.out.println(mailPage.getDraftThemeText());
        //System.out.println(mailPage.getDraftTextText());
//        Assert.assertEquals(mailPage.getDraftEmailToText(),Init.MAIL_TO);
//        Assert.assertEquals(mailPage.getDraftThemeText(),Init.MAIL_THEME);
//        Assert.assertEquals(mailPage.getDraftTextText(),Init.MAIL_TEXT);
    }

}
