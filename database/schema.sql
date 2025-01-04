-- Création de la base de données
CREATE DATABASE painorama;

-- Connexion à la base de données
\c painorama;

-- Extension de hachage Postgres
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Table des ingrédients
CREATE TABLE ingredient
(
    id             SERIAL PRIMARY KEY,
    nom            VARCHAR(100)   NOT NULL,
    prix_achat     NUMERIC(10, 2) NOT NULL,
    quantite_stock NUMERIC(10, 2) NOT NULL DEFAULT 0, -- Quantité actuelle
    unite          VARCHAR(20)    NOT NULL,           -- Unité de mesure (ex: kg, L)
    seuil_alerte   NUMERIC(10, 2) NOT NULL            -- Seuil pour les alertes
);

-- Table des produits
CREATE TABLE produit
(
    id           SERIAL PRIMARY KEY,
    nom          VARCHAR(100)   NOT NULL,
    prix_vente   NUMERIC(10, 2) NOT NULL,
    cout_revient NUMERIC(10, 2) NOT NULL DEFAULT 0 -- Calculé à partir des recette
);

-- Table des recettes (relation ingrédients -> produit)
CREATE TABLE recette
(
    id               SERIAL PRIMARY KEY,
    id_produit       INT            NOT NULL REFERENCES produit (id) ON DELETE CASCADE,
    id_ingredient    INT            NOT NULL REFERENCES ingredient (id) ON DELETE CASCADE,
    quantite_requise NUMERIC(10, 2) NOT NULL -- Quantité d'ingrédient nécessaire
);

-- Table des productions
CREATE TABLE statut_production
(
    id  SERIAL PRIMARY KEY,
    nom VARCHAR(20) NOT NULL UNIQUE
);

CREATE TABLE production
(
    id                   SERIAL PRIMARY KEY,
    date_production      DATE NOT NULL,
    id_produit           INT  NOT NULL REFERENCES produit (id) ON DELETE CASCADE,
    quantite_produite    INT  NOT NULL,
    id_statut_production INT  NOT NULL DEFAULT 1 REFERENCES statut_production (id) -- planifie, en cours, termine
);

-- Table des mouvements de stock (historique des entrées/sorties)
CREATE TABLE mouvement_stock
(
    id              SERIAL PRIMARY KEY,
    id_ingredient   INT            REFERENCES ingredient (id) ON DELETE SET NULL,
    id_produit      INT            REFERENCES produit (id) ON DELETE SET NULL,
    quantite_entree NUMERIC(10, 2) NOT NULL DEFAULT 0,
    quantite_sortie NUMERIC(10, 2) NOT NULL DEFAULT 0,
    date_mouvement  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Table des utilisateurs
CREATE TABLE utilisateur
(
    id           SERIAL PRIMARY KEY,
    nom          VARCHAR(100)        NOT NULL,
    email        VARCHAR(100) UNIQUE NOT NULL,
    mot_de_passe VARCHAR(255)        NOT NULL, -- Hashé pour la sécurité
    est_admin    BOOLEAN             NOT NULL DEFAULT FALSE
);

-- Index pour les recherches fréquentes
CREATE INDEX idx_produit_nom ON produit (nom);
CREATE INDEX idx_ingredient_nom ON ingredient (nom);
CREATE INDEX idx_mouvements_date ON mouvement_stock (date_mouvement);
