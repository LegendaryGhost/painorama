package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.entity.Produit;
import mg.itu.painorama.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/produits")
@Controller
public class ProduitController {

    private final ProduitService produitService;
    private final CategorieService categorieService;
    private final ParfumService parfumService;
    private final MouvementStockService mouvementStockService;
    private final RecetteService recetteService;

    @GetMapping
    public String listeProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "produits/liste";
    }

    @GetMapping("/ajouter")
    public String ajouterProduit(Model model) {
        model.addAttribute("produit", new Produit());
        model.addAttribute("categories", categorieService.findAll());
        model.addAttribute("parfums", parfumService.findAll());
        model.addAttribute("titrePage", "Ajouter un produit");
        model.addAttribute("texteBouton", "Ajouter");
        return "produits/formulaire";
    }

    @GetMapping("/modifier/{id}")
    public String modifierProduit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("produit", produitService.findById(id));
        model.addAttribute("categories", categorieService.findAll());
        model.addAttribute("parfums", parfumService.findAll());
        model.addAttribute("titrePage", "Modifier un produit");
        model.addAttribute("texteBouton", "Modifier");
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
    public String effacerProduit(@PathVariable("id") Integer id) {
        produitService.delete(id);
        return "redirect:/produits";
    }

    @GetMapping("/fiche/{id}")
    public String ficheProduit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("produit", produitService.findById(id));
        model.addAttribute("mouvements", mouvementStockService.findByIdProduit(id));
        model.addAttribute("recettes", recetteService.findByIdProduit(id));
        return "produits/fiche";
    }

}
