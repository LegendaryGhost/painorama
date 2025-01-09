package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductionRepository extends JpaRepository<Production, Integer>, JpaSpecificationExecutor<Production> {
}
