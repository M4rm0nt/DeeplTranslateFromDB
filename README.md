```sql
CREATE TABLE artikel (
id SERIAL PRIMARY KEY,
name VARCHAR(255),
beschreibung TEXT
);

CREATE TABLE translated_artikel (
    id SERIAL PRIMARY KEY,
    original_artikel_id INT,
    name VARCHAR(255),
    beschreibung TEXT,
    zielsprache VARCHAR(50),
    FOREIGN KEY (original_artikel_id) REFERENCES artikel(id)
);

INSERT INTO artikel (name, beschreibung) VALUES ('Stuhl', 'Aus Kirchenholz gefertigt, stabil und stilvoll');

INSERT INTO artikel (name, beschreibung) VALUES ('Tisch', 'Handgefertigter Esstisch aus Eichenholz');

INSERT INTO artikel (name, beschreibung) VALUES ('Lampe', 'Moderne Deckenlampe im Industriedesign');

SELECT * FROM artikel;


Artikel ID: 1
Name: Chair
Beschreibung: Made from church wood, sturdy and stylish
---------------------------------------------------
Artikel ID: 2
Name: Table
Beschreibung: Handcrafted oak dining table
---------------------------------------------------
Artikel ID: 3
Name: Lamp
Beschreibung: Modern ceiling lamp in industrial design
---------------------------------------------------