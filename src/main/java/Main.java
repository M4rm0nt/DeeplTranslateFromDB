import controller.DeepLApiClient;
import repositorys.ArtikelRepository;
import models.Artikel;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DeepLApiClient apiClient = new DeepLApiClient();
        ArtikelRepository artikelRepository = new ArtikelRepository();

        List<Artikel> artikelList = artikelRepository.getAllArtikel();
        for (Artikel artikel : artikelList) {
            String artikelName = apiClient.translateText(artikel.getName(), "EN");
            String translatedBeschreibung = apiClient.translateText(artikel.getBeschreibung(), "EN");
            System.out.println("Artikel ID: " + artikel.getId());
            System.out.println("Name: " + artikelName);
            System.out.println("Beschreibung: " + translatedBeschreibung);
            System.out.println("---------------------------------------------------");
        }
    }
}
