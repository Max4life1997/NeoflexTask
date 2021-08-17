package Actions;

import com.sun.jdi.Value;
import jdk.jshell.execution.Util;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.WebDriverSettings;

public class Steps {
        public static void btnClick (WebElement btnToClick){
            WebDriverSettings.wait.until(ExpectedConditions.elementToBeClickable(btnToClick));
            btnToClick.click();
        }

        public static void textEntered (WebElement textField, String textToEnter){
            WebDriverSettings.wait.until(ExpectedConditions.elementToBeClickable(textField));
            textField.sendKeys(textToEnter);
        }

        public static void textAssertation(WebElement webElement, String textToAssert){
            WebDriverSettings.wait.until(ExpectedConditions.elementToBeClickable(webElement));
            String textAssert = webElement.getAttribute("Value");
            textAssert.equals(textAssert);
        }
}
