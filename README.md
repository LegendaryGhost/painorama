### **Cahier des Charges**

#### **1. Présentation du Projet (Painorama)**
L’objectif de cette application web est de faciliter la gestion d’une boulangerie en prenant en compte trois principaux aspects : la gestion des ingrédients, des produits, et de la production. L’application doit offrir une interface conviviale permettant de suivre les stocks, planifier les productions et gérer les produits vendus.

---

#### **2. Fonctionnalités Principales**

##### **2.1. Gestion des Ingrédients**
- **Fiche d’ingrédient :**
    - Création, modification, suppression des ingrédients.
    - Suivi des stocks d’ingrédients (quantité actuelle, seuil d’alerte, unité de mesure).
- **Approvisionnement :**
    - Ajout des livraisons d’ingrédients avec mise à jour automatique des stocks.
    - Gestion des fournisseurs (nom, contact, historique des commandes).
- **Alertes de stock :**
    - Notification pour les ingrédients dont le stock est inférieur au seuil.

##### **2.2. Gestion des Produits**
- **Fiche produit :**
    - Création, modification, suppression des produits finis (ex. baguette, croissant).
    - Définition des recettes associées (ingrédients et quantités nécessaires).
- **Tarification :**
    - Gestion des prix de vente par produit.
    - Calcul automatique du coût de revient à partir des ingrédients.

##### **2.3. Gestion de la Production**
- **Planification de la production :**
    - Ajout des productions prévues avec les produits et quantités à produire.
    - Vérification automatique des stocks d’ingrédients nécessaires.
    - Génération d’une liste d’achats si des ingrédients sont manquants.
- **Suivi de la production :**
    - Enregistrement des productions réalisées avec mise à jour des stocks de produits finis.
    - Historique des productions.

##### **2.4. Gestion des Stocks**
- **Suivi en temps réel :**
    - Stock des ingrédients et des produits finis.
- **Historique des mouvements :**
    - Entrées et sorties des ingrédients et produits.

##### **2.5. Tableau de Bord**
- Vue synthétique des données clés :
    - Niveau des stocks.
    - Produits les plus vendus.
    - Productions planifiées vs réalisées.
    - Alertes de stock faible.

##### **2.6. Authentification et Gestion des Utilisateurs**
- **Types de profils :**
    - Administrateur (gestion complète).
    - Employé (accès limité : production et consultation des stocks).
- **Connexion sécurisée :**
    - Authentification avec email et mot de passe.

---

#### **3. Spécifications Techniques**
- **Front-end :**
    - Moteur de templating : ThymeLeaf.
- **Back-end :**
    - Framework : Spring Boot.
- **Base de données :**
    - Système : PostgreSQL.
    - Tables principales : `ingredient`, `produit`, `recette`, `production`, `mouvement_stock`, `utilisateur`.
- **Hébergement :**
    - Serveur cloud (ex. AWS, Heroku, ou autre).

---

#### **4. Contraintes et Exigences**
- **Sécurité :**
    - Protection des données sensibles (chiffrement des mots de passe).
    - Contrôle d'accès en fonction du rôle utilisateur.
- **Performance :**
    - Temps de réponse inférieur à 1 seconde pour les opérations principales.
- **Maintenance :**
    - Documentation technique et fonctionnelle.
    - Tests automatisés pour les fonctionnalités critiques.

---

#### **5. Livrables**
- Application web fonctionnelle.
- Code source et documentation.
- Manuel d’utilisation pour les administrateurs et employés.

---

#### **6. Planning Prévisionnel**
1. Analyse des besoins : 1 semaine.
2. Conception des maquettes et architecture : 2 semaines.
3. Développement front-end et back-end : 6 semaines.
4. Tests et corrections : 2 semaines.
5. Livraison finale : 1 semaine.

---

#### **7. Budget Prévisionnel**
- Développement : XXX €.
- Hébergement annuel : XXX €.
- Maintenance et support : XXX €/an.
