package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Produit;
import mg.itu.painorama.service.CategorieService;
import mg.itu.painorama.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/produits")
@Controller
public class ProduitController {

    private final ProduitService produitService;
    private final CategorieService categorieService;

    @GetMapping
    public String listeProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "produits/liste";
    }

    @GetMapping("/ajouter")
    public String ajouterProduit(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("categories", categorieService.findAll());
        model.addAttribute("titrePage", "Ajouter un produit");
        model.addAttribute("texteBouton", "Ajouter");
        return "produits/formulaire";
    }

    @PostMapping("/sauvegarder")
    public String sauvegarderProduit(@ModelAttribute Produit produit) {
        if (produit.getId() == null) {
            produitService.create(produit);
        } else {
            produitService.update(produit);
        }
        return "redirect:/produits";
    }

    @GetMapping("/effacer/{id}")
    public String effacerProduit(@PathVariable Integer id) {
        produitService.delete(id);
        return "redirect:/produits";
    }

}
