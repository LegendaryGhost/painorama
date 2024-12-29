package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Integer> {
}
