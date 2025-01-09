package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Production;
import mg.itu.painorama.service.ProductionService;
import mg.itu.painorama.service.ProduitService;
import mg.itu.painorama.service.StatutProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/productions")
@Controller
public class ProductionController {

    private final ProductionService productionService;
    private final ProduitService produitService;
    private final StatutProductionService statutProductionService;

    @GetMapping
    public String listeProductions(Model model) {
	model.addAttribute("productions", productionService.findAll());
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
