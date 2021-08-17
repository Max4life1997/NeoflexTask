package settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Init {

    public static String USER_LOGIN;
    public static String USER_PASSWORD;

    public static String MAIL_TO;
    public static String MAIL_THEME;
    public static String MAIL_TEXT;
    public static String PAGE_URL;

    public static String PAGEURL;
    public static int IMPLICITYWAIT = 15;
    public static int PAGELOADTIMEOUT = 20;
    public static String BROWSER_TYPE;


    public static void setup(){
        try(FileInputStream fileProp = new FileInputStream("src/test/resources/setupData.properties")) {
            Properties props = new Properties();
            props.load(fileProp);

            USER_LOGIN = props.getProperty("USER_LOGIN");
            USER_PASSWORD = props.getProperty("USER_PASSWORD");

            MAIL_TO = props.getProperty("MAIL_TO");
            MAIL_THEME = props.getProperty("THEME_TEXT");
            MAIL_TEXT = props.getProperty("EMAIL_TEXT");
            PAGE_URL = props.getProperty("PAGE_URL");
            BROWSER_TYPE = props.getProperty("BROWSER_TYPE");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
