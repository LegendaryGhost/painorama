package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prix_achat", nullable = false, precision = 10, scale = 2)
    private Double prixAchat;

    @ColumnDefault("0")
    @Column(name = "quantite_stock", nullable = false, precision = 10, scale = 2)
    private Double quantiteStock;

    @Column(name = "unite", nullable = false, length = 20)
    private String unite;

    @Column(name = "seuil_alerte", nullable = false, precision = 10, scale = 2)
    private Double seuilAlerte;

}