INSERT INTO utilisateur (nom, email, mot_de_passe, est_admin)
VALUES ('Jean Dupont', 'jean.dupont@example.com', crypt('mdp_jean123', gen_salt('bf')), TRUE),
       ('Marie Curie', 'marie.curie@example.com', crypt('mdp_marie456', gen_salt('bf')), FALSE),
       ('Albert Einstein', 'albert.einstein@example.com', crypt('mdp_albert789', gen_salt('bf')), TRUE),
       ('Ada Lovelace', 'ada.lovelace@example.com', crypt('mdp_ada012', gen_salt('bf')), FALSE),
       ('Alan Turing', 'alan.turing@example.com', crypt('mdp_alan345', gen_salt('bf')), FALSE);

INSERT INTO ingredient (nom, prix_achat, quantite_stock, unite, seuil_alerte)
VALUES ('Farine', 1.20, 100.00, 'kg', 20.00),
       ('Sucre', 0.80, 50.00, 'kg', 10.00),
       ('Beurre', 2.50, 30.00, 'kg', 5.00),
       ('Lait', 0.60, 200.00, 'L', 50.00),
       ('Levure', 0.10, 5.00, 'kg', 1.00),
       ('Œufs', 0.15, 300.00, 'pièces', 50.00),
       ('Chocolat', 3.00, 20.00, 'kg', 5.00),
       ('Sel', 0.50, 15.00, 'kg', 3.00),
       ('Crème', 1.80, 25.00, 'L', 5.00),
       ('Vanille', 5.00, 2.00, 'kg', 0.50);

INSERT INTO mouvement_stock (id_ingredient, id_produit, quantite_entree, quantite_sortie, date_mouvement)
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
