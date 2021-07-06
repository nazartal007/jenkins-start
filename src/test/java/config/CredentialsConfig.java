package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/credentials.properties"
})
public interface CredentialsConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("basicAuthLogin")
    String basicAuthLogin();

    @Key("basicAuthPassword")
    String basicAuthPassword();

    @Key("selenoidUrl")
    String selenoidUrl();
}
