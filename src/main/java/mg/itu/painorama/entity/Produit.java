package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prix_vente", nullable = false)
    private Double prixVente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categorie", nullable = false)
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_parfum", nullable = false)
    private Parfum parfum;

    @OneToMany(mappedBy = "produit", fetch = FetchType.LAZY)
    private List<Recette> recettes;

}