package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Vente;
import mg.itu.painorama.service.ProduitService;
import mg.itu.painorama.service.VenteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/ventes")
@Controller
public class VenteController {

    private final ProduitService produitService;
    private final VenteService venteService;

    @GetMapping("/ajout")
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
