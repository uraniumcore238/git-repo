package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getWebSenderLogin() {
        return getAuthorizationConfig().webSenderLogin();
    }

    public static String getWebSenderPassword() {
        return getAuthorizationConfig().webSenderPassword();
    }

    public static String getWebReceiverLogin() {
        return getAuthorizationConfig().webReceiverLogin();
    }

    public static String getWebReceiverPassword() {
        return getAuthorizationConfig().webReceiverPassword();

    }

    public static String getWebUrl(){
        return getWebConfig().webUrl();
    }

    public static String getWebRemoteDriver(){
        // https://%s:%s@selenoid.autotests.cloud/wd/hub/
        return String.format(System.getProperty("web.remote.driver"),
        getWebConfig().webRemoteDriverUser(), getWebConfig().webRemoteDriverPassword());
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver") != null;
    }

    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage() != null;
    }

    public static String getWebRemoteDriverUser(){
        return getWebConfig().webRemoteDriverUser();
    }

    private static AuthorizationConfig getAuthorizationConfig() {
        return ConfigFactory.newInstance().create(
                AuthorizationConfig.class, System.getProperties());
    }

    private static WebConfig getWebConfig(){
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }




}
