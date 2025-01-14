package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.repository.ProduitConseilRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/produits-conseil")
@Controller
public class ProduitConseilController {

    private final ProduitConseilRepository produitConseilRepository;

    @GetMapping
    public String listeProduitsConseil(Model model) {
	model.addAttribute("produitsConseil", produitConseilRepository.findAll());
	return "produits-conseil/liste";
    }

}
