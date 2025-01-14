package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Recette;
import mg.itu.painorama.service.IngredientService;
import mg.itu.painorama.service.ProduitService;
import mg.itu.painorama.service.RecetteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/recettes")
@Controller
public class RecetteController {

    private final IngredientService ingredientService;
    private final RecetteService recetteService;
    private final ProduitService produitService;

    @GetMapping("/ajouter")
    public String ajouterRecette(Model model) {
	model.addAttribute("recette", new Recette());
	model.addAttribute("ingredients", ingredientService.findAll());
	model.addAttribute("produits", produitService.findAll());

	return "recettes/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderRecette(@ModelAttribute Recette recette) {
	recetteService.create(recette);
	return "redirect:/produits";
    }

}
