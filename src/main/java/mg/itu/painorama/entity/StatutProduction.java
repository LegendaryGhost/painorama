package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "statut_production")
public class StatutProduction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 20)
    private String nom;

}