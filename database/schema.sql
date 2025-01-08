-- Création de la base de données
CREATE DATABASE painorama;

-- Connexion à la base de données
\c painorama;

-- Extension de hachage Postgres
CREATE EXTENSION IF NOT EXISTS pgcrypto;

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

CREATE TABLE produit
(
    id_produit SERIAL,
    nom        VARCHAR(255)   NOT NULL,
    prix_vente NUMERIC(15, 2) NOT NULL,
    PRIMARY KEY (id_produit)
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

CREATE TABLE statut_production
(
    id_statut_production SERIAL,
    nom                  VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_statut_production)
);

CREATE TABLE mouvement_stock
(
    id_mouvement_stock SERIAL,
    quantite_entree    NUMERIC(15, 2) NOT NULL DEFAULT 0,
    quantite_sortie    NUMERIC(15, 2) NOT NULL DEFAULT 0,
    date_mouvement     DATE           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_produit         INTEGER,
    id_ingredient      INTEGER,
    PRIMARY KEY (id_mouvement_stock),
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit),
    FOREIGN KEY (id_ingredient) REFERENCES ingredient (id_ingredient)
);

CREATE TABLE production
(
    id_production        SERIAL,
    date_production      DATE    NOT NULL,
    quantite_produite    INTEGER NOT NULL,
    id_produit           INTEGER NOT NULL,
    id_statut_production INTEGER NOT NULL,
    PRIMARY KEY (id_production),
    FOREIGN KEY (id_produit) REFERENCES produit (id_produit),
    FOREIGN KEY (id_statut_production) REFERENCES statut_production (id_statut_production)
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
