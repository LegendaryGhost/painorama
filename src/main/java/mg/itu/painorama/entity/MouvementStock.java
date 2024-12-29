package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "mouvement_stock")
public class MouvementStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "id_ingredient")
    private Ingredient idIngredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "id_produit")
    private Produit idProduit;

    @ColumnDefault("0")
    @Column(name = "quantite_entree", nullable = false, precision = 10, scale = 2)
    private Double quantiteEntree;

    @ColumnDefault("0")
    @Column(name = "quantite_sortie", nullable = false, precision = 10, scale = 2)
    private Double quantiteSortie;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "date_mouvement", nullable = false)
    private LocalDateTime dateMouvement;

}