CREATE TABLE utilisateur (
    id serial  PRIMARY KEY,
    nom_utilisateur VARCHAR(255) NOT NULL,
    mot_de_passe VARCHAR(255) NOT NULL,
    role INTEGER NOT NULL
);
