package mg.itu.painorama.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Ingredient;
import mg.itu.painorama.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
	return ingredientRepository.findAll();
    }

    public Ingredient findById(Integer id) {
	return ingredientRepository.findById(id)
		.orElseThrow(() -> new EntityNotFoundException("Ingrédient introuvable avec l'ID " + id));
    }

    public void create(Ingredient ingredient) {
	ingredientRepository.save(ingredient);
    }

    public void update(Ingredient ingredient) {
	ingredientRepository.save(ingredient);
    }

    public void delete(Integer id) {
	ingredientRepository.deleteById(id);
    }
}
