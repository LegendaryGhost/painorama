-- Création de la base de données
CREATE DATABASE painorama;

-- Connexion à la base de données
\c painorama;

-- Extension de hachage Postgres
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE parfum
(
    id_parfum SERIAL,
    nom       VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_parfum),
    UNIQUE (nom)
);

CREATE TABLE unite
(
    id_unite SERIAL,
    nom      VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_unite),
    UNIQUE (nom)
);

CREATE TABLE ingredient
(
    id_ingredient SERIAL,
    nom           VARCHAR(255)   NOT NULL,
    prix_achat    NUMERIC(15, 2) NOT NULL,
    id_unite      INTEGER        NOT NULL,
    PRIMARY KEY (id_ingredient),
    FOREIGN KEY (id_unite) REFERENCES unite (id_unite)
);

CREATE TABLE statut_production
(
    id_statut_production SERIAL,
    nom                  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_statut_production)
);

CREATE TABLE utilisateur
(
    id_utilisateur SERIAL,
    nom            VARCHAR(255),
    email          VARCHAR(255) NOT NULL,
    mot_de_passe   VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_utilisateur),
    UNIQUE (email)
);

CREATE TABLE categorie
(
    id_categorie SERIAL,
    nom          VARCHAR(255) NOT NULL,
    PRIMARY KEY (id_categorie),
    UNIQUE (nom)
);

CREATE TABLE produit
(
    id_produit   SERIAL,
    nom          VARCHAR(255)   NOT NULL,
    prix_vente   NUMERIC(15, 2) NOT NULL,
    id_categorie INTEGER        NOT NULL,
    id_parfum    INTEGER        NOT NULL,
    PRIMARY KEY (id_produit),
    FOREIGN KEY (id_categorie) REFERENCES categorie (id_categorie),
    FOREIGN KEY (id_parfum) REFERENCES parfum (id_parfum)
);

CREATE TABLE recette
(
    id_recette       SERIAL,
    quantite_requise NUMERIC(15, 2) NOT NULL,
    id_produit       INTEGER        NOT NULL,
    id_ingredient    INTEGER        NOT NULL,
    PRIMARY KEY (id_recette),
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

CREATE TABLE mouvement_stock
(
    id_mouvement_stock SERIAL,
    quantite_entree    NUMERIC(15, 2) NOT NULL DEFAULT 0,
    quantite_sortie    NUMERIC(15, 2) NOT NULL DEFAULT 0,
    date_heure         TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_produit         INTEGER,
    id_ingredient      INTEGER,
    PRIMARY KEY (id_mouvement_stock),
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

CREATE TABLE production
(
    id_production        SERIAL,
    date_heure           TIMESTAMP NOT NULL,
    quantite             INTEGER   NOT NULL,
    id_produit           INTEGER   NOT NULL,
    id_statut_production INTEGER   NOT NULL,
    PRIMARY KEY (id_production),
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit),
    FOREIGN KEY (id_statut_production) REFERENCES statut_production (id_statut_production)
);

CREATE TABLE vente
(
    id_vente   SERIAL,
    quantite   NUMERIC(15, 2) NOT NULL,
    date_heure TIMESTAMP      NOT NULL,
    id_produit INTEGER        NOT NULL,
    PRIMARY KEY (id_vente),
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit)
);
