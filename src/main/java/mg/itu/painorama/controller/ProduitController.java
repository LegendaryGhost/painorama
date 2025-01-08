package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.service.ProduitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/produits")
@Controller
public class ProduitController {

    private final ProduitService produitService;

    @GetMapping
    public String listeProduits(Model model) {
        model.addAttribute("produits", produitService.findAll());
        return "produits/liste";
    }

}
