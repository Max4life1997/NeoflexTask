package pages;

import Actions.Steps;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.Init;

public class MailPage {
    public MailPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebDriver driver;

    //Кнопка меню пользователя
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[8]/div/div[2]/div/div/div[3]/div/div/a[1]/div/img")
    private static WebElement userMenuBtn;

    //Кнопка выхода из аккаунта
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[8]/div/div[2]/div/div/div[3]/div/div/div/ul/ul/li[6]/a/span")
    private static WebElement exitBtn;

    //Кнопка "Написать"
    @FindBy(xpath = "//*[@Class = \"mail-ComposeButton js-main-action-compose\"]")
    private static WebElement createMessageBtn;

    //Поле ввода почты
    @FindBy(xpath = "//div[@class]/div[contains(@contenteditable, \"true\")]")
    private static WebElement emailToField;

    //Поле ввода темы почты
    @FindBy(xpath = "//input[@class =\"composeTextField ComposeSubject-TextField\"]")
    private static WebElement emailThemeField;

    //Поле ввода текста почты
    @FindBy(xpath = "//div[@class=\"cke_wysiwyg_div cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr cke_htmlplaceholder\"]")
    private static WebElement emailTextField;


    //Кнока Создать черновик (Закрыть открытое сообщение)
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[11]/div/div/div[1]/div/div[1]/div/div[2]/div/div[3]/button")
    private static WebElement createDraftBtn;

    //Кнопка черновики
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[2]/div[8]/div/div[3]/div[2]/div[3]/div/div[1]/div[5]/a[4]/span[2]")
    private static WebElement draftBtn;

    //Почта черновика
    @FindBy(xpath = "//*[contains(@class, 'ComposeYabble_editable')]/descendant::*[contains(@class, 'ComposeYabble-Text')]")
    private static WebElement draftEmailTo;

    //Тема черновика
    @FindBy(xpath = "//input[contains(@name, 'subject')]")
    private static WebElement draftTheme;

//    //Текст черновика
//    @FindBy(xpath = "")
//    private static WebElement draftText;

    public void mailCheck(){
        Steps.btnClick(createMessageBtn);

        Steps.textEntered(emailToField, Init.MAIL_TO);

        Steps.textEntered(emailThemeField, Init.MAIL_THEME);

        Steps.textEntered(emailTextField, Init.MAIL_TEXT);

    }

    public String getDraftEmailToText(){
        return draftEmailTo.getText();
    }

    public String getDraftThemeText(){
        return draftTheme.getAttribute("Value");
    }

//    public String getDraftTextText(){
//        return draftText.getText();
//    }

    public WebElement getDraftBtn(){
        return draftBtn;
    }
}
