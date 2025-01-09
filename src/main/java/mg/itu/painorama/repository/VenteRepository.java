package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepository extends JpaRepository<Vente, Integer> {
}
