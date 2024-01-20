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
            String translatedName = apiClient.translateText(artikel.getName(), "IT");
            String translatedBeschreibung = apiClient.translateText(artikel.getBeschreibung(), "IT");

            Artikel translatedArtikel = new Artikel(artikel.getId(), translatedName, translatedBeschreibung);
            translatedArtikel.setZielsprache("IT");
            artikelRepository.saveTranslatedArtikel(translatedArtikel);
        }


        List<Artikel> translatedArtikelList = artikelRepository.getAllTranslatedArtikel();
        for (Artikel ta : translatedArtikelList) {
            System.out.println("Übersetzter Artikel ID: " + ta.getId());
            System.out.println("Name: " + ta.getName());
            System.out.println("Beschreibung: " + ta.getBeschreibung());
            System.out.println("Zielsprache: " + ta.getZielsprache());
            System.out.println("---------------------------------------------------");
        }
    }
}
