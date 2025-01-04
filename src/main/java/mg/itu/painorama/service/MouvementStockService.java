package mg.itu.painorama.service;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Ingredient;
import mg.itu.painorama.entity.MouvementStock;
import mg.itu.painorama.repository.MouvementStockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MouvementStockService {

    private final MouvementStockRepository mouvementStockRepository;

    public List<MouvementStock> findByIngredientId(Integer ingredientId) {
	Ingredient ingredient = new Ingredient();
	ingredient.setId(ingredientId);
	return mouvementStockRepository.findByIngredientOrderByDateMouvementDesc(ingredient);
    }

}
