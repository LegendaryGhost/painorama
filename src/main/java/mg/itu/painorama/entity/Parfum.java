package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parfum")
public class Parfum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parfum")
    private Integer id;

    @Column(name = "nom")
    private String nom;

}
