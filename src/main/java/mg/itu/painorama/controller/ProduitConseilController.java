package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.dto.ProduitConseilRequest;
import mg.itu.painorama.repository.ProduitConseilRepository;
import mg.itu.painorama.service.MonthService;
import mg.itu.painorama.service.ProduitConseilService;
import mg.itu.painorama.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/produits-conseil")
@Controller
public class ProduitConseilController {

    private final ProduitConseilRepository produitConseilRepository;
    private final MonthService monthService;
    private final ProduitService produitService;
    private final ProduitConseilService produitConseilService;

    @GetMapping
    public String listeProduitsConseil(Model model) {
	model.addAttribute("produitsConseil", produitConseilRepository.findAll());
	return "produits-conseil/liste";
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
