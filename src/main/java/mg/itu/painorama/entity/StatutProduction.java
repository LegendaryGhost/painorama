package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "statut_production")
public class StatutProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_statut_production", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false)
    private String nom;

}