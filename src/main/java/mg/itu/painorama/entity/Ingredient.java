package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingredient", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prix_achat", nullable = false)
    private Double prixAchat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_unite")
    private Unite unite;

}