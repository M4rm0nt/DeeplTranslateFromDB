package repositorys;

import models.Artikel;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArtikelRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArtikelRepository.class);

    public List<Artikel> getAllArtikel() {
        List<Artikel> artikelList = new ArrayList<>();
        String query = "SELECT * FROM artikel";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                try {
                    Artikel artikel = new Artikel(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("beschreibung")
                    );
                    artikelList.add(artikel);
                } catch (Exception e) {
                    LOGGER.error("Fehler beim Verarbeiten der Ergebnisse: {}", e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Fehler beim Abrufen der Daten: {}", e.getMessage(), e);
        }
        return artikelList;
    }
}
