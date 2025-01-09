package mg.itu.painorama.repository;

import mg.itu.painorama.entity.Ingredient;
import mg.itu.painorama.entity.MouvementStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MouvementStockRepository extends JpaRepository<MouvementStock, Integer> {

    List<MouvementStock> findByIngredientOrderByDateHeureDesc(Ingredient ingredient);

}
