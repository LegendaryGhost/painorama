INSERT INTO utilisateur (nom, email, mot_de_passe, est_admin)
VALUES
    ('Jean Dupont', 'jean.dupont@example.com', crypt('mdp_jean123', gen_salt('bf')), TRUE),
    ('Marie Curie', 'marie.curie@example.com', crypt('mdp_marie456', gen_salt('bf')), FALSE),
    ('Albert Einstein', 'albert.einstein@example.com', crypt('mdp_albert789', gen_salt('bf')), TRUE),
    ('Ada Lovelace', 'ada.lovelace@example.com', crypt('mdp_ada012', gen_salt('bf')), FALSE),
    ('Alan Turing', 'alan.turing@example.com', crypt('mdp_alan345', gen_salt('bf')), FALSE);
