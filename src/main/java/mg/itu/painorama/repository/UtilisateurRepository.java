package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    @Query("SELECT u FROM Utilisateur u WHERE u.email = :email")
    Utilisateur findByEmail(@Param("email") String email);

    @Query(value = "SELECT crypt(:motDePasse, mot_de_passe) = mot_de_passe FROM utilisateur WHERE email = :email", nativeQuery = true)
    boolean isPasswordCorrect(@Param("email") String email, @Param("motDePasse") String motDePasse);
}

