package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "unite")
public class Unite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_unite")
    private Integer id;

    @Column(name = "nom")
    private String nom;

}
