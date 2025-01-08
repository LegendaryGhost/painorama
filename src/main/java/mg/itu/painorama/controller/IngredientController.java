package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Ingredient;
import mg.itu.painorama.entity.MouvementStock;
import mg.itu.painorama.service.IngredientService;
import mg.itu.painorama.service.MouvementStockService;
import mg.itu.painorama.service.UniteService;
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
    private final UniteService uniteService;

    @GetMapping
    public String listeIngredients(Model model) {
	model.addAttribute("ingredients", ingredientService.findAll());
	return "ingredients/liste"; // Vue pour la liste
    }

    @GetMapping("/fiche/{id}")
    public String ficheIngredient(@PathVariable("id") Integer id, Model model) {
	Ingredient ingredient = ingredientService.findById(id);
	List<MouvementStock> mouvements = mouvementStockService.findByIngredientId(id);

	model.addAttribute("ingredient", ingredient);
	model.addAttribute("mouvements", mouvements);

	return "ingredients/fiche";
    }

    @GetMapping("/ajouter")
    public String ajouterIngredient(Model model) {
	model.addAttribute("ingredient", new Ingredient());
	model.addAttribute("unites", uniteService.findAll());
	model.addAttribute("titrePage", "Ajouter un ingrédient");
	model.addAttribute("texteBouton", "Ajouter");
	return "ingredients/formulaire";
    }

    @GetMapping("/modifier/{id}")
    public String modifierIngredient(@PathVariable("id") Integer id, Model model) {
	model.addAttribute("ingredient", ingredientService.findById(id));
	model.addAttribute("unites", uniteService.findAll());
	model.addAttribute("titrePage", "Modifier un ingredient");
	model.addAttribute("texteBouton", "Modifier");
	return "ingredients/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderIngredient(@ModelAttribute Ingredient ingredient) {
	if (ingredient.getId() == null) {
	    ingredientService.create(ingredient);
	} else {
	    ingredientService.update(ingredient);
	}
	return "redirect:/ingredients";
    }

    @GetMapping("/effacer/{id}")
    public String effacerIngredient(@PathVariable("id") Integer id) {
	ingredientService.delete(id);
	return "redirect:/ingredients";
    }

}
