package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.dto.ProduitConseilRequest;
import mg.itu.painorama.service.MonthService;
import mg.itu.painorama.service.ProduitConseilService;
import mg.itu.painorama.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RequestMapping("/produits-conseil")
@Controller
public class ProduitConseilController {

    private final MonthService monthService;
    private final ProduitService produitService;
    private final ProduitConseilService produitConseilService;

    @GetMapping
    public String listeProduitsConseil(@RequestParam(value = "mois", required = false) Integer mois,
	    @RequestParam(value = "annee", required = false) Integer annee, Model model) {

	// Définir le mois et l'année actuels si null
	LocalDate today = LocalDate.now();
	mois = (mois != null) ? mois : today.getMonthValue();
	annee = (annee != null) ? annee : today.getYear();

	model.addAttribute("produitsConseil", produitConseilService.findByMonthAndYear(mois, annee));
	model.addAttribute("listeMois", monthService.getMonthsInFrench());
	model.addAttribute("mois", mois);
	model.addAttribute("annee", annee);

	return "produits-conseil/liste";
    }

    @GetMapping("/historique")
    public String listeProduitsConseil(Model model) {
	model.addAttribute("produitsConseil", produitConseilService.findByYear(2024));
	model.addAttribute("listeMois", monthService.getMonthsInFrench());

	return "produits-conseil/liste-total";
    }

    @GetMapping("/ajouter")
    public String ajouterProduitConseil(Model model) {
	model.addAttribute("produitConseilRequest", new ProduitConseilRequest());
	model.addAttribute("produits", produitService.findAll());
	model.addAttribute("listeMois", monthService.getMonthsInFrench());

	return "produits-conseil/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarder(@ModelAttribute ProduitConseilRequest request) {
	produitConseilService.create(request);
	return "redirect:/produits-conseil";
    }

}
