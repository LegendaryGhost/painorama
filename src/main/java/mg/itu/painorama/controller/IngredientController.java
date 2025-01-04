package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Ingredient;
import mg.itu.painorama.entity.MouvementStock;
import mg.itu.painorama.service.IngredientService;
import mg.itu.painorama.service.MouvementStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/ingredients")
@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final MouvementStockService mouvementStockService;

    @GetMapping("/fiche")
    public String fiche() {
	return "accueil";
    }



    @GetMapping("/fiche/{id}")
    public String showIngredientFiche(@PathVariable Integer id, Model model) {
	Ingredient ingredient = ingredientService.findById(id);
	List<MouvementStock> mouvements = mouvementStockService.findByIngredientId(id);

	model.addAttribute("ingredient", ingredient);
	model.addAttribute("mouvements", mouvements);

	return "ingredients/fiche";
    }

}
