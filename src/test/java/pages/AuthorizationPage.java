package pages;

import Actions.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.Init;

public class AuthorizationPage {
    public AuthorizationPage (WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    //Кнопка входа при входе на сайт
    @FindBy(xpath = "//*[@id=\"index-page-container\"]/div/div[2]/div/div/div[4]/a[2]")
    private static WebElement introBtn;

    //Поле ввода логина
    @FindBy(xpath = "//input[@data-t=\"field:input-login\"]")
    private static WebElement loginField;

    //Кнопка логина
    @FindBy(xpath = "//button[contains(@data-t, \"button:action:passp:sign-in\")]")
    private static WebElement loginBtn;

    //Кнопка ввода пароля
    @FindBy(xpath = "//input[contains(@data-t, \"field:input-passwd\")]")
    private static WebElement passwordField;

    //Кнопка меню пользователя
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[8]/div/div[2]/div/div/div[3]/div/div/a[1]/div/img")
    private static WebElement userMenuBtn;

    //Текст логина пользователя
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[8]/div/div[2]/div/div/div[3]/div/div/div/ul/div[1]/div/span/span")
    private static WebElement loginText;

    public void authentification(){
        driver.get(Init.PAGE_URL);
        Steps.btnClick(introBtn);
        Steps.textEntered(loginField, Init.USER_LOGIN);
        Steps.btnClick(loginBtn);
        Steps.textEntered(passwordField, Init.USER_PASSWORD);
        Steps.btnClick(loginBtn);
    }
    public String getLoginText(){
        return loginText.getText();
    }

    public WebElement getUserMenuBtn(){
        return userMenuBtn;
    }

}
