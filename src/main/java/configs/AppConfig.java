package configs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import exceptions.ConfigurationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppConfig.class);
    private static final AppConfig INSTANCE = new AppConfig();

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;
    private final String deepLApiKey;

    private AppConfig() {
        Properties properties = new Properties();
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new ConfigurationException("Konfigurationsdatei config.properties nicht gefunden");
            }
            properties.load(input);
            dbUrl = properties.getProperty("db.url");
            dbUser = properties.getProperty("db.user");
            dbPassword = properties.getProperty("db.password");
            deepLApiKey = properties.getProperty("deepl.api.key");

            if (dbUrl == null || dbUser == null || dbPassword == null || deepLApiKey == null) {
                throw new ConfigurationException("Erforderliche Konfigurationen fehlen in config.properties");
            }
        } catch (IOException e) {
            LOGGER.error("Fehler beim Laden der Konfigurationsdatei config.properties! {}", e.getMessage());
            throw new ConfigurationException("Fehler beim Laden der Konfigurationsdatei config.properties", e);
        }
    }

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDeepLApiKey() {
        return deepLApiKey;
    }
}
