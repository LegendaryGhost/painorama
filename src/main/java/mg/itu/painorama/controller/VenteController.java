package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Vente;
import mg.itu.painorama.service.CategorieService;
import mg.itu.painorama.service.ParfumService;
import mg.itu.painorama.service.ProduitService;
import mg.itu.painorama.service.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/ventes")
@Controller
public class VenteController {

    private final ProduitService produitService;
    private final VenteService venteService;
    private final CategorieService categorieService;
    private final ParfumService parfumService;

    @GetMapping
    public String listeVentes(@RequestParam(value = "idCategorie", required = false) Integer idCategorie,
	    @RequestParam(value = "idParfum", required = false) Integer idParfum,
	    Model model) {
	List<Vente> ventes = venteService.findByCriteria(idCategorie, idParfum);

	model.addAttribute("ventes", ventes);
	model.addAttribute("categories", categorieService.findAll());
	model.addAttribute("parfums", parfumService.findAll());
	return "ventes/liste";
    }

    @GetMapping("/ajouter")
    public String ajouterVente(Model model) {
	model.addAttribute("vente", new Vente());
	model.addAttribute("produits", produitService.findAll());

	return "ventes/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarVente(@ModelAttribute Vente vente) {
	venteService.create(vente);
	return "redirect:/ventes";
    }

}
