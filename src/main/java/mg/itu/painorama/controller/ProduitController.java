package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/produits")
@Controller
public class ProduitController {

    @GetMapping
    public String listeProduits() {
        return "produits/liste";
    }

}
