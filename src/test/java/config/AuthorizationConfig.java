package config;
import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorization.properties"
})
public interface AuthorizationConfig extends Config {

    @Config.Key("web.sender.login")
    String webSenderLogin();

    @Config.Key("web.sender.password")
    String webSenderPassword();

    @Config.Key("web.receiver.login")
    String webReceiverLogin();

    @Config.Key("web.receiver.password")
    String webReceiverPassword();







}