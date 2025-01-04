package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Ingredient;
import mg.itu.painorama.entity.MouvementStock;
import mg.itu.painorama.service.IngredientService;
import mg.itu.painorama.service.MouvementStockService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/ingredients")
@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final MouvementStockService mouvementStockService;

    @GetMapping
    public String listIngredients(Model model) {
	model.addAttribute("ingredients", ingredientService.findAll());
	return "ingredients/liste"; // Vue pour la liste
    }

    @GetMapping("/fiche/{id}")
    public String showIngredientFiche(@PathVariable Integer id, Model model) {
	Ingredient ingredient = ingredientService.findById(id);
	List<MouvementStock> mouvements = mouvementStockService.findByIngredientId(id);

	model.addAttribute("ingredient", ingredient);
	model.addAttribute("mouvements", mouvements);

	return "ingredients/fiche";
    }

    @GetMapping("/ajout")
    public String showAddIngredientForm(Model model) {
	model.addAttribute("ingredient", new Ingredient());
	return "ingredients/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String addIngredient(@ModelAttribute Ingredient ingredient) {
	ingredientService.save(ingredient);
	return "redirect:/ingredients";
    }

}
