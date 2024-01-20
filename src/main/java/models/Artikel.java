package models;

public class Artikel {
    private int id;
    private String name;
    private String beschreibung;
    private String zielsprache;

    public Artikel(int id, String name, String beschreibung) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public Artikel(int id, String name, String beschreibung, String zielsprache) {
        this.id = id;
        this.name = name;
        this.beschreibung = beschreibung;
        this.zielsprache = zielsprache;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getZielsprache() {
        return zielsprache;
    }

    public void setZielsprache(String zielsprache) {
        this.zielsprache = zielsprache;
    }
}
