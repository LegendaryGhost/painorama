package mg.itu.painorama.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

@Data
@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "mot_de_passe", nullable = false)
    private String motDePasse;

    @ColumnDefault("false")
    @Column(name = "est_admin", nullable = false)
    private Boolean estAdmin = false;

}