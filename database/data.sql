INSERT INTO utilisateur (nom, email, mot_de_passe)
VALUES ('Jean Dupont', 'jean.dupont@example.com', crypt('mdp_jean123', gen_salt('bf'))),
       ('Marie Curie', 'marie.curie@example.com', crypt('mdp_marie456', gen_salt('bf'))),
       ('Albert Einstein', 'albert.einstein@example.com', crypt('mdp_albert789', gen_salt('bf'))),
       ('Ada Lovelace', 'ada.lovelace@example.com', crypt('mdp_ada012', gen_salt('bf'))),
       ('Alan Turing', 'alan.turing@example.com', crypt('mdp_alan345', gen_salt('bf')));

INSERT INTO unite (nom)
VALUES ('Kilogramme'),
       ('Litre'),
       ('Pièce');

INSERT INTO ingredient (nom, prix_achat, id_unite)
VALUES ('Farine', 1200, 1),
       ('Sucre', 8000, 1),
       ('Beurre', 5000, 1),
       ('Lait', 6000, 2),
       ('Levure', 1000, 1),
       ('Œufs', 1500, 3),
       ('Chocolat', 3000, 1),
       ('Sel', 5000, 1),
       ('Crème', 1800, 2),
       ('Vanille', 5000, 1);

INSERT INTO mouvement_stock (id_ingredient, id_produit, quantite_entree, quantite_sortie, date_heure)
VALUES
    -- Mouvements pour l'ingrédient 1 (Farine)
    (1, NULL, 50.00, 0.00, '2024-12-20 10:00:00'),
    (1, NULL, 0.00, 20.00, '2024-12-21 15:30:00'),
    -- Mouvements pour l'ingrédient 2 (Sucre)
    (2, NULL, 30.00, 0.00, '2024-12-19 09:00:00'),
    (2, NULL, 0.00, 15.00, '2024-12-20 14:45:00'),
    -- Mouvements pour l'ingrédient 3 (Beurre)
    (3, NULL, 10.00, 0.00, '2024-12-20 11:15:00'),
    (3, NULL, 0.00, 5.00, '2024-12-22 16:10:00'),
    -- Mouvements pour l'ingrédient 4 (Lait)
    (4, NULL, 100.00, 0.00, '2024-12-19 08:30:00'),
    (4, NULL, 0.00, 50.00, '2024-12-21 12:00:00'),
    -- Mouvements pour l'ingrédient 5 (Levure)
    (5, NULL, 3.00, 0.00, '2024-12-18 17:20:00'),
    (5, NULL, 0.00, 1.50, '2024-12-21 09:50:00'),
    -- Mouvements pour l'ingrédient 6 (Œufs)
    (6, NULL, 100.00, 0.00, '2024-12-20 07:00:00'),
    (6, NULL, 0.00, 80.00, '2024-12-21 18:00:00'),
    -- Mouvements pour l'ingrédient 7 (Chocolat)
    (7, NULL, 10.00, 0.00, '2024-12-19 14:00:00'),
    (7, NULL, 0.00, 3.00, '2024-12-22 19:30:00'),
    -- Mouvements pour l'ingrédient 8 (Sel)
    (8, NULL, 5.00, 0.00, '2024-12-20 10:45:00'),
    (8, NULL, 0.00, 2.00, '2024-12-21 14:00:00'),
    -- Mouvements pour l'ingrédient 9 (Crème)
    (9, NULL, 15.00, 0.00, '2024-12-19 11:30:00'),
    (9, NULL, 0.00, 7.00, '2024-12-20 16:20:00'),
    -- Mouvements pour l'ingrédient 10 (Vanille)
    (10, NULL, 2.00, 0.00, '2024-12-18 13:15:00'),
    (10, NULL, 0.00, 0.50, '2024-12-21 17:45:00');

INSERT INTO categorie (nom)
VALUES ('Viennoiserie'),
       ('Pâtisserie'),
       ('Pain'),
       ('Gâteau');

INSERT INTO parfum (nom)
VALUES ('Nature'),
       ('Chocolat'),
       ('Fraise'),
       ('Vanille'),
       ('Pomme'),
       ('Caramel'),
       ('Noisette');

INSERT INTO produit (nom, prix_vente, id_categorie, id_parfum)
VALUES ('Croissant', 2000, 1, 1),          -- Nature
       ('Pain au chocolat', 2500, 3, 2),   -- Chocolat
       ('Baguette', 1500, 3, 1),           -- Nature
       ('Pain complet', 2000, 3, 1),       -- Nature
       ('Éclair au chocolat', 3500, 2, 2), -- Chocolat
       ('Tarte aux pommes', 4500, 4, 5),   -- Pomme
       ('Mille-feuille', 5000, 4, 4),      -- Vanille
       ('Opéra', 6000, 2, 6),              -- Nature
       ('Croissant', 2000, 1, 2),          -- Chocolat
       ('Phare Breton', 2000, 1, 1); -- Nature

INSERT INTO recette (quantite_requise, id_produit, id_ingredient)
VALUES
    -- Croissant
    (0.25, 1, 1), -- 0.25 kg de Farine
    (0.1, 1, 2),  -- 0.1 kg de Sucre
    (0.2, 1, 3),  -- 0.2 kg de Beurre
    (0.1, 1, 4),  -- 0.1 L de Lait
    (0.05, 1, 5), -- 0.05 kg de Levure
    (1, 1, 6),    -- 1 Œuf

    -- Pain au chocolat
    (0.25, 2, 1), -- 0.25 kg de Farine
    (0.1, 2, 2),  -- 0.1 kg de Sucre
    (0.2, 2, 3),  -- 0.2 kg de Beurre
    (0.1, 2, 4),  -- 0.1 L de Lait
    (0.05, 2, 5), -- 0.05 kg de Levure
    (1, 2, 6),    -- 1 Œuf
    (0.05, 2, 7), -- 0.05 kg de Chocolat

    -- Baguette
    (0.3, 3, 1),  -- 0.3 kg de Farine
    (0.01, 3, 8), -- 0.01 kg de Sel
    (0.1, 3, 5),  -- 0.1 kg de Levure

    -- Pain complet
    (0.3, 4, 1),  -- 0.3 kg de Farine
    (0.01, 4, 8), -- 0.01 kg de Sel
    (0.1, 4, 5),  -- 0.1 kg de Levure

    -- Éclair au chocolat
    (0.2, 5, 1),  -- 0.2 kg de Farine
    (0.1, 5, 2),  -- 0.1 kg de Sucre
    (0.15, 5, 3), -- 0.15 kg de Beurre
    (0.1, 5, 4),  -- 0.1 L de Lait
    (1, 5, 6),    -- 1 Œuf
    (0.05, 5, 7), -- 0.05 kg de Chocolat

    -- Tarte aux pommes
    (0.3, 6, 1),  -- 0.3 kg de Farine
    (0.15, 6, 2), -- 0.15 kg de Sucre
    (0.2, 6, 3),  -- 0.2 kg de Beurre
    (0.1, 6, 4),  -- 0.1 L de Lait
    (2, 6, 6),    -- 2 Œufs

    -- Mille-feuille
    (0.3, 7, 1),  -- 0.3 kg de Farine
    (0.2, 7, 2),  -- 0.2 kg de Sucre
    (0.3, 7, 3),  -- 0.3 kg de Beurre
    (0.2, 7, 9),  -- 0.2 L de Crème

    -- Opéra
    (0.3, 8, 1),  -- 0.3 kg de Farine
    (0.2, 8, 2),  -- 0.2 kg de Sucre
    (0.3, 8, 3),  -- 0.3 kg de Beurre
    (0.2, 8, 9),  -- 0.2 L de Crème
    (0.1, 8, 7),  -- 0.1 kg de Chocolat
    (0.05, 8, 10); -- 0.05 kg de Vanille

INSERT INTO statut_production (nom)
VALUES ('En cours'),
       ('Terminée'),
       ('Annulée');

INSERT INTO production (date_heure, quantite, id_produit, id_statut_production)
VALUES ('2025-01-01 08:00:00', 100, 1, 2), -- 100 Croissants, statut "Terminée"
       ('2025-01-01 09:30:00', 80, 2, 2),  -- 80 Pains au chocolat, statut "Terminée"
       ('2025-01-02 07:45:00', 200, 3, 1), -- 200 Baguettes, statut "En cours"
       ('2025-01-02 10:15:00', 150, 4, 1), -- 150 Pains complets, statut "En cours"
       ('2025-01-03 14:00:00', 50, 5, 3),  -- 50 Éclairs au chocolat, statut "Annulée"
       ('2025-01-04 11:30:00', 60, 6, 2),  -- 60 Tartes aux pommes, statut "Terminée"
       ('2025-01-05 16:45:00', 30, 7, 1),  -- 30 Mille-feuilles, statut "En cours"
       ('2025-01-06 18:20:00', 20, 8, 2); -- 20 Opéras, statut "Terminée"

INSERT INTO vente (quantite, date_heure, id_produit)
VALUES (10, '2025-01-01 10:30:00', 1), -- Vente de croissants
       (5, '2025-01-02 12:15:00', 2),  -- Vente de pains au chocolat
       (20, '2025-01-03 09:45:00', 3), -- Vente de baguettes
       (8, '2025-01-03 10:00:00', 4),  -- Vente de pains complets
       (6, '2025-01-04 15:20:00', 5),  -- Vente d'éclairs au chocolat
       (3, '2025-01-05 14:10:00', 6),  -- Vente de tartes aux pommes
       (4, '2025-01-06 16:00:00', 7),  -- Vente de mille-feuilles
       (2, '2025-01-07 18:30:00', 8),  -- Vente d'opéras
       (20, '2025-01-01 10:30:00', 9); -- Vente de croissants au chocolat

INSERT INTO produit_conseil (date_conseil, description, id_produit)
VALUES ('2025-01-01', 'Produit de saison hivernale, parfait pour accompagner un chocolat chaud.',
        1),                                                                                            -- Croissant Nature
       ('2025-01-01', 'Parfait pour bien commencer l’année avec une option classique.', 3),            -- Baguette Nature
       ('2025-01-01', 'Produit riche en fibres pour une alimentation équilibrée après les fêtes.', 4), -- Pain complet
       ('2025-02-01', 'Idéal pour la Saint-Valentin, saveur chocolatée appréciée.', 2),                -- Pain au chocolat
       ('2025-02-01', 'Délice au chocolat idéal pour les cadeaux de Saint-Valentin.', 5),              -- Éclair au chocolat
       ('2025-02-01', 'Saveur raffinée pour célébrer l’amour et le plaisir.', 7),                      -- Mille-feuille
       ('2025-03-01', 'Option sans gluten disponible, idéal pour les clients sensibles.', 3),          -- Baguette Nature
       ('2025-03-01', 'Saveur fruitée qui annonce l’arrivée du printemps.', 6),                        -- Tarte aux pommes
       ('2025-03-01', 'Dessert chocolaté parfait pour les dernières soirées fraîches de l’hiver.',
        2),                                                                                            -- Pain au chocolat
       ('2025-04-01', 'Recommandé pour son apport en fibres au printemps.', 4),                        -- Pain complet
       ('2025-05-01', 'Dessert léger et apprécié en mai.', 5),                                         -- Éclair au chocolat
       ('2025-06-01', 'Produit phare pour les pique-niques d’été.', 6),                                -- Tarte aux pommes
       ('2025-09-01', 'Retour des saveurs classiques pour la rentrée.', 7),                            -- Mille-feuille
       ('2025-10-01', 'Parfait pour accompagner le café pendant l’automne.', 8),                       -- Opéra
       ('2025-12-01', 'Produit festif au chocolat, très demandé en décembre.', 9); -- Croissant Chocolat

INSERT INTO produit_conseil (date_conseil, description, id_produit)
VALUES ('2024-01-01', 'Produit de saison hivernale, parfait pour accompagner un chocolat chaud.',
        1),                                                                                            -- Croissant Nature
       ('2024-01-01', 'Parfait pour bien commencer l’année avec une option classique.', 3),            -- Baguette Nature
       ('2024-01-01', 'Produit riche en fibres pour une alimentation équilibrée après les fêtes.', 4), -- Pain complet
       ('2024-02-01', 'Idéal pour la Saint-Valentin, saveur chocolatée appréciée.', 2),                -- Pain au chocolat
       ('2024-02-01', 'Délice au chocolat idéal pour les cadeaux de Saint-Valentin.', 5),              -- Éclair au chocolat
       ('2024-02-01', 'Saveur raffinée pour célébrer l’amour et le plaisir.', 7),                      -- Mille-feuille
       ('2024-03-01', 'Option sans gluten disponible, idéal pour les clients sensibles.', 3),          -- Baguette Nature
       ('2024-03-01', 'Saveur fruitée qui annonce l’arrivée du printemps.', 6),                        -- Tarte aux pommes
       ('2024-03-01', 'Dessert chocolaté parfait pour les dernières soirées fraîches de l’hiver.',
        2),                                                                                            -- Pain au chocolat
       ('2024-04-01', 'Recommandé pour son apport en fibres au printemps.', 4),                        -- Pain complet
       ('2024-05-01', 'Dessert léger et apprécié en mai.', 5),                                         -- Éclair au chocolat
       ('2024-06-01', 'Produit phare pour les pique-niques d’été.', 6),                                -- Tarte aux pommes
       ('2024-09-01', 'Retour des saveurs classiques pour la rentrée.', 7),                            -- Mille-feuille
       ('2024-10-01', 'Parfait pour accompagner le café pendant l’automne.', 8),                       -- Opéra
       ('2024-12-01', 'Produit festif au chocolat, très demandé en décembre.', 9); -- Croissant Chocolat

