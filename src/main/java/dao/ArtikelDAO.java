package dao;

import models.Artikel;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArtikelDAO {

    public List<Artikel> getAllArtikel() {
        List<Artikel> artikelList = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM artikel");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Artikel artikel = new Artikel(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("beschreibung")
                );
                artikelList.add(artikel);
            }
        } catch (Exception e) {
            e.printStackTrace(); // oder Loggen des Fehlers
        }
        return artikelList;
    }
}
