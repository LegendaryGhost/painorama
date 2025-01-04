package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRepository extends JpaRepository<Production, Integer> {
}
