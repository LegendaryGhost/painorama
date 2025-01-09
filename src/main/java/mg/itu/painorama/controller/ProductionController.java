package mg.itu.painorama.controller;

import lombok.AllArgsConstructor;
import mg.itu.painorama.service.ProductionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("/productions")
@Controller
public class ProductionController {

    private final ProductionService productionService;

    @GetMapping
    public String productions(Model model) {
	model.addAttribute("productions", productionService.findAll());
	return "productions/liste";
    }

}
