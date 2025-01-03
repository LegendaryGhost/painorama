package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prix_vente", nullable = false)
    private Double prixVente;

    @ColumnDefault("0")
    @Column(name = "cout_revient", nullable = false)
    private Double coutRevient;

}