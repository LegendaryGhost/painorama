package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Production;
import mg.itu.painorama.service.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@RequestMapping("/productions")
@Controller
public class ProductionController {

    private final ProductionService productionService;
    private final ProduitService produitService;
    private final StatutProductionService statutProductionService;
    private final CategorieService categorieService;
    private final IngredientService ingredientService;

    @GetMapping
    public String listeProductions(@RequestParam(name = "idProduit", required = false) Integer idProduit,
	    @RequestParam(name = "idStatut", required = false) Integer idStatut,
	    @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
	    @RequestParam(name = "idCategorie", required = false) Integer idCategorie,
	    @RequestParam(name = "idIngredient", required = false) Integer idIngredient, Model model) {

	// Filtrer les données en fonction des critères
	List<Production> productions = productionService.findByCriteria(idProduit, idStatut, date, idCategorie,
		idIngredient);

	// Maintenire l'état du formulaire de recherche
	model.addAttribute("idProduit", idProduit);
	model.addAttribute("idStatut", idStatut);
	model.addAttribute("date", date);
	model.addAttribute("idCategorie", idCategorie);
	model.addAttribute("idIngredient", idIngredient);

	// Ajouter les données au modèle
	model.addAttribute("productions", productions);
	model.addAttribute("produits", produitService.findAll());
	model.addAttribute("statuts", statutProductionService.findAll());
	model.addAttribute("categories", categorieService.findAll());
	model.addAttribute("ingredients", ingredientService.findAll());
	return "productions/liste";
    }

    @GetMapping("/ajouter")
    public String ajouterProduction(Model model) {
	model.addAttribute("production", new Production());
	model.addAttribute("produits", produitService.findAll());
	model.addAttribute("statuts", statutProductionService.findAll());
	model.addAttribute("titrePage", "Ajouter une production");
	model.addAttribute("texteBouton", "Ajouter");
	return "productions/formulaire";
    }

    @GetMapping("/modifier/{id}")
    public String modifierProduction(@PathVariable("id") Integer id, Model model) {
	model.addAttribute("production", productionService.findById(id));
	model.addAttribute("produits", produitService.findAll());
	model.addAttribute("statuts", statutProductionService.findAll());
	model.addAttribute("titrePage", "Modifier une production");
	model.addAttribute("texteBouton", "Modifier");
	return "productions/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarProduction(@ModelAttribute Production production) {
	if (production.getId() == null) {
	    productionService.create(production);
	} else {
	    productionService.update(production);
	}
	return "redirect:/productions";
    }

    @GetMapping("/effacer/{id}")
    public String effacerProduction(@PathVariable("id") Integer id) {
	productionService.delete(id);
	return "redirect:/productions";
    }

}
