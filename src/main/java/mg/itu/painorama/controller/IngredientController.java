package mg.itu.painorama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/ingredients")
@Controller
public class IngredientController {

    @GetMapping("/fiche")
    public String fiche() {
	return "accueil";
    }

}
